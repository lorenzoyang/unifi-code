package com.github.lorenzoyang.lab12;

class LunghezzaMaxSeq {
    // #stato: completato
    // #inizio: javamm

    int lunghezzaMaxSeq(char[] a, char c) {
        return lunghezzaMaxSeq(a, c, 0, 0);
        // return lunghezzaMaxSeq(a, c, 0, 0, 0);
    }

    // soluzione migliore
    // funzione privata ricorsiva usata da lunghezzaMaxSeq
    int lunghezzaMaxSeq(char[] a, char c, int pos, int count) {
        if (pos == a.length) return count;
        int max = lunghezzaMaxSeq(a, c, ++pos, a[pos - 1] == c ? count + 1 : 0);
        return max > count ? max : count;
    }

    /*************************************************************************
     * Soluzione alternativa (del prof)
     * funzione privata ricorsiva usata da lunghezzaMaxSeq
     *************************************************************************/
    int alternativa_lunghezzaMaxSeq(char[] a, char c, int index, int count, int max) {
        if (index == a.length) return max;

        if (a[index] == c) {
            count++;
        } else {
            count = 0;
        }
        if (count > max) {
            max = count;
        }
        return alternativa_lunghezzaMaxSeq(a, c, index + 1, count, max);
    }

    // #fine: javamm
}
