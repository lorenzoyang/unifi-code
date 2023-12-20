package com.github.lorenzoyang.lab10;

class TestBilanciamento {
    // #inizio: javamm

    boolean testBilanciamento(int[] r) {
        if (r.length == 0 || r.length % 2 != 0) return false;
        if (r.length == 2) return r[0] == r[1];
        return testBilanciamento(r, 1, r.length - 2);
    }

    // funzione privata ricorsiva usata da testBilanciamento(int[])
    boolean testBilanciamento(int[] r, int i, int j) {
        if (i >= j) return true;
        if (r[i] + r[j] != r[0] + r[r.length - 1]) return false;
        return testBilanciamento(r, i + 1, j - 1);
    }

    // #fine: javamm
}
