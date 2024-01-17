package com.github.lorenzoyang.lab20;

class GeneraMatriceDaArray {
    // #inizio: javammexercises

    // consegna obbligatoria
    int[][] generaMatriceDaArray(int[] arr) {
        int[] dimennsione = calcolaDimensione(arr);
        int[][] matrice = new int[dimennsione[0]][dimennsione[1]];

        int contatore = 1;
        int colonnaDiPartenza = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                for (int k = 0; k < arr[i]; k++) {
                    matrice[j][colonnaDiPartenza + k] = contatore++;
                }
            }
            colonnaDiPartenza += arr[i];
        }
        return matrice;
    }


    // consegna aggiuntiva (facoltativa - soluzione ricorsiva)
    int[][] generaMatriceDaArrayRicorsivo(int[] arr) {
        int[] dimensione = calcolaDimensione(arr);
        int[][] matrice = new int[dimensione[0]][dimensione[1]];
        return (generaRicorsiva(matrice, arr, 0, 1, 0));
    }

    // Parametri formali.
    // matrice: matrice da riempire
    // arr: array di interi, come da specifica
    // indiceArr: indice dell'array che si sta considerando nella chiamata
    // contatore: prossimo valore intero da inserire nella sequenza
    // colonnaDiPartenza: numero di colonne da saltare per scrivere nella posizione corretta della matrice matrice
    int[][] generaRicorsiva(int[][] matrice, int[] arr, int indiceArr, int contatore, int colonnaDiPartenza) {
        // Caso base: ho scansionato tutti gli elementi di arr
        if (indiceArr == arr.length) return matrice;

        // Lavoro direttamente sulla matrice matrice e riempio gli elementi corrispondenti
        // alla matrice quadrata di indice 'indiceArr', riempiendo le righe da sinistra verso destra
        // e dall'alto verso il basso.
        for (int i = 0; i < arr[indiceArr]; i++) {
            for (int j = 0; j < arr[indiceArr]; j++) {
                matrice[i][colonnaDiPartenza + j] = contatore++;
            }
        }

        // Il prossimo elemento di arr da analizzare e' quello di indice 'indiceArr+1'.
        // Per scrivere la sequenza della prossima matrice quadrata M_{indiceArr+1} nella
        // posizione corretta di matrice, alla prossima chiamata dovro' saltare altre
        // arr[indiceArr] colonne (quelle occupate dalla matrice M_indiceArr).
        return (generaRicorsiva(matrice, arr, indiceArr + 1, contatore
                , colonnaDiPartenza + arr[indiceArr]));
    }

    // funzione privata ausiliaria
    int[] calcolaDimensione(int[] arr) {
        int colonne = 0, righe = 0;
        for (int i = 0; i < arr.length; i++) {
            colonne += arr[i];
            if (arr[i] > righe) righe = arr[i];
        }
        return new int[]{righe, colonne};
    }

    // #fine: javammexercises
}
