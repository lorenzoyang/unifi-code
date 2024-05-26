package com.github.lorenzoyang.algorithms.progettoasd2324;

/**
 * Classe per la gestione degli alberi di visita di un grafo.
 *
 * @author Lorenzo Yang
 */
public class GestoreAlberiVisita {
    private NodoLF albero;

    public GestoreAlberiVisita() {
        this(null);
    }

    public GestoreAlberiVisita(NodoLF albero) {
        this.albero = albero;
    }

    public void aggiornaAlbero(NodoLF albero) {
        this.albero = albero;
    }

    public String figliDelNodo(Nodo nodo) {
        if (albero == null) {
            throw new IllegalStateException("Albero non inizializzato");
        }
        NodoLF alberoNodo = cercaNodo(albero, nodo);
        if (alberoNodo == null) {
            return "Nodo non trovato";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Figli di ").append(nodo).append(": ");
        for (NodoLF figlio : alberoNodo.figli()) {
            sb.append(figlio.radice()).append(", ");
        }
        return sb.toString();
    }

    private NodoLF cercaNodo(NodoLF albero, Nodo nodo) {
        if (albero.radice().equals(nodo)) {
            return albero;
        }
        for (NodoLF figlio : albero.figli()) {
            NodoLF risultato = cercaNodo(figlio, nodo);
            if (risultato != null) {
                return risultato;
            }
        }
        return null;
    }
}
