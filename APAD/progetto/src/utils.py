from pathlib import Path

import networkx as nx
import pandas as pd


# Etichette usate per distinguere i due lati del grafo bipartito.
AUTHOR_KIND = "author"
PUBLICATION_KIND = "publication"

# ------------------------
# QUESTION 2.(ii) Bottom-k
# ------------------------


def simple_hash(x, seed=0, m=2**32):
    """
    Hash semplice richiesto dalla traccia.

    Restituisce un valore in [0, 1), usato come ranking dell'elemento.
    Cambiando seed si ottiene una diversa permutazione implicita.
    """
    h = seed
    for c in str(x):
        h = (31 * h + ord(c)) % m
    return h / m


class BottomKSketch:
    """
    Sketch Bottom-k per insiemi di stringhe.

    Conserva i k elementi con hash piu' piccolo. Lo stesso seed deve essere
    usato per confrontare sketch diversi, altrimenti i ranking non coincidono.
    """

    def __init__(self, k, seed=0, m=2**32):
        if k < 2:
            raise ValueError("k must be at least 2")

        self.k = k
        self.seed = seed
        self.m = m
        self._ranks = {}

    def _rank(self, element):
        return simple_hash(element, seed=self.seed, m=self.m)

    def update(self, element):
        """UPDATE: aggiunge un elemento solo se entra nei bottom-k."""
        element = str(element)
        if element in self._ranks:
            return

        # il rank rappresenta la posizione dell'elemento nella permutazione implicita.
        rank = self._rank(element)
        if len(self._ranks) < self.k:
            self._ranks[element] = rank
            return

        # il peggiore elemento nello sketch e' quello con ranking piu' grande.
        worst_element = None
        worst_rank = -1
        for current_element, current_rank in self._ranks.items():
            if current_rank > worst_rank:
                worst_element = current_element
                worst_rank = current_rank

        if rank < worst_rank:
            del self._ranks[worst_element]
            self._ranks[element] = rank

    def build(self, elements):
        for element in elements:
            self.update(element)

    def union(self, other):
        """UNION: prende i k elementi con rank minimo in S(A) unito S(B)."""
        self._check_compatible(other)

        # Uniamo i due sketch gia' ridotti, poi teniamo di nuovo solo i bottom-k.
        all_ranks = {}
        for element, rank in self._ranks.items():
            all_ranks[element] = rank
        for element, rank in other._ranks.items():
            all_ranks[element] = rank

        # Ordinare per rank crescente significa mettere prima gli elementi migliori.
        sorted_items = sorted(all_ranks.items(), key=lambda item: item[1])

        result = BottomKSketch(self.k, self.seed, self.m)
        for element, rank in sorted_items[: self.k]:
            result._ranks[element] = rank
        return result

    def kth(self):
        """Restituisce il k-esimo rank, cioe' il massimo rank nello sketch."""
        if not self._ranks:
            return None

        # Nello sketch sono rimasti i k rank piu' piccoli, quindi il massimo e' kth.
        maximum = 0
        for rank in self._ranks.values():
            if rank > maximum:
                maximum = rank
        return maximum

    def size(self):
        """SIZE: stima la cardinalita' con (k - 1) / kth(A)."""
        # Se lo sketch non e' pieno, contiene tutti gli elementi distinti visti.
        if len(self._ranks) < self.k:
            return len(self._ranks)

        kth_rank = self.kth()
        if kth_rank == 0:
            return float("inf")
        return (self.k - 1) / kth_rank

    def jaccard(self, other):
        """Stima il coefficiente di Jaccard usando lo sketch dell'unione."""
        union_sketch = self.union(other)

        if not union_sketch._ranks:
            return 1.0

        # Nel campione dell'unione, stimiamo la frazione presente in entrambi.
        common = 0
        for element in union_sketch._ranks:
            if element in self._ranks and element in other._ranks:
                common += 1

        return common / len(union_sketch._ranks)

    def _check_compatible(self, other):
        if self.k != other.k or self.seed != other.seed or self.m != other.m:
            raise ValueError("Sketches must have same k, seed and m")


def author_key(author_name):
    # Gli autori hanno la stessa chiave in tutti i dataset, utile per il grafo unione.
    return f"{AUTHOR_KIND}:{author_name}"


def publication_key(dataset_name, publication_id):
    # Il nome del dataset evita conflitti tra pubblicazioni con lo stesso id.
    return f"{PUBLICATION_KIND}:{dataset_name}:{publication_id}"


def split_authors(authors_value):
    if pd.isna(authors_value):
        return []

    authors = []
    for author in str(authors_value).split("|"):
        author = author.strip()
        if author:
            authors.append(author)
    return authors


