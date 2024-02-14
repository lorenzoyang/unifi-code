package com.github.lorenzoyang.lab20;

class GeneraMatriceDaArray {
    // #solution:begin
    int[][] generaMatriceDaArray(int[] arr) {
        int[] dimennsione = calcolaDimensione(arr);
        int[][] matrice = new int[dimennsione[0]][dimennsione[1]];

        int contatore = 1, colonnaPartenza = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                for (int k = colonnaPartenza; k < colonnaPartenza + arr[i]; k++) {
                    matrice[j][k] = contatore++;
                }
            }
            colonnaPartenza += arr[i];
        }
        return matrice;
    }

    int[][] generaMatriceDaArrayRicorsivo(int[] arr) {
        int[] dimensione = calcolaDimensione(arr);
        int[][] matrice = new int[dimensione[0]][dimensione[1]];
        return (generaMatriceDaArrayRicorsivo(matrice, arr, 0, 1, 0));
    }

    int[][] generaMatriceDaArrayRicorsivo(int[][] matrice, int[] arr, int indiceArr, int contatore, int colonnaPartenza) {
        if (indiceArr == arr.length) return matrice;

        for (int i = 0; i < arr[indiceArr]; i++) {
            for (int j = colonnaPartenza; j < colonnaPartenza + arr[indiceArr]; j++) {
                matrice[i][j] = contatore++;
            }
        }
        return (generaMatriceDaArrayRicorsivo(matrice, arr, indiceArr + 1, contatore
                , colonnaPartenza + arr[indiceArr]));
    }

    // funzione di supporto
    int[] calcolaDimensione(int[] arr) {
        int colonne = 0, righe = 0;
        for (int i = 0; i < arr.length; i++) {
            colonne += arr[i];
            if (arr[i] > righe) righe = arr[i];
        }
        return new int[]{righe, colonne};
    }
    // #solution:end
}
