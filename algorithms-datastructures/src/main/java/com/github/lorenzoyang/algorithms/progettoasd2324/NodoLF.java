package com.github.lorenzoyang.algorithms.progettoasd2324;

import java.util.LinkedList;
import java.util.List;

/**
 * 'Nodo Lista Figli': Nodo di un albero che ha un numero imprecisato di figli
 *
 * @author Lorenzo Yang
 */
public class NodoLF {
    private final Nodo radice; // l'informazione contenuta nel nodo
    private final LinkedList<NodoLF> figli;

    public NodoLF(Nodo radice) {
        this.radice = radice;
        this.figli = new LinkedList<>();
    }

    public Nodo radice() {
        return radice;
    }

    public List<NodoLF> figli() {
        return this.figli;
    }

    public void aggiungiFiglio(NodoLF figlio) {
        figli.addLast(figlio);
    }
}
