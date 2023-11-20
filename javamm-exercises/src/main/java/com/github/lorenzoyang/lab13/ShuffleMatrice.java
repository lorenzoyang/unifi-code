package com.github.lorenzoyang.lab13;

class ShuffleMatrice {
    // #inizio: javamm

    int[][] shuffleMatrice(int[][] t, int[][] s) {
        // t = matrice m x m

        // shuffle verticale
        for (int i = 0; i < s.length; i++) {
            int[][] risultatoVerticale = new int[t.length][t.length];
            for (int j = 0; j < s[0].length; j++) {
                for (int k = 0; k < t.length; k++) {
                    risultatoVerticale[k][s[i][j]] = t[k][j];
                }
            }
            t = risultatoVerticale;
        }
        // shuffle orizzontale
        for (int i = 0; i < s.length; i++) {
            int[][] risultatoOrizzontale = new int[t.length][t.length];
            for (int j = 0; j < s[0].length; j++) {
                for (int k = 0; k < t.length; k++) {
                    risultatoOrizzontale[s[i][j]][k] = t[j][k];
                }
            }
            t = risultatoOrizzontale;
        }
        return t;
    }

    // #fine: javamm
}
