package com.github.lorenzoyang.lab06;

class Lab06 {
    int integerSquareRoot(int n) {
        int i = 0;
        while (i * i <= n) {
            i++;
        }
        return i - 1;
    }

    int firstLastDigitSum(int n) {
        if (n >= 10) {
            int lastDigit = n % 10;
            while (n >= 10) {
                n /= 10;
            }
            return lastDigit + n;
        }
        return -1;
    }

    int invertNumber(int n) {
        if (n % 10 > 0) {
            int result = 0;
            while (n > 0) {
                result = result * 10 + n % 10;
                n /= 10;
            }
            return result;
        }
        return -1;
    }

    // da completare
    int harmonicSum(int x) {
        int result = 0;
        int i = 1;
        while (result < x) {
            result += harmonicFunction(i);
            i++;
        }
        return i - 1;
    }

    // metodo usato da harmonicSum
    private int harmonicFunction(int k) {
        int result = 0;
        int i = 1;
        while (i <= k) {
            result += (1 / i);
            i++;
        }
        return result;
    }

    // da completare
    long duplicateDigit(int n) {
        long risultato = 0;

        // Inizializza il fattore a 1 (10^0)
        int fattore = 1;

        while (n > 0) {
            int cifra = n % 10;

            // Duplica la cifra e aggiungi al risultato
            risultato += fattore * cifra + fattore * cifra * 10;

            fattore *= 100;

            n /= 10;
        }

        return risultato;
    }
}
