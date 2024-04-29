package com.github.lorenzoyang.algorithms.progettoasd2324;

public class GestoreAlberiVisita {
    private Nodo radice;

    public GestoreAlberiVisita() {
        this.radice = null;
    }

    public void salvaAlberoVisita(Nodo radice) {
        this.radice = radice;
    }

    public String figliDelNodo(String vertice) {
        if (radice == null)
            throw new IllegalStateException("Devi prima effettuare una visita e salvare il risultato nel gestore");
        Nodo nodo = cercaNodo(radice, vertice);
        if (nodo == null)
            return "Nodo non trovato";
        StringBuilder sb = new StringBuilder();
        sb.append("Figli di ").append(vertice).append(": ");
        for (Nodo figlio : nodo.figli())
            sb.append(figlio.info()).append(", ");
        return sb.toString();
    }

    private Nodo cercaNodo(Nodo nodo, String info) {
        if (nodo.info().equals(info))
            return nodo;
        for (Nodo figlio : nodo.figli()) {
            Nodo n = cercaNodo(figlio, info);
            if (n != null)
                return n;
        }
        return null;
    }
}
