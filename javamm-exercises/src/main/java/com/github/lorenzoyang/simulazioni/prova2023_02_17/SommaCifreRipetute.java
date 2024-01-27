package com.github.lorenzoyang.simulazioni.prova2023_02_17;

class SommaCifreRipetute {
    // #inizio: javammexercises

    int sommaCifreRipetute(int numero) {
        int risultato = 0, esponente = 0;
        while (numero > 0) {
            int[] valori = sommaConta(numero, numero % 10);
            risultato += valori[0] * (int) Math.pow(10, esponente);
            esponente += (valori[0] / 10 > 0) ? 2 : 1;
            numero /= (int) Math.pow(10, valori[1]);
        }
        return risultato;
    }

    // il primo elemento = somma, il secondo elemento = contatore
    int[] sommaConta(int numero, int cifra) {
        int somma = 0, contatore = 0;
        while (numero > 0 && numero % 10 == cifra) {
            somma += cifra;
            contatore++;
            numero /= 10;
        }
        return new int[]{somma, contatore};
    }

    // #fine: javammexercises
}
