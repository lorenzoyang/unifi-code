package com.github.lorenzoyang.simulazioni.prova2023_02_17;

class SommaCifreRipetute {
    // #inizio: javammexercises

    int sommaCifreRipetute(int numero) {
        short esponente = 0, occorrenze = 1;
        int nuovoNumero = 0;

        while (numero > 0) {
            // Verifico se le ultime 2 cifre del numero (quelle meno significative) sono uguali fra di loro.
            if (numero % 10 == (numero % 100) / 10) {
                // Conto la lunghezza della sotto-sequenza formata da cifre tutte uguali fra di loro.
                occorrenze++;
            } else {
                int somma = (numero % 10) * occorrenze;
                // Aggiorno il nuovo numero intero sommandoci il contributo relativo alla somma delle cifre
                // dell'ultima sotto-sequenza di cifre tutte uguali.
                nuovoNumero += somma * (int) Math.pow(10, esponente);

                // Se la somma delle cifre ripetute è composta da 2 cifre
                // (es. con la sequenza 999 - la cui somma è 27), l'esponente
                // deve essere aumentato di 2 (devo scalare a sinistra
                // di 2 posizioni), altrimenti di 1 (scalo di 1 sola posizione).
                // Nota: la somma delle cifre di qualsiasi numero intero è
                // sempre composta da al massimo 2 cifre.
                esponente += (short) (somma > 9 ? 2 : 1);

                // La sotto-sequenza di cifre uguali è terminata, quindi ricomincio a contare da 1.
                occorrenze = 1;
            }
            numero /= 10; // Passo a trattare la cifra precedente.
        }
        return nuovoNumero;
    }


    // #fine: javammexercises
}
