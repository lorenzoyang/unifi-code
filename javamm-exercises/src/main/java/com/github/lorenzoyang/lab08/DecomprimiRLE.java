package com.github.lorenzoyang.lab08;

class DecomprimiRLE {
    // #stato: completato
    // #inizio: javamm

    int[] decomprimiRLE(int[] a) {
        int lunghezza = 0;
        for (int i = 1; i < a.length; i += 2) {
            lunghezza += a[i];
        }

        int[] decompressa = new int[lunghezza];

        int indice = 0;
        for (int i = 0; i < a.length; i += 2) {
            for (int j = 0; j < a[i + 1]; j++) {
                decompressa[indice++] = a[i];
            }
        }
        return decompressa;
    }

    // #fine: javamm
}
