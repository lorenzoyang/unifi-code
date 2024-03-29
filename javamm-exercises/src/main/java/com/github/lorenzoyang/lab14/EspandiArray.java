package com.github.lorenzoyang.lab14;

class EspandiArray {
    // #solution:begin
    int[][] espandiArray(int[] v) {
        return espandiArrayExtraDifficolta(v);
        // return espandiArrayStandard(v);
    }

    int[][] espandiArrayExtraDifficolta(int[] v) {
        int[][] risultato = new int[cercaMassimo(v)][v.length];
        for (int i = 0; i < risultato.length; i++) {
            for (int j = 0; j < risultato[i].length; j++) {
                if (i >= v[j]) risultato[i][j] = 0;
                else risultato[i][j] = v[j];
            }
        }
        return risultato;
    }

    int[][] espandiArrayStandard(int[] v) {
        int[][] risultato = new int[cercaMassimo(v)][v.length];
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i]; j++) {
                risultato[j][i] = v[i];
            }
        }
        return risultato;
    }

    int cercaMassimo(int[] v) {
        int max = v[0];
        for (int i = 1; i < v.length; i++) {
            if (v[i] > max) max = v[i];
        }
        return max;
    }
    // #solution:end
}
