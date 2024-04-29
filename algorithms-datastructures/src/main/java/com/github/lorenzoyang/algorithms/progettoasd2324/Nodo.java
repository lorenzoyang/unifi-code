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
    private final List<Nodo> figli;

    public Nodo(String info) {
        this.info = info;
        this.figli = new LinkedList<>();
    }

    public String info() {
        return info;
    }

    public List<Nodo> figli() {
        return figli;
    }
}
