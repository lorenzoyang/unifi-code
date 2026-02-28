import pytest

from informatica_teorica.computabilita.funzioni_iniziali import (
    funzione_costante_zero,
    funzione_proiezione,
    funzione_successore,
)

# ====================================
# Tests per la funzione costante
# ====================================


@pytest.mark.parametrize(
    ("arieta", "argomenti", "atteso"),
    [
        (1, [0], 0),
        (3, [1, 2, 3], 0),
    ],
)
def test_funzione_costante_zero_restituisce_sempre_zero(arieta, argomenti, atteso):
    zero = funzione_costante_zero(arieta)
    assert zero(argomenti) == atteso


@pytest.mark.parametrize("arieta", [0, -1, -2])
def test_funzione_costante_zero_arieta_non_valida(arieta):
    with pytest.raises(ValueError):
        funzione_costante_zero(arieta=arieta)


def test_funzione_costante_zero_numero_argomenti_errato():
    zero = funzione_costante_zero(arieta=2)
    with pytest.raises(ValueError):
        zero([1])


def test_funzione_costante_zero_argomento_non_naturale():
    zero = funzione_costante_zero(arieta=2)
    with pytest.raises(ValueError):
        zero([1, -3])


# ====================================
# Tests per la funzione successione
# ====================================


def test_funzione_successore_restituisce_successore():
    successore = funzione_successore()
    assert successore(0) == 1
    assert successore(10) == 11


def test_funzione_successore_rifiuta_negativo():
    successore = funzione_successore()
    with pytest.raises(ValueError):
        successore(-1)


# ====================================
# Tests per la funzione proiezione
# ====================================


@pytest.mark.parametrize(
    ("arieta", "indice", "argomenti", "atteso"),
    [
        (3, 0, [8, 9, 10], 8),
        (3, 1, [8, 9, 10], 9),
        (3, 2, [8, 9, 10], 10),
    ],
)
def test_funzione_proiezione_restituisce_argomento_atteso(
    arieta, indice, argomenti, atteso
):
    proiezione = funzione_proiezione(arieta=arieta, indice=indice)
    assert proiezione(argomenti) == atteso


@pytest.mark.parametrize("arieta", [0, -2])
def test_funzione_proiezione_arieta_non_valida(arieta):
    with pytest.raises(ValueError):
        funzione_proiezione(arieta=arieta, indice=0)


@pytest.mark.parametrize(
    ("arieta", "indice"),
    [
        (3, -1),
        (3, 3),
    ],
)
def test_funzione_proiezione_indice_non_valido(arieta, indice):
    with pytest.raises(ValueError):
        funzione_proiezione(arieta=arieta, indice=indice)


def test_funzione_proiezione_numero_argomenti_errato():
    proiezione = funzione_proiezione(arieta=3, indice=1)
    with pytest.raises(ValueError):
        proiezione([4, 5])


def test_funzione_proiezione_argomento_non_naturale():
    proiezione = funzione_proiezione(arieta=3, indice=1)
    with pytest.raises(ValueError):
        proiezione([4, -5, 6])
