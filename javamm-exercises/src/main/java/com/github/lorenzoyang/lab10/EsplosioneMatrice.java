package com.github.lorenzoyang.lab10;

class EsplosioneMatrice {
    // #solution:begin
    int[][] esplodiMatrice(int[][] T, int r, int c) {
        if (T[r][c] == 0) return T;
        T[r][c] = 0;

        int up = (r == 0) ? r : r - 1;
        int down = (r == T.length - 1) ? r : r + 1;
        int left = (c == 0) ? c : c - 1;
        int right = (c == T[0].length - 1) ? c : c + 1;

        for (int i = down; i >= up; i--) {
            for (int j = right; j >= left; j--) {
                if (T[i][j] == 1) return esplodiMatrice(T, i, j);
            }
        }
        return T;
    }
    // #solution:end
}
