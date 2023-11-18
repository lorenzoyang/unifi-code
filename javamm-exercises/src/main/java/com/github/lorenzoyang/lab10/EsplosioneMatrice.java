package com.github.lorenzoyang.lab10;

class EsplosioneMatrice {
    // #inizio: javamm

    int[][] esplodiMatrice(int[][] t, int r, int c) {
        if (t[r][c] == 0) return t;

        t[r][c] = 0;

        int up = r == 0 ? 0 : r - 1;
        int down = r == t.length - 1 ? r : r + 1;
        int left = c == 0 ? 0 : c - 1;
        int right = c == t[0].length - 1 ? c : c + 1;

        for (int i = down; i >= up; i--) {
            for (int j = right; j >= left; j--) {
                if (t[i][j] == 1) return esplodiMatrice(t, i, j);
            }
        }
        return t;
    }

    // #fine: javamm
}
