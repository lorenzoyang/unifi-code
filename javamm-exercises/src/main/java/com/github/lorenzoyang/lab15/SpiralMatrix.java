package com.github.lorenzoyang.lab15;

class SpiralMatrix {
    int[] spiralMatrix(int n, int x) {
        int[] indici = new int[]{0, 0};
        int count = 0;
        while (x > 0) {
            for (int i = 0; i < n; i++) {
                if (x == 0) break;
                indici[1] = i + count;
                x--;
            }
            for (int i = 1; i < n; i++) {
                if (x == 0) break;
                indici[0] = i + count;
                x--;
            }
            for (int i = n - 2; i >= 0; i--) {
                if (x == 0) break;
                indici[1] = i + count;
                x--;
            }
            for (int i = n - 2; i >= 1; i--) {
                if (x == 0) break;
                indici[0] = i + count;
                x--;
            }
            n -= 2;
            count++;
        }
        return indici;
    }
}
