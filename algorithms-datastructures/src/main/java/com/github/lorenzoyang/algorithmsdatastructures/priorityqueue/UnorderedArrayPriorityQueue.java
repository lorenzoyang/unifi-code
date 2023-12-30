package com.github.lorenzoyang.algorithmsdatastructures.priorityqueue;

import com.github.lorenzoyang.algorithmsdatastructures.DynamicArray;

/**
 * Coda di priorita' implementata con un array non ordinato.
 * Utilizzando un vettore disordinato i dati sono posti nel vettore a[0...N −1] cosi' come vengono
 * senza preoccuparsi del valore delle chiavi
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
}
