package com.github.lorenzoyang.lab18;

class VisitaSerpentina {
    // #stato: completato
    // #inizio: javamm

    int[] visitaSerpentina(int[][] m) {
        int[] risultato = new int[m[0].length];
        int colonna = 0, riga = 0, direzione = 1;

        while (colonna < m[0].length) {
            risultato[colonna] = m[riga][colonna];
            if (riga == 0) {
                direzione = 1;
            } else if (riga == m.length - 1) {
                direzione = -1;
            }
            riga += direzione;
            colonna++;
        }
        return risultato;
    }


    /**************************************************************************
     * Soluzione alternativa (del docente)
     **************************************************************************/
    int[] alternativa_visitaSerpentina(int[][] m) {
        // Array di output.
        int[] serpentina = new int[m[0].length];

        // Indice per scorrere l'array di output,
        // utilizzato anche per scorrere le colonne di m.
        int indice = 0;

        // Indice per scorrere le righe di m.
        int riga = 0;

        // Indicatore di direzione, se mi sto spostando lungo
        // la diagonale verso il basso (true) o verso l'alto (false).
        boolean versoIlBasso = true;

        // Ciclo fino a quando non ho riempito tutto l'array di output.
        while (indice < m[0].length) {

            // Assegno un nuovo valore all'array di output.
            serpentina[indice] = m[riga][indice];
            indice++;

            // Incremento o decremento l'indice riga, a seconda che
            // stia procedendo verso il basso o verso l'alto.
            riga = (versoIlBasso) ? riga + 1 : riga - 1;

            // Se ho raggiunto la prima o l'ultima riga, inverto la
            // direzione di ricerca.
            if ((riga == m.length - 1) || (riga == 0))
                versoIlBasso = !versoIlBasso;
        }

        return serpentina;
    }

    // #fine: javamm
}
