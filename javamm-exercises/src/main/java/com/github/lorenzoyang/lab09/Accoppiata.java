package com.github.lorenzoyang.lab09;

class Accoppiata {
    // #stato: completato
    // #inizio: javamm

    boolean accoppiata(char[] array) {
        if (array.length % 2 != 0) return false;
        return accoppiata(array, 0, array.length / 2);
    }

    // funzione privata usata da accoppiata
    boolean accoppiata(char[] array, int i, int j) {
        // oppure if j == array.length
        if (i == array.length / 2) return true;
        if (array[i] != array[j]) return false;
        return accoppiata(array, i + 1, j + 1);
    }

    // #fine: javamm
}
