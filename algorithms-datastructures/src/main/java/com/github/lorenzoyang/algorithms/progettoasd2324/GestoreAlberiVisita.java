package com.github.lorenzoyang.algorithms.progettoasd2324;

/**
 * Lorenzo Yang
 * Matricola: 7136074
 */
public class GestoreAlberiVisita {
    private NodoLF albero; // la radice dell'albero di visita

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
            return "Nodo '" + nodo + "' non appartiene all'albero di visita";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Figli del vertice '").append(nodo).append("': ");
        for (NodoLF figlio : alberoNodo.figli()) {
            sb.append(figlio.vertice()).append(", ");
        }
        return sb.toString();
    }

    private NodoLF cercaNodo(NodoLF albero, Nodo nodo) {
        if (albero.vertice().equals(nodo)) {
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
