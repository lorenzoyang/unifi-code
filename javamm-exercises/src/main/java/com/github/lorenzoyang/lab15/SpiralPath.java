package com.github.lorenzoyang.lab15;

class SpiralPath {
    int spiralPath(int n, int i) {
        // #inizio: javamm

        int valoreMatrice = (n / 2) * n + (n / 2) + 1;
        int giro = 0;
        int iTh = 1;
        while (giro < n) {
            // verso l'alto
            for (int j = 0; j <= giro; j++) {
                if (iTh == i) return valoreMatrice;
                // riga--;
                valoreMatrice -= n;
                iTh++;
            }
            // verso sinistra
            for (int u = 0; u <= giro; u++) {
                if (iTh == i) return valoreMatrice;
                valoreMatrice--;
                iTh++;
            }
            giro++;
            // verso il basso
            for (int j = 0; j <= giro; j++) {
                if (iTh == i) return valoreMatrice;
                valoreMatrice += n;
                iTh++;
            }
            // verso destra
            for (int j = 0; j <= giro; j++) {
                if (iTh == i) return valoreMatrice;
                valoreMatrice++;
                iTh++;
            }
            giro++;
        }
        for (int j = 0; j <= n; j++) {
            if (iTh == i) return valoreMatrice;
            valoreMatrice -= n;
            iTh++;
        }
        return 0;
    }

    // #fine: javamm
}
