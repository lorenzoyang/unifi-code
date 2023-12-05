package com.github.lorenzoyang.lab17;

class InteroBilanciato {
    // #inizio: javamm

    boolean bilanciato(int n) {
        int numCifre = contaCifre(n);
        int a = (int) ((n / Math.pow(10, numCifre - 1))); // la prima cifra
        int b = (int) ((n % Math.pow(10, 1))); // l'ultima cifra
        if (numCifre == 2) return a == b;

        int somma = a + b;
        for (int i = 1; i < numCifre / 2; i++) { // i = 1 perchè la prima cifra è già stata controllata
            a = (int) ((n / Math.pow(10, (numCifre - i) - 1)) % 10);
            b = (int) ((n / Math.pow(10, numCifre - (numCifre - i))) % 10);
            if (a + b != somma) return false;
        }
        return true;
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
