from pathlib import Path
from collections import defaultdict, deque
from itertools import combinations
import random
import time

import networkx as nx
import pandas as pd

try:
    from .utils import (
        AUTHOR_KIND,
        PUBLICATION_KIND,
        BottomKSketch,
        build_bipartite_graph,
        split_authors,
    )
except ImportError:
    from utils import (
        AUTHOR_KIND,
        PUBLICATION_KIND,
        BottomKSketch,
        build_bipartite_graph,
        split_authors,
    )

# punta alla cartella padre del file corrente
BASE_DIR = Path(__file__).resolve().parents[1]
CSV_DIR = BASE_DIR / "csv"
RESULTS_DIR = BASE_DIR / "results"


DATASETS = {
    "article": {"file": CSV_DIR / "out-dblp_article.csv", "venue_col": "journal"},
    "book": {"file": CSV_DIR / "out-dblp_book.csv", "venue_col": None},
    "incollection": {
        "file": CSV_DIR / "out-dblp_incollection.csv",
        "venue_col": "booktitle",
    },
    "inproceedings": {
        "file": CSV_DIR / "out-dblp_inproceedings.csv",
        "venue_col": "booktitle",
    },
    "mastersthesis": {
        "file": CSV_DIR / "out-dblp_mastersthesis.csv",
        "venue_col": None,
    },
    "phdthesis": {"file": CSV_DIR / "out-dblp_phdthesis.csv", "venue_col": None},
    "proceedings": {"file": CSV_DIR / "out-dblp_proceedings.csv", "venue_col": "title"},
}


def add_execution_time(rows, start_time):
    """Aggiunge ai risultati il tempo totale della run, in secondi."""
    execution_time = time.perf_counter() - start_time
    execution_time = round(execution_time, 3)

    for row in rows:
        row["execution_time_seconds"] = execution_time

    return execution_time


# -----------
# QUESTION 1.I
# -----------

YEAR_LIMITS = [1960, 1970, 1980, 1990, 2000, 2010, 2020, 2023]


def publication_authors(graph, publication_node):
    """Restituisce gli autori collegati a una pubblicazione."""
    authors = []
    for neighbor in graph.neighbors(publication_node):
        # questo controllo non e' strettamente necessario poiche' si tratta di un grafo bipartito.
        if graph.nodes[neighbor].get("kind") == AUTHOR_KIND:
            authors.append(neighbor)
    return authors


def solve_question_1_i_for_graph(graph, dataset_name, year_limits=YEAR_LIMITS):
    """
    QUESTION 1.I:
    autore che ha scritto piu' pubblicazioni da solo, per ogni limite di anno.
    """
    results = []

    for year_limit in year_limits:
        solo_papers_by_author = defaultdict(int)

        for node, data in graph.nodes(data=True):
            if data.get("kind") != PUBLICATION_KIND:
                continue

            year = data.get("year")
            if year is None or year > year_limit:
                continue

            authors = publication_authors(graph, node)
            if len(authors) == 1:
                solo_papers_by_author[authors[0]] += 1

        if solo_papers_by_author:
            # In caso di parita' scegliamo il nome alfabeticamente minore.
            best_author_node = min(
                solo_papers_by_author,
                key=lambda author_node: (
                    -solo_papers_by_author[author_node],
                    graph.nodes[author_node].get("name", ""),
                ),
            )
            best_author = graph.nodes[best_author_node].get("name")
            best_count = solo_papers_by_author[best_author_node]
        else:
            best_author = None
            best_count = 0

        results.append(
            {
                "dataset": dataset_name,
                "year_limit": year_limit,
                "author": best_author,
                "solo_publications": best_count,
            }
        )

    return results


def question_1_i(max_rows_per_dataset=None):
    start_time = time.perf_counter()
    results = []

    for dataset_name, config in DATASETS.items():
        print(f"QUESTION 1.I - building graph for {dataset_name}")
        graph, _, _ = build_bipartite_graph(
            config["file"],
            dataset_name=dataset_name,
            venue_col=config.get("venue_col"),
            max_rows=max_rows_per_dataset,
        )
        results.extend(solve_question_1_i_for_graph(graph, dataset_name))

    execution_time = add_execution_time(results, start_time)
    output_path = RESULTS_DIR / "question_1_i.csv"
    RESULTS_DIR.mkdir(exist_ok=True)
    df = pd.DataFrame(results)
    df.to_csv(output_path, index=False)
    print(f"QUESTION 1.I - results saved in {output_path}")
    print(f"QUESTION 1.I - execution time: {execution_time} seconds")
    return df


