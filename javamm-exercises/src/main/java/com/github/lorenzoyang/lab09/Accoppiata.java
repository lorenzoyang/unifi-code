package com.github.lorenzoyang.lab09;

class Accoppiata {
    // #solution:begin

    boolean accoppiata(char[] A) {
        if (A.length % 2 != 0) return false;
        return accoppiata(A, 0);
    }

    boolean accoppiata(char[] A, int indice) {
        if (indice == A.length / 2) return true;
        return A[indice] == A[A.length / 2 + indice] && accoppiata(A, indice + 1);
    }
    // #solution:end
}
