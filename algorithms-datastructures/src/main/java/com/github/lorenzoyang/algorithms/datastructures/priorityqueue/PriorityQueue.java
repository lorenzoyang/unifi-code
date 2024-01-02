package com.github.lorenzoyang.algorithms.datastructures.priorityqueue;

public interface PriorityQueue<Key extends Comparable<Key>> {

    /**
     * Inserisce una nuova chiave nella coda di priorità
     */
    void insert(Key key);

    /**
     * Restituisce la chiave con la priorità massima e la rimuove dalla coda di priorità
     */
    Key remove();

    /**
     * Restituisce la chiave con la priorità massima senza rimuoverla dalla coda di priorità
     */
    Key max();

    int size();

    boolean isEmpty();
}
