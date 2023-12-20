package com.github.lorenzoyang.simulazioni.prova20230130;

class RimuoviCifre {
    // #inizio: javamm

    long rimuoviCifre(long n, short c) {
        long risultato = 0;
        int contatore = 0; // per contare le cifre consecutive
        int esponente = 0; // per calcolare la potenza di 10

        while (n > 0) {
            long ultimaCifra = n % 10;
            contatore = (ultimaCifra == c) ? contatore + 1 : 0; // incremento o resetto il contatore
            risultato += ultimaCifra * (int) Math.pow(10, esponente++);
            if (contatore == c) {
                esponente -= c;
                risultato = risultato % (int) Math.pow(10, esponente);
                contatore = 0;
            }
            n /= 10;
        }
        return risultato;
    }

    // #fine: javamm
}