# ------------------------
# QUESTION 2.(ii) Bottom-k
# ------------------------

# Si trova nel file utils.py

# -------------
# QUESTION 3.I
# -------------

SKETCH_SIZES = [64, 128, 256, 512]


def relative_error(estimated, exact):
    if exact == 0:
        if estimated == 0:
            return 0
        return None
    return abs(estimated - exact) / exact


def exact_jaccard(set_a, set_b):
    union_size = len(set_a | set_b)
    if union_size == 0:
        return 1
    return len(set_a & set_b) / union_size


def build_author_sets_and_sketches(
    sketch_sizes=SKETCH_SIZES,
    seed=0,
    chunksize=100_000,
    max_rows_per_dataset=None,
):
    author_sets = {}
    sketches = {}

    for dataset_name, config in DATASETS.items():
        print(f"QUESTION 3.I - reading authors for {dataset_name}")

        author_sets[dataset_name] = set()
        sketches[dataset_name] = {}
        for k in sketch_sizes:
            sketches[dataset_name][k] = BottomKSketch(k=k, seed=seed)

        reader = pd.read_csv(
            config["file"],
            sep=";",
            usecols=["author"],
            dtype=str,
            chunksize=chunksize,
            nrows=max_rows_per_dataset,
            on_bad_lines="skip",
        )

        for chunk in reader:
            for row in chunk.itertuples(index=False):
                for author in split_authors(row.author):
                    if author in author_sets[dataset_name]:
                        continue

                    author_sets[dataset_name].add(author)
                    for k in sketch_sizes:
                        sketches[dataset_name][k].update(author)

    return author_sets, sketches


def question_3_i(sketch_sizes=SKETCH_SIZES, seed=0, max_rows_per_dataset=None):
    start_time = time.perf_counter()
    author_sets, sketches = build_author_sets_and_sketches(
        sketch_sizes=sketch_sizes,
        seed=seed,
        max_rows_per_dataset=max_rows_per_dataset,
    )

    size_results = []
    for dataset_name in DATASETS:
        exact_size = len(author_sets[dataset_name])

        for k in sketch_sizes:
            estimated_size = sketches[dataset_name][k].size()
            size_results.append(
                {
                    "dataset": dataset_name,
                    "k": k,
                    "seed": seed,
                    "exact_distinct_authors": exact_size,
                    "estimated_distinct_authors": estimated_size,
                    "relative_error": relative_error(estimated_size, exact_size),
                }
            )

    jaccard_results = []
    for dataset_a, dataset_b in combinations(DATASETS.keys(), 2):
        exact_value = exact_jaccard(author_sets[dataset_a], author_sets[dataset_b])

        for k in sketch_sizes:
            estimated_value = sketches[dataset_a][k].jaccard(sketches[dataset_b][k])
            jaccard_results.append(
                {
                    "dataset_a": dataset_a,
                    "dataset_b": dataset_b,
                    "k": k,
                    "seed": seed,
                    "exact_jaccard": exact_value,
                    "estimated_jaccard": estimated_value,
                    "absolute_error": abs(estimated_value - exact_value),
                }
            )

    execution_time = add_execution_time(size_results, start_time)
    for row in jaccard_results:
        row["execution_time_seconds"] = execution_time

    RESULTS_DIR.mkdir(exist_ok=True)

    size_df = pd.DataFrame(size_results)
    size_output_path = RESULTS_DIR / "question_3_i_size.csv"
    size_df.to_csv(size_output_path, index=False)

    jaccard_df = pd.DataFrame(jaccard_results)
    jaccard_output_path = RESULTS_DIR / "question_3_i_jaccard.csv"
    jaccard_df.to_csv(jaccard_output_path, index=False)

    print(f"QUESTION 3.I - size results saved in {size_output_path}")
    print(f"QUESTION 3.I - jaccard results saved in {jaccard_output_path}")
    print(f"QUESTION 3.I - execution time: {execution_time} seconds")

    return size_df, jaccard_df


# -------------
# QUESTION 4.2
# -------------

DEFAULT_DISTANCE_SAMPLE_SIZE = 16


