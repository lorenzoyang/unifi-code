package com.github.lorenzoyang.lab12;

class LunghezzaMaxSeq {
    // #inizio: javamm

    int lunghezzaMaxSeq(char[] a, char c) {
        return lunghezzaMaxSeq(a, c, 0, 0, 0);
    }

    // funzione privata ricorsiva usata da lunghezzaMaxSeq
    int lunghezzaMaxSeq(char[] a, char c, int index, int count, int max) {
        if (index == a.length) return max;

        if (a[index] == c) {
            count++;
        } else {
            count = 0;
        }
        if (count > max) {
            max = count;
        }
        return lunghezzaMaxSeq(a, c, index + 1, count, max);
    }

    // #fine: javamm
}
