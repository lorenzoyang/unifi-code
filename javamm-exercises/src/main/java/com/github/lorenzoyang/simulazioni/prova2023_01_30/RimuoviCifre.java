package com.github.lorenzoyang.simulazioni.prova2023_01_30;

public class RimuoviCifre {
    // #inizio: javammexercises

    public long rimuoviCifre(long n, short c) {
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

    // soluzione alternativa (Matteo)
    public long alternativa_rimuoviCifre(long n, short c) {
        long risultato = 0;
        int controllo = 0, esponente = 0;
        for (int i = 0; i < c; i++) {
            controllo += c * (int) Math.pow(10, i);
        }
        while (n > 0) {
            if ((n % (int) Math.pow(10, c)) == controllo) {
                n /= (int) Math.pow(10, c);
            } else {
                risultato += (n % 10) * (int) Math.pow(10, esponente++);
                n /= 10;
            }
        }
        return risultato;
    }

    // #fine: javammexercises
}
