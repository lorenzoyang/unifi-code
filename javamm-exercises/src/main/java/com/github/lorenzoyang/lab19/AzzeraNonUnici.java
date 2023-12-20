package com.github.lorenzoyang.lab19;

class AzzeraNonUnici {
    // #inizio: javamm

    // consegna obbligatoria
    int[][] azzeraNonUnici(int[][] m, int r, int c) {
        int rc = m[r][c];
        // per riga
        for (int i = c + 1; i < m[0].length; i++) {
            if (m[r][i] == rc) m[r][c] = m[r][i] = 0;
        }
        // per colonna
        for (int i = r + 1; i < m.length; i++) {
            if (m[i][c] == rc) m[r][c] = m[i][c] = 0;
        }
        // per diagonale
        for (int i = r + 1, j = c + 1; i < m.length && j < m[0].length; i++, j++) {
            if (m[i][j] == rc) m[r][c] = m[i][j] = 0;
        }
        return m;
    }

    // consegna facoltativa
    int[][] azzeraNonUniciMatrice(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++)
                azzeraNonUnici(m, i, j);
        }
        return m;
    }

    // #fine: javamm
}
