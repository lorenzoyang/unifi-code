package com.github.lorenzoyang.lab16;

class CompattaMatrice {
    // #inizio: javamm

    int[][] compattaMatrice(int[][] t) {
        int[][] temp = new int[t.length * t[0].length][3];
        int count = 0;
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if (t[i][j] != 0) {
                    temp[count][0] = t[i][j];
                    temp[count][1] = i;
                    temp[count][2] = j;
                    count++;
                }
            }
        }

        if (count == 0) {
            return null;
        }

        int[][] c = new int[count][3];
        for (int i = 0; i < count; i++) {
            c[i][0] = temp[i][0];
            c[i][1] = temp[i][1];
            c[i][2] = temp[i][2];
        }

        return c;
    }

    // #fine: javamm
}