def bfs_distances(graph, source):
    """Calcola le distanze da source con BFS."""
    distances = {source: 0}
    queue = deque([source])

    while queue:
        node = queue.popleft()

        for neighbor in graph.neighbors(node):
            if neighbor not in distances:
                distances[neighbor] = distances[node] + 1
                queue.append(neighbor)

    return distances


def largest_connected_component_nodes(graph):
    """Restituisce i nodi della componente connessa piu' grande."""
    visited = set()
    largest_component = set()

    for start in graph.nodes:
        if start in visited:
            continue

        component = set()
        queue = deque([start])
        visited.add(start)

        while queue:
            node = queue.popleft()
            component.add(node)

            for neighbor in graph.neighbors(node):
                if neighbor not in visited:
                    visited.add(neighbor)
                    queue.append(neighbor)

        if len(component) > len(largest_component):
            largest_component = component

    return largest_component


def approximate_average_distance(
    graph,
    component_nodes,
    sample_size,
    seed=0,
    progress_label=None,
):
    """
    Approssima la distanza media campionando vertici nella componente.

    Per ogni sorgente campionata fa una BFS e calcola la distanza media da
    quella sorgente a tutti gli altri nodi della componente.
    """
    n = len(component_nodes)
    if n <= 1:
        return 0

    nodes = sorted(component_nodes)
    random_generator = random.Random(seed)
    sample_count = min(sample_size, n)
    sampled_nodes = random_generator.sample(nodes, sample_count)

    total = 0
    for index, source in enumerate(sampled_nodes, start=1):
        if progress_label is not None:
            print(f"{progress_label} - BFS {index}/{sample_count}", flush=True)

        distances = bfs_distances(graph, source)
        total += sum(distances.values())

    return total / (sample_count * (n - 1))


def count_edges_in_component(graph, component_nodes):
    """Conta gli archi interni alla componente senza creare un sottografo."""
    edge_count = 0

    for node in component_nodes:
        for neighbor in graph.neighbors(node):
            if neighbor in component_nodes and node < neighbor:
                edge_count += 1

    return edge_count


def graph_up_to_year(graph, year_limit):
    """Tiene le pubblicazioni fino a year_limit e gli autori collegati."""
    nodes_to_keep = set()

    for node, data in graph.nodes(data=True):
        if data.get("kind") != PUBLICATION_KIND:
            continue

        year = data.get("year")
        if year is None or year > year_limit:
            continue

        nodes_to_keep.add(node)
        for neighbor in graph.neighbors(node):
            nodes_to_keep.add(neighbor)

    return graph.subgraph(nodes_to_keep)


def solve_question_4_2_for_graph(graph, dataset_name, year_limit, sample_size, seed):
    component_nodes = largest_connected_component_nodes(graph)
    average_distance = approximate_average_distance(
        graph,
        component_nodes,
        sample_size,
        seed=seed,
        progress_label=f"QUESTION 4.2 - {dataset_name}, year <= {year_limit}",
    )

    return {
        "dataset": dataset_name,
        "year_limit": year_limit,
        "nodes": graph.number_of_nodes(),
        "edges": graph.number_of_edges(),
        "largest_component_nodes": len(component_nodes),
        "largest_component_edges": count_edges_in_component(graph, component_nodes),
        "sample_size": min(sample_size, len(component_nodes)),
        "seed": seed,
        "estimated_average_distance": average_distance,
    }


def question_4_2(
    sample_size=DEFAULT_DISTANCE_SAMPLE_SIZE,
    seed=0,
    max_rows_per_dataset=None,
    year_limits=YEAR_LIMITS,
):
    start_time = time.perf_counter()
    results = []

    for dataset_name, config in DATASETS.items():
        print(f"QUESTION 4.2 - building graph for {dataset_name}")
        full_graph, _, _ = build_bipartite_graph(
            config["file"],
            dataset_name=dataset_name,
            venue_col=config.get("venue_col"),
            max_rows=max_rows_per_dataset,
            max_year=max(year_limits),
        )

        for year_limit in year_limits:
            print(f"QUESTION 4.2 - {dataset_name}, year <= {year_limit}")
            graph = graph_up_to_year(full_graph, year_limit)
            results.append(
                solve_question_4_2_for_graph(
                    graph,
                    dataset_name,
                    year_limit,
                    sample_size,
                    seed,
                )
            )

    execution_time = add_execution_time(results, start_time)
    RESULTS_DIR.mkdir(exist_ok=True)
    output_path = RESULTS_DIR / "question_4_2.csv"
    df = pd.DataFrame(results)
    df.to_csv(output_path, index=False)
    print(f"QUESTION 4.2 - results saved in {output_path}")
    print(f"QUESTION 4.2 - execution time: {execution_time} seconds")
    return df


