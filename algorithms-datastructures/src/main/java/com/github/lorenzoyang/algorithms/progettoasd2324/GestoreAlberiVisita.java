package com.github.lorenzoyang.algorithms.progettoasd2324;

public class GestoreAlberiVisita {
    private Albero albero;

    public GestoreAlberiVisita(Albero albero) {
        this.albero = albero;
    }

    public void aggiornaAlbero(Albero albero) {
        this.albero = albero;
    }

    public String figliDiNodo(Nodo nodo) {
        if (albero == null) {
            throw new IllegalStateException("Albero non inizializzato");
        }
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }
}
