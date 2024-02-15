package com.github.lorenzoyang.lab16;

class CompattaMatrice {
    // #solution:begin
    int[][] compattaMatrice(int[][] m) {
        int[][] temp = new int[m.length * m[0].length][3];
        int count = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] != 0) {
                    temp[count][0] = m[i][j];
                    temp[count][1] = i;
                    temp[count][2] = j;
                    count++;
                }
            }
        }

        if (count == 0) {
            return null;
        }

        int[][] matriceCompatta = new int[count][3];
        for (int i = 0; i < count; i++) {
            matriceCompatta[i][0] = temp[i][0];
            matriceCompatta[i][1] = temp[i][1];
            matriceCompatta[i][2] = temp[i][2];
        }

        return matriceCompatta;
    }
    // #solution:end
}