# ----------
# QUESTION 5
# ----------


def build_union_bipartite_graph(max_rows_per_dataset=None, max_year=None):
    """Costruisce il grafo bipartito unione di tutti i dataset."""
    union_graph = nx.Graph(dataset="union")
    string_to_node = {}
    node_to_string = {}

    for dataset_name, config in DATASETS.items():
        print(f"QUESTION 5 - adding {dataset_name} to union graph")
        graph, string_to_node, node_to_string = build_bipartite_graph(
            config["file"],
            dataset_name=dataset_name,
            venue_col=config.get("venue_col"),
            max_rows=max_rows_per_dataset,
            max_year=max_year,
            string_to_node=string_to_node,
            node_to_string=node_to_string,
        )

        union_graph.add_nodes_from(graph.nodes(data=True))
        union_graph.add_edges_from(graph.edges())

    return union_graph, string_to_node, node_to_string


def question_5_union_question_1_i(union_graph):
    start_time = time.perf_counter()
    rows = solve_question_1_i_for_graph(union_graph, "union")
    execution_time = add_execution_time(rows, start_time)
    df = pd.DataFrame(rows)

    output_path = RESULTS_DIR / "question_5_union_question_1_i.csv"
    df.to_csv(output_path, index=False)
    print(f"QUESTION 5 - union QUESTION 1.I saved in {output_path}")
    print(f"QUESTION 5 - union QUESTION 1.I execution time: {execution_time} seconds")
    return df


def question_5_union_question_3_i(union_graph, sketch_sizes=SKETCH_SIZES, seed=0):
    start_time = time.perf_counter()
    author_set = set()
    sketches = {}

    for k in sketch_sizes:
        sketches[k] = BottomKSketch(k=k, seed=seed)

    for node, data in union_graph.nodes(data=True):
        if data.get("kind") != AUTHOR_KIND:
            continue

        author = data.get("name")
        if author is None or author in author_set:
            continue

        author_set.add(author)
        for k in sketch_sizes:
            sketches[k].update(author)

    rows = []
    exact_size = len(author_set)
    for k in sketch_sizes:
        estimated_size = sketches[k].size()
        rows.append(
            {
                "dataset": "union",
                "k": k,
                "seed": seed,
                "exact_distinct_authors": exact_size,
                "estimated_distinct_authors": estimated_size,
                "relative_error": relative_error(estimated_size, exact_size),
            }
        )

    execution_time = add_execution_time(rows, start_time)
    df = pd.DataFrame(rows)
    output_path = RESULTS_DIR / "question_5_union_question_3_i.csv"
    df.to_csv(output_path, index=False)
    print(f"QUESTION 5 - union QUESTION 3.I saved in {output_path}")
    print(f"QUESTION 5 - union QUESTION 3.I execution time: {execution_time} seconds")
    return df


def question_5_union_question_4_2(
    union_graph,
    sample_size=DEFAULT_DISTANCE_SAMPLE_SIZE,
    seed=0,
    year_limits=YEAR_LIMITS,
):
    start_time = time.perf_counter()
    rows = []

    for year_limit in year_limits:
        print(f"QUESTION 5 - union QUESTION 4.2, year <= {year_limit}")
        graph = graph_up_to_year(union_graph, year_limit)
        rows.append(
            solve_question_4_2_for_graph(
                graph,
                "union",
                year_limit,
                sample_size,
                seed,
            )
        )

    execution_time = add_execution_time(rows, start_time)
    df = pd.DataFrame(rows)
    output_path = RESULTS_DIR / "question_5_union_question_4_2.csv"
    df.to_csv(output_path, index=False)
    print(f"QUESTION 5 - union QUESTION 4.2 saved in {output_path}")
    print(f"QUESTION 5 - union QUESTION 4.2 execution time: {execution_time} seconds")
    return df


