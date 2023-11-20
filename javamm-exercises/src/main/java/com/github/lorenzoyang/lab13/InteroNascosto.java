package com.github.lorenzoyang.lab13;

class InteroNascosto {
    // #inizio: javamm

    int interoNascosto(int a, int b, int c) {
        double nascosto = 0;
        int count = 0;
        while (a > 0) {
            if (a % 10 == b % 10 || a % 10 == c % 10) {
                nascosto += Math.pow(10, count) * (a % 10);
                count++;
            } else if (b % 10 == c % 10) {
                nascosto += Math.pow(10, count) * (b % 10);
                count++;
            }
            a /= 10;
            b /= 10;
            c /= 10;
        }
        return (int) nascosto;
    }

    // #fine: javamm
}
