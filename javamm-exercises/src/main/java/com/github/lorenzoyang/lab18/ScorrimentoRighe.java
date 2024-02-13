package com.github.lorenzoyang.lab18;

class ScorrimentoRighe {
    // #solution:begin

    // consegna obbligatoria
    int[][] scorrimentoRighe(int[][] m) {
        int temp;
        // ciclo su tutte le righe di indice pari
        for (int i = 0; i < m.length; i += 2) {
            temp = m[i][m[i].length - 1];
            for (int j = m[i].length - 1; j > 0; j--) m[i][j] = m[i][j - 1];
            m[i][0] = temp;
        }
        // ciclo su tutte le righe di indice dispari
        for (int i = 1; i < m.length; i += 2) {
            temp = m[i][0];
            for (int j = 0; j < m[i].length - 1; j++) m[i][j] = m[i][j + 1];
            m[i][m[i].length - 1] = temp;
        }
        return m;
    }

    // consegna facoltativa
    int[][] scorrimentoRigheNposizioni(int[][] m, short p) {
        p %= (short) m[0].length;
        for (int i = 0; i < p; i++) scorrimentoRighe(m);
        return m;
    }


    /**************************************************************************
     * Alternativa alla "consegna obbligatoria"
     **************************************************************************/
    int[][] alternativa_scorrimentoRighe(int[][] m) {
        int temp;
        for (int i = 0; i < m.length; i++) {
            if (i % 2 == 0) {
                temp = m[i][m[i].length - 1];
                for (int j = m[i].length - 1; j > 0; j--) {
                    m[i][j] = m[i][j - 1];
                }
                m[i][0] = temp;
            } else {
                temp = m[i][0];
                for (int j = 0; j < m[i].length - 1; j++) {
                    m[i][j] = m[i][j + 1];
                }
                m[i][m[i].length - 1] = temp;
            }
        }
        return m;
    }

    // #solution:end
}
