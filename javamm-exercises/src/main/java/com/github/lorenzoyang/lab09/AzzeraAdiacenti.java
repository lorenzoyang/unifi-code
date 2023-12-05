package com.github.lorenzoyang.lab09;

class AzzeraAdiacenti {
    // #stato: completato
    // #inizio: javamm

    int[][] azzeraAdiacenti(int[][] m, int r, int c) {
        if (m.length < 3 || m[0].length < 3) return m;
        if (r < 0 || r >= m.length || c < 0 || c >= m[0].length) return m;

        int[][] directions = {{-1, -1}, {1, 1}, {1, -1}, {-1, 1}, {0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        for (int i = 0; i < directions.length; i++) {
            int newR = (r + directions[i][0] + m.length) % m.length;
            int newC = (c + directions[i][1] + m[0].length) % m[0].length;
            m[newR][newC] = 0;
        }

        return m;
    }

    // #fine: javamm
}
