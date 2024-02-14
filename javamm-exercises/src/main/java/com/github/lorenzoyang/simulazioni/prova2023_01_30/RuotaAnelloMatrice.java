package com.github.lorenzoyang.simulazioni.prova2023_01_30;

class RuotaAnelloMatrice {
    // #solution:begin
    int[][] ruotaAnelloMatrice(int[][] t, int k) {
        int centro = t.length / 2;

        // salvo l'elemento che si trova in alto a sinistra,
        int temp = t[centro - k][centro - k];

        // Ruoto il lato sinistro dell'anello, procedendo dall'alto vero il basso.
        for (int i = centro - k + 1; i <= centro + k; i++) {
            t[i - 1][centro - k] = t[i][centro - k];
        }
        // Ruoto il lato inferiore dell'anello, procedendo da sinistra vero destra.
        for (int i = centro - k + 1; i <= centro + k; i++) {
            t[centro + k][i - 1] = t[centro + k][i];
        }
        // Ruoto il lato destro dell'anello, procedendo dal basso verso l'alto.
        for (int i = centro + k - 1; i >= centro - k; i--) {
            t[i + 1][centro + k] = t[i][centro + k];
        }
        // Ruoto il lato superiore dell'anello, procedendo da destra verso sinistra.
        for (int i = centro + k - 1; i >= centro - k; i--) {
            t[centro - k][i + 1] = t[centro - k][i];
        }
        // Sposto di 1 posizione in senso orario l'elemento che era in posizione [centro-k][centro-k].
        t[centro - k][centro - k + 1] = temp;

        return t;
    }

    int[][] ruotaAnelloMatriceNposizioni(int[][] t, int k, int n) {
        // Calcolo il valore equivalente di n compreso fra 0 e 8*k-1
        // (l'anello k ha esattamente 8*k elementi che lo compongono).
        n = (n > 0) ? n % (8 * k) : n % (8 * k) + (8 * k);

        // Eseguo n rotazioni, ciascuna di un passo.
        for (int i = 0; i < n; i++)
            t = ruotaAnelloMatrice(t, k);
        return t;
    }
    // #solution:end

    // #alternativesolution:begin
    // #comment: alternativa alla ruotaAnelloMatrice con un solo ciclo for. (non consigliato)
    int[][] alternativa_ruotaAnelloMatrice(int[][] t, int k) {
        int centro = t.length / 2, upLeft = t[centro - k][centro - k], upRight = t[centro - k][centro + k],
                downLeft = t[centro + k][centro - k], downRight = t[centro + k][centro + k];
        for (int i = 0; i < 2 * k + 1 - 2; i++) {
            t[centro - k][centro + k - i] = t[centro - k][centro + k - i - 1]; // riga sopra
            t[centro - k + i][centro - k] = t[centro - k + i + 1][centro - k]; // riga sinistra
            t[centro + k][centro - k + i] = t[centro + k][centro - k + i + 1]; // riga sotto
            t[centro + k - i][centro + k] = t[centro + k - i - 1][centro + k]; // colonna destra
        }
        t[centro - k][centro - k + 1] = upLeft;
        t[centro - k + 1][centro + k] = upRight;
        t[centro + k][centro + k - 1] = downRight;
        t[centro + k - 1][centro - k] = downLeft;
        return t;
    }
    // #alternativesolution:end
}