def parse_year(year_value):
    if pd.isna(year_value):
        return None

    for part in str(year_value).split("|"):
        part = part.strip()
        if part.isdigit():
            return int(part)
    return None


def _clean_value(value):
    if pd.isna(value):
        return None

    value = str(value).strip()
    if value == "":
        return None
    return value


def _add_node(graph, string_to_node, node_to_string, key, **attrs):
    # Crea un nuovo id numerico solo se la chiave non era gia' nota.
    if key not in string_to_node:
        node_id = len(node_to_string)
        string_to_node[key] = node_id
        node_to_string[node_id] = key
    else:
        node_id = string_to_node[key]

    if not graph.has_node(node_id):
        graph.add_node(node_id, key=key, **attrs)

    return node_id


def build_bipartite_graph(
    csv_path,
    dataset_name=None,
    venue_col=None,
    chunksize=100_000,
    max_rows=None,
    max_year=None,
    string_to_node=None,
    node_to_string=None,
):
    """
    Costruisce il grafo bipartito autore-pubblicazione per un CSV DBLP.

    Restituisce:
        graph, string_to_node, node_to_string

    I dizionari possono essere riusati per costruire altri dataset. In questo
    modo gli autori uguali mantengono lo stesso id numerico, mentre le
    pubblicazioni restano distinte perche' la chiave contiene anche il dataset.
    """
    csv_path = Path(csv_path)
    if dataset_name is None:
        dataset_name = csv_path.stem.replace("out-dblp_", "")

    if string_to_node is None:
        string_to_node = {}
    if node_to_string is None:
        node_to_string = {}

    # Leggiamo prima solo l'intestazione per caricare dal CSV solo le colonne utili.
    header = pd.read_csv(csv_path, sep=";", nrows=0).columns
    wanted_columns = ["id", "author", "year", "title", "pages", "publisher"]
    if venue_col is not None:
        wanted_columns.append(venue_col)

    # decide quali colonne leggere dal CSV
    usecols = []
    for col in wanted_columns:
        # Evita duplicati quando venue_col coincide con una colonna gia' richiesta.
        if col in header and col not in usecols:
            usecols.append(col)
    if "id" not in usecols or "author" not in usecols:
        raise ValueError(f"{csv_path} must contain at least 'id' and 'author'")

    graph = nx.Graph(dataset=dataset_name)
    # La lettura a chunk evita di caricare interamente in memoria i CSV grandi.
    reader = pd.read_csv(
        csv_path,
        sep=";",
        usecols=usecols,
        dtype=str,
        chunksize=chunksize,
        nrows=max_rows,
        on_bad_lines="skip",
    )

    for chunk in reader:
        columns = list(chunk.columns)
        # Salviamo gli indici una volta per chunk: e' piu' veloce di cercarli per ogni riga.
        id_index = columns.index("id")
        author_index = columns.index("author")
        year_index = columns.index("year") if "year" in columns else None
        title_index = columns.index("title") if "title" in columns else None
        pages_index = columns.index("pages") if "pages" in columns else None
        publisher_index = columns.index("publisher") if "publisher" in columns else None
        venue_index = columns.index(venue_col) if venue_col in columns else None

        for row in chunk.itertuples(index=False, name=None):
            publication_id = _clean_value(row[id_index])
            if publication_id is None:
                continue

            title = _clean_value(row[title_index]) if title_index is not None else None
            publisher = (
                _clean_value(row[publisher_index])
                if publisher_index is not None
                else None
            )
            pages = _clean_value(row[pages_index]) if pages_index is not None else None
            venue = _clean_value(row[venue_index]) if venue_index is not None else None
            year = parse_year(row[year_index]) if year_index is not None else None
            if max_year is not None and (year is None or year > max_year):
                continue

            pub_node = _add_node(
                graph,
                string_to_node,
                node_to_string,
                publication_key(dataset_name, publication_id),
                label=title or publication_id,
                kind=PUBLICATION_KIND,
                bipartite=1,
                dataset=dataset_name,
                publication_id=publication_id,
                title=title,
                year=year,
                pages=pages,
                publisher=publisher,
                venue=venue,
            )

            for author_name in split_authors(row[author_index]):
                author_node = _add_node(
                    graph,
                    string_to_node,
                    node_to_string,
                    author_key(author_name),
                    label=author_name,
                    kind=AUTHOR_KIND,
                    bipartite=0,
                    name=author_name,
                )
                # L'arco rappresenta la relazione "questo autore ha scritto questa pubblicazione".
                graph.add_edge(author_node, pub_node)

    return graph, string_to_node, node_to_string

