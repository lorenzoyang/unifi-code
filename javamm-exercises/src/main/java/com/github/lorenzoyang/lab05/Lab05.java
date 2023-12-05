package com.github.lorenzoyang.lab05;

class Lab05 {
    // #stato: completato
    // #inizio: javamm

    int loneSum(int a, int b, int c) {
        int sum = 0;

        if (a != b && a != c) {
            sum += a;
        }

        if (b != a && b != c) {
            sum += b;
        }

        if (c != a && c != b) {
            sum += c;
        }
        return sum;
    }

    int noTeenSum(int a, int b, int c) {
        return fixTeen(a) + fixTeen(b) + fixTeen(c);
    }

    // funzione privata usata da noTeenSum
    int fixTeen(int n) {
        return (n >= 13 && n <= 19 && n != 15 && n != 16) ? 0 : n;
    }

    int roundSum(int a, int b, int c) {
        return round(a) + round(b) + round(c);
    }

    // funzione privata usata da roundSum
    int round(int n) {
        int resto = n % 10;
        if (resto < 5) {
            return n - resto;
        } else {
            return n + (10 - resto);
        }
    }

    boolean evenlySpaced(int a, int b, int c) {
        return (max(a, b, c) - mid(a, b, c)) == (mid(a, b, c) - min(a, b, c));
    }

    // funzione privata usata da evenlySpaced
    int max(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        } else if (b > c) {
            return b;
        } else {
            return c;
        }
    }

    // funzione privata usata da evenlySpaced
    int min(int a, int b, int c) {
        if (a < b && a < c) {
            return a;
        } else if (b < c) {
            return b;
        } else {
            return c;
        }
    }

    // funzione privata usata da evenlySpaced
    int mid(int a, int b, int c) {
        if ((a > b && a < c) || (a < b && a > c)) {
            return a;
        } else if ((b > a && b < c) || (b < a && b > c)) {
            return b;
        } else {
            return c;
        }
    }

    // #fine: javamm
}
