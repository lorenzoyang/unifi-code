package com.github.lorenzoyang.lab10;

class EsplosioneMatrice {
    // #inizio: javamm

    int[][] esplodiMatrice(int[][] t, int r, int c) {
        if (t[r][c] == 0) return t;

        t[r][c] = 0;

        int up;
        if (r == 0) {
            up = 0;
        } else {
            up = r - 1;
        }

        int down;
        if (r == t.length - 1) {
            down = t.length - 1;
        } else {
            down = r + 1;
        }

        int left;
        if (c == 0) {
            left = 0;
        } else {
            left = c - 1;
        }

        int right;
        if (c == t[0].length - 1) {
            right = c;
        } else {
            right = c + 1;
        }

        for (int i = down; i >= up; i--) {
            for (int j = right; j >= left; j--) {
                if (t[i][j] == 1) return esplodiMatrice(t, i, j);
            }
        }

        return t;
    }

    // #fine: javamm
}
