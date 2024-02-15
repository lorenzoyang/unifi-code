package com.github.lorenzoyang.lab13;

class InteroNascosto {
    // #solution:begin
    int interoNascosto(int a, int b, int c) {
        double nascosto = 0;
        int esponente = 0;
        while (a > 0) {
            int cifraA = a % 10, cifraB = b % 10, cifraC = c % 10;
            if (cifraA == cifraB || cifraA == cifraC) {
                nascosto += Math.pow(10, esponente++) * cifraA;
            } else if (cifraB == cifraC) {
                nascosto += Math.pow(10, esponente++) * cifraB;
            }
            a /= 10;
            b /= 10;
            c /= 10;
        }
        return (int) nascosto;
    }
    // #solution:end
}
