package com.github.lorenzoyang.algorithms.search;

import com.github.lorenzoyang.algorithms.datastructures.DynamicArray;

/**
 * Ricerca sequenziale
 */
public class SequentialSearch {
    /**
     * Ricerca sequenziale standard
     * restituisce l'indice della prima occorrenza di value
     */
    public static <T> int search(T[] array, T value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Ricerca sequenziale con sentinella
     * restituisce l'indice della prima occorrenza di value
     * <p>
     * questo piccolo accorgimento consente di
     * evitare questo doppio confronto ad ogni passo
     */
    public static <T> int search(DynamicArray<T> array, T value) {
        // la n + 1-esima posizione per memorizzare la sentinella
        array.insert(array.size(), value);
        int i = 0;
        while (array.get(i++) != value) ;
        array.remove(array.size() - 1);
        return i >= array.size() ? -1 : i - 1;
    }
}
