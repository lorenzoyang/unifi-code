package com.github.lorenzoyang.lab13;

class ShuffleMatrice {
    // #stato: completato
    // #inizio: javamm

    int[][] shuffleMatrice(int[][] t, int[][] s) {
        // t = matrice m x m
        return shuffleMatrice(shuffleMatrice(t, s, true), s, false);
    }

    // funzione privata ausiliaria: shuffleMatrice con parametro verticale
    int[][] shuffleMatrice(int[][] t, int[][] s, boolean verticale) {
        for (int i = 0; i < s.length; i++) {
            int[][] risultatoVerticale = new int[t.length][t.length];
            for (int j = 0; j < s[0].length; j++) {
                for (int k = 0; k < t.length; k++) {
                    if (verticale) risultatoVerticale[k][s[i][j]] = t[k][j];
                    else risultatoVerticale[s[i][j]][k] = t[j][k];
                }
            }
            t = risultatoVerticale;
        }
        return t;
    }

    // #fine: javamm
}
