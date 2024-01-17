package com.github.lorenzoyang.lab12;

class TraslaMatrice {
    // #inizio: javammexercises

    int[][] traslaMatrice(int[][] t, int y) {
        if (y == 0) return t;

        int[][] risultato = new int[t.length][t[0].length];

        // ho trasformato cosi' lo spostamento verso il basso in uno verso l'alto
        y = y < 0 ? (-2 * y) % t.length : y % t.length;
        // y = t.length + y % (t.length); un modo alternativo per ottenere lo stesso risultato

        for (int i = 0; i < t.length; i++) {
            risultato[(i + y) % t.length] = t[i];
        }

        return risultato;
    }

    // #fine: javammexercises
}
