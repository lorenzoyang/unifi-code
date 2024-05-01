package com.github.lorenzoyang.algorithms.progettoasd2324;

public class GestoreAlberiVisita {
    private Albero albero;

    public GestoreAlberiVisita() {
        this(null);
    }

    public GestoreAlberiVisita(Albero albero) {
        this.albero = albero;
    }

    public void aggiornaAlbero(Albero albero) {
        this.albero = albero;
    }

    public String figliDelNodo(Nodo nodo) {
        if (albero == null) {
            throw new IllegalStateException("Albero non inizializzato");
        }
        Albero alberoNodo = cercaNodo(albero, nodo);
        if (alberoNodo == null) {
            return "Nodo non trovato";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Figli di ").append(nodo).append(": ");
        for (Albero figlio : alberoNodo.figli()) {
            sb.append(figlio.radice()).append(", ");
        }
        return sb.toString();
    }

    private Albero cercaNodo(Albero albero, Nodo nodo) {
        if (albero.radice().equals(nodo)) {
            return albero;
        }
        for (Albero figlio : albero.figli()) {
            Albero risultato = cercaNodo(figlio, nodo);
            if (risultato != null) {
                return risultato;
            }
        }
        return null;
    }
}
