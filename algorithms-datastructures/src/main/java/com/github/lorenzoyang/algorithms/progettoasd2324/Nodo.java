package com.github.lorenzoyang.algorithms.progettoasd2324;

import java.util.LinkedList;
import java.util.List;

/**
 * Nodo di un grafo non orientato rappresentato con liste di adiacenza.
 *
 * @author Lorenzo Yang
 */
public class Nodo {
    private final String info;
    private final List<String> listaAdiacenti;
    private final List<Nodo> figli;

    public Nodo(String info) {
        this.info = info;
        this.listaAdiacenti = new LinkedList<>();
        this.figli = new LinkedList<>();
    }

    public String info() {
        return info;
    }

    public List<String> listaAdiacenti() {
        return listaAdiacenti;
    }

    public List<Nodo> figli() {
        return figli;
    }

    public int numeroArchiIncidenti() {
        return listaAdiacenti.size();
    }

    public boolean adiacente(String vertice) {
        return listaAdiacenti.contains(vertice);
    }

    public void aggiungiAdiacente(String vertice) {
        listaAdiacenti.add(vertice);
    }

    public void rimuoviAdiacente(String vertice) {
        listaAdiacenti.remove(vertice);
    }
}
