package com.github.lorenzoyang.lab15;

class SpiralPath {
    int spiralPath(int n, int i) {
        int valoreCentrale = (n / 2) * n + (n / 2) + 1;
        while (i > 0) {
            valoreCentrale -= n;
            i--;
            if (i == 0) break;

            
        }
        return valoreCentrale;
    }
}
