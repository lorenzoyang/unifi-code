package com.github.lorenzoyang.algorithms.datastructures.priorityqueue;

import com.github.lorenzoyang.algorithms.datastructures.DynamicArray;

/**
 * Coda di priorita' implementata con un array non ordinato.
 */
public class UnorderedArrayPriorityQueue<Key extends Comparable<Key>> implements PriorityQueue<Key> {
    private final DynamicArray<Key> array; // array non ordinato

    public UnorderedArrayPriorityQueue() {
        array = new DynamicArray<>();
    }

    /**
     * Inserisce un elemento subito dopo l'ultimo elemento dell'array.
     * senza preoccuparsi di mantenere l'ordinamento.
     */
    @Override
    public void insert(Key key) {
        array.add(key);
    }

    @Override
    public Key remove() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        // trovare l'elemento con la chiave piu' grande
        int maxIndex = 0;
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i).compareTo(array.get(maxIndex)) > 0) {
                maxIndex = i;
            }
        }

        Key maxKey = array.get(maxIndex);
        array.set(maxIndex, array.get(array.size() - 1));
        array.remove(array.size() - 1);

        return maxKey;
    }

    @Override
    public Key max() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        // trovare l'elemento con la chiave piu' grande
        int maxIndex = 0;
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i).compareTo(array.get(maxIndex)) > 0) {
                maxIndex = i;
            }
        }
        return array.get(maxIndex);
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }


    /**
     * Scambia due elementi dell'array
     */
    private void swap(int i, int j) {
        Key temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    /**
     * Restituisce il numero di elementi nella coda di priorità
     */
    private boolean less(int i, int j) {
        return array.get(i).compareTo(array.get(j)) < 0;
    }
}
