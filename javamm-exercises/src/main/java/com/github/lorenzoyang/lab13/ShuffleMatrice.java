package com.github.lorenzoyang.lab13;

class ShuffleMatrice {
    // #solution:begin
    int[][] shuffleMatrice(int[][] t, int[][] s) {
        // t = matrice m x m
        return shuffleMatrice(shuffleMatrice(t, s, true), s, false);
    }

    int[][] shuffleMatrice(int[][] t, int[][] s, boolean verticale) {
        int[][] risultato = new int[t.length][t.length];
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[0].length; j++) {
                for (int k = 0; k < t.length; k++) {
                    if (verticale) risultato[k][s[i][j]] = t[k][j];
                    else risultato[s[i][j]][k] = t[j][k];
                }
            }
            int[][] temp = t;
            t = risultato;
            risultato = temp;
        }
        return t;
    }
    // #solution:end
}
