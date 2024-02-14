package com.github.lorenzoyang.lab09;

class AzzeraAdiacenti {
    // #solution:begin
    int[][] azzeraAdiacenti(int[][] T, int r, int c) {
        int[][] direzioni = {{-1, -1}, {1, 1}, {1, -1}, {-1, 1}, {0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for (int i = 0; i < direzioni.length; i++) {
            int nR = (r + direzioni[i][0] + T.length) % T.length;
            int nC = (c + direzioni[i][1] + T[0].length) % T[0].length;


            T[nR][nC] = 0;
        }
        return T;
    }
    // #solution:end

    // #alternativesolution:begin
    // #comment: senza il ciclo for.
    int[][] azzeraAdiacenti_1(int[][] T, int r, int c) {
        int up = (r - 1 + T.length) % T.length;
        int down = (r + 1) % T.length;
        int left = (c - 1 + T[0].length) % T[0].length;
        int right = (c + 1) % T[0].length;

        T[up][left] = 0;
        T[up][c] = 0;
        T[up][right] = 0;
        T[r][left] = 0;
        T[r][right] = 0;
        T[down][left] = 0;
        T[down][c] = 0;
        T[down][right] = 0;

        return T;
    }
    // #alternativesolution:end
}
