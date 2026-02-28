from collections.abc import Callable, Sequence


def _controllo_argomenti(arieta: int, naturali: Sequence[int]) -> None:
    length = len(naturali)
    if length != arieta:
        raise ValueError(
            f"la funzione di arietà {arieta} accetta esattamente {arieta} argomenti, "
            f"ma ne sono stati forniti {length}"
        )

    if any(n < 0 for n in naturali):
        raise ValueError("gli argomenti devono essere numeri naturali")


def funzione_costante_zero(arieta: int) -> Callable[[Sequence[int]], int]:
    """
    Crea la funzione costante zero di arietà `arieta`.

    La funzione restituita accetta `arieta` numeri naturali e restituisce sempre 0.

    Args:
        arieta: Intero positivo che rappresenta l'arietà della funzione.

    Returns:
        Callable[[Sequence[int]], int]: Funzione costante zero di arietà `arieta`.

    Raises:
        ValueError: Se `arieta` ≤ 0, se il numero di argomenti forniti
            è diverso da `arieta` o se almeno uno degli argomenti
            non appartiene a Naturali.
    """

    if arieta <= 0:
        raise ValueError(f"{arieta=}, deve essere un intero positivo")

    def costante_zero(naturali: Sequence[int]) -> int:
        _controllo_argomenti(arieta, naturali)

        return 0

    return costante_zero


def funzione_successore() -> Callable[[int], int]:
    """
    Crea la funzione successore.

    La funzione restituita accetta un numero naturale e restituisce il suo successore.

    Returns:
        Callable[[int], int]: Funzione successore.

    Raises:
        ValueError: Se l'argomento fornito non è un numero naturale.
    """

    def successore(naturale: int) -> int:
        if naturale < 0:
            raise ValueError(
                f"l'argomento deve essere un numero naturale, ma è stato fornito {naturale=}"
            )

        return naturale + 1

    return successore


def funzione_proiezione(arieta: int, indice: int) -> Callable[[Sequence[int]], int]:
    """
    Crea la funzione di proiezione di arietà `arieta` e indice `indice`.

    La funzione restituita accetta `arieta` numeri naturali e restituisce l'argomento in posizione `indice`.

    Args:
        arieta: Intero positivo che rappresenta l'arietà della funzione.
        indice: Intero compreso tra 0 e `arieta - 1` che identifica
            la posizione dell'argomento da restituire.

    Returns:
        Callable[[Sequence[int]], int]: Funzione di proiezione P^arieta_indice.

    Raises:
        ValueError: Se `arieta` ≤ 0, se `indice` non è compreso
            tra 0 e `arieta - 1`, se il numero di argomenti forniti
            è diverso da `arieta` o se almeno uno degli argomenti
            non appartiene a Naturali.
    """

    if arieta <= 0:
        raise ValueError(f"{arieta=}, deve essere un intero positivo")
    if not 0 <= indice < arieta:
        raise ValueError(f"{indice=}, deve essere compreso tra 0 e {arieta - 1}")

    def proiezione(naturali: Sequence[int]) -> int:
        _controllo_argomenti(arieta, naturali)

        return naturali[indice]

    return proiezione
