package com.github.lorenzoyang.algorithmsdatastructures.priorityqueue;

import com.github.lorenzoyang.algorithmsdatastructures.DynamicArray;

/**
 * Coda di priorità implementata con un array ordinato.
 * vettore ordinato in ordine crescente di priorita, ovvero un vettore
 * a[0...N − 1] in cui i dati sono mantenuti ordinati per valori crescenti del campo priorita'
 */
public class OrderedArrayPriorityQueue<Key extends Comparable<Key>> implements PriorityQueue<Key> {
    private final DynamicArray<Key> array; // array ordinato

    public OrderedArrayPriorityQueue() {
        array = new DynamicArray<>();
    }


    /**
     * Inserisce un elemento nella coda di priorita'.
     */
    @Override
    public void insert(Key key) {
        // inserire l'elemento nella posizione corretta
        int i = 0;
        while (i < array.size() && key.compareTo(array.get(i)) > 0) {
            i++;
        }
        array.insert(i, key);
    }

    /**
     * Rimuove l'elemento con la chiave piu' grande.
     * che e' l'ultimo elemento dell'array.
     */
    @Override
    public Key remove() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        Key max = array.get(array.size() - 1);
        array.remove(array.size() - 1);
        return max;
    }

    @Override
    public Key max() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        // l'elemento con la chiave piu' grande e' l'ultimo elemento dell'array
        return array.get(array.size() - 1);
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }
}
