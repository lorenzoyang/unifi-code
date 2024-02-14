package com.github.lorenzoyang.lab12;

class TraslaMatrice {
    // #solution:begin
    int[][] traslaMatrice(int[][] t, int y) {
        if (y == 0) return t;

        int[][] risultato = new int[t.length][t[0].length];

        // y può essere negativo, quindi lo trasformo in un valore positivo
        y = t.length + (y % t.length);
        // un modo alternativo per ottenere lo stesso risultato
        // y = y < 0 ? (-2 * y) % t.length : y % t.length;

        for (int i = 0; i < t.length; i++) {
            risultato[(i + y) % t.length] = t[i];
        }

        return risultato;
    }
    // #solution:end
}
