package com.github.lorenzoyang.lab15;

class SpiralPath {
    int spiralPath(int n, int i) {
        int[][] matrice = new int[n][n];
        int contatore = 1;
        // costruisco la matrice
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                matrice[j][k] = contatore++;
            }
        }

        int riga = n / 2, colonna = n / 2;
        int giro = 0;
        int iTh = 1;
        while (giro < n) {
            // verso alto
            for (int j = 0; j <= giro; j++) {
                if (iTh == i) return matrice[riga][colonna];
                riga--;
                iTh++;
            }
            // verso sinistra
            for (int u = 0; u <= giro; u++) {
                if (iTh == i) return matrice[riga][colonna];
                colonna--;
                iTh++;
            }
            giro++;
            // verso basso
            for (int j = 0; j <= giro; j++) {
                if (iTh == i) return matrice[riga][colonna];
                riga++;
                iTh++;
            }
            // verso destra
            for (int j = 0; j <= giro; j++) {
                if (iTh == i) return matrice[riga][colonna];
                colonna++;
                iTh++;
            }
            giro++;
        }

        for (int j = 0; j <= n; j++) {
            if (iTh == i) return matrice[riga][colonna];
            riga--;
            iTh++;
        }
        return 0;
    }
}
