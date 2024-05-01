package com.github.lorenzoyang.algorithms.progettoasd2324;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Albero {
    private final Nodo radice;
    private final List<Albero> figli;

    public Albero(Nodo radice) {
        this.radice = radice;
        this.figli = new LinkedList<>();
    }

    public Nodo radice() {
        return radice;
    }

    // Resituisce una lista immutabile di figli
    public List<Albero> figli() {
        return Collections.unmodifiableList(figli);
    }

    public void aggiungiFiglio(Albero figlio) {
        figli.add(figlio);
    }
}
