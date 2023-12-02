package com.github.lorenzoyang.lab17;

class InteroBilanciato {
    // #inizio: javamm

    boolean bilanciato(int n) {
        int nCifre = contaCifre(n);
        int left = n / (int) Math.pow(10, nCifre / 2);
        int right = n % (int) Math.pow(10, nCifre / 2);
        int lk = nCifre / 2 - 1;

        int lv = left / (int) Math.pow(10, lk);
        int rv = right % 10;
        if (nCifre == 2) return lv == rv;
        int somma = lv + rv;

        left %= (int) Math.pow(10, lk--);
        right /= 10;

        boolean maiEntrato = true;
        while (left > 0) {
            maiEntrato = false;
            if (somma != (left / (int) Math.pow(10, lk)) + (right % 10)) return false;
            left %= (int) Math.pow(10, lk--);
            right /= 10;
        }
        return !maiEntrato || somma == (left + right);
    }

    // funzione privata
    int contaCifre(int n) {
        int nCifre = 0;
        while (n > 0) {
            n /= 10;
            nCifre++;
        }
        return nCifre;
    }

    // #fine: javamm
}