def build_author_graph(max_rows_per_dataset=None):
    """
    Costruisce il grafo degli autori.

    I nodi sono autori; il peso dell'arco e' il numero di pubblicazioni fatte
    insieme.
    """
    author_graph = nx.Graph()
    best_pair = None
    best_count = 0

    for dataset_name, config in DATASETS.items():
        print(f"QUESTION 5 - building author graph from {dataset_name}")
        reader = pd.read_csv(
            config["file"],
            sep=";",
            usecols=["author"],
            dtype=str,
            chunksize=100_000,
            nrows=max_rows_per_dataset,
            on_bad_lines="skip",
        )

        for chunk in reader:
            for row in chunk.itertuples(index=False):
                authors = sorted(set(split_authors(row.author)))

                for author in authors:
                    author_graph.add_node(author)

                for author_a, author_b in combinations(authors, 2):
                    if author_graph.has_edge(author_a, author_b):
                        author_graph[author_a][author_b]["weight"] += 1
                    else:
                        author_graph.add_edge(author_a, author_b, weight=1)

                    weight = author_graph[author_a][author_b]["weight"]
                    if weight > best_count:
                        best_pair = (author_a, author_b)
                        best_count = weight

    return author_graph, best_pair, best_count


def question_5_author_graph(max_rows_per_dataset=None):
    start_time = time.perf_counter()
    author_graph, best_pair, best_count = build_author_graph(
        max_rows_per_dataset=max_rows_per_dataset
    )

    if best_pair is None:
        author_a = None
        author_b = None
    else:
        author_a, author_b = best_pair

    rows = [
        {
            "author_a": author_a,
            "author_b": author_b,
            "collaborations": best_count,
            "author_graph_nodes": author_graph.number_of_nodes(),
            "author_graph_edges": author_graph.number_of_edges(),
        }
    ]

    execution_time = add_execution_time(rows, start_time)
    df = pd.DataFrame(rows)
    output_path = RESULTS_DIR / "question_5_author_collaboration.csv"
    df.to_csv(output_path, index=False)
    print(f"QUESTION 5 - author collaboration saved in {output_path}")
    print(f"QUESTION 5 - author graph execution time: {execution_time} seconds")
    return df


def question_5(
    sketch_sizes=SKETCH_SIZES,
    sample_size=DEFAULT_DISTANCE_SAMPLE_SIZE,
    seed=0,
    max_rows_per_dataset=None,
    year_limits=YEAR_LIMITS,
):
    start_time = time.perf_counter()
    RESULTS_DIR.mkdir(exist_ok=True)

    union_graph, string_to_node, node_to_string = build_union_bipartite_graph(
        max_rows_per_dataset=max_rows_per_dataset,
        max_year=max(YEAR_LIMITS),
    )

    q1_df = question_5_union_question_1_i(union_graph)
    q3_df = question_5_union_question_3_i(
        union_graph,
        sketch_sizes=sketch_sizes,
        seed=seed,
    )
    q4_df = question_5_union_question_4_2(
        union_graph,
        sample_size=sample_size,
        seed=seed,
        year_limits=year_limits,
    )
    collaboration_df = question_5_author_graph(
        max_rows_per_dataset=max_rows_per_dataset
    )

    print(
        "QUESTION 5 - union graph:",
        union_graph.number_of_nodes(),
        "nodes,",
        union_graph.number_of_edges(),
        "edges",
    )
    print("QUESTION 5 - dictionaries:", len(string_to_node), len(node_to_string))

    total_execution_time = round(time.perf_counter() - start_time, 3)
    print(f"QUESTION 5 - total execution time: {total_execution_time} seconds")

    q5_outputs = [
        (q1_df, RESULTS_DIR / "question_5_union_question_1_i.csv"),
        (q3_df, RESULTS_DIR / "question_5_union_question_3_i.csv"),
        (q4_df, RESULTS_DIR / "question_5_union_question_4_2.csv"),
        (collaboration_df, RESULTS_DIR / "question_5_author_collaboration.csv"),
    ]
    for df, output_path in q5_outputs:
        df["question_5_total_execution_time_seconds"] = total_execution_time
        df.to_csv(output_path, index=False)

    print("QUESTION 5: terminated successfully, cleaning up memory...")

    return q1_df, q3_df, q4_df, collaboration_df


if __name__ == "__main__":
    question_1_i()
    question_3_i()
    question_4_2()
    question_5()
    pass
