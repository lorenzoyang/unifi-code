package com.github.lorenzoyang.algorithms.progettoasd2324;

import java.util.Objects;

/**
 * Lorenzo Yang
 * Matricola: 7136074
 */
public class Nodo {
    private final String info;

    public Nodo(String info) {
        this.info = info;
    }

    public String info() {
        return info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nodo)) return false;
        Nodo nodo = (Nodo) o;
        return Objects.equals(this.info(), nodo.info());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.info());
    }

    @Override
    public String toString() {
        return info;
    }
}
