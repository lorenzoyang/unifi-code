package com.github.lorenzoyang.lab11;

class SlotMachine {
    // #stato: completato
    // #inizio: javamm
    
    int[][] ruota(int[][] s, int[] r) {
        if (s.length < 3 || s.length % 2 == 0 || s[0].length != r.length) {
            return s;
        }

        int[][] matrice = new int[s.length][s[0].length];
        for (int i = 0; i < r.length; i++) {
            int diff = r[i] % s.length;
            for (int j = 0; j < s.length; j++) {
                matrice[(j + diff) % s.length][i] = s[j][i];
            }
        }
        return matrice;
    }

    boolean controllaVincita(int[][] s) {
        int central = s.length / 2;
        for (int i = 0; i < s[0].length; i++) {
            if (s[central][i] != 1) return false;
        }
        return true;
    }

    boolean partitaCompleta(int[][] s, int[] r, int k) {
        if (k == 0) return false;

        int[][] dopoRuota = ruota(s, r);

        if (controllaVincita(dopoRuota)) return true;
        return partitaCompleta(dopoRuota, r, k - 1);
    }

    // #fine: javamm
}
