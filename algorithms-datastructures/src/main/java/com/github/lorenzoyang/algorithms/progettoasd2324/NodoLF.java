package com.github.lorenzoyang.algorithms.progettoasd2324;

import java.util.LinkedList;
import java.util.List;

/**
 * Lorenzo Yang
 * Matricola: 7136074
 */
public class NodoLF {
    // NodoLF è una classe che rappresenta un nodo di un "albero lista figli (LF)".

    private final Nodo vertice; // l'informazione contenuta nel nodo
    private final LinkedList<NodoLF> figli; // lista dei figli del nodo

    public NodoLF(Nodo vertice) {
        this.vertice = vertice;
        this.figli = new LinkedList<>();
    }

    public Nodo vertice() {
        return vertice;
    }

    public List<NodoLF> figli() {
        return this.figli;
    }

    public void aggiungiFiglio(NodoLF figlio) {
        figli.addLast(figlio);
    }
}
