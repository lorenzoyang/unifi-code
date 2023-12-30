package com.github.lorenzoyang.algorithmsdatastructures.search;

import com.github.lorenzoyang.algorithmsdatastructures.DynamicArray;

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

    /**
     * Ricerca sequenziale con sentinella senza l'utilizzo di DynamicArray
     * restituisce l'indice della prima occorrenza di value
     */
    public static <T> int searchSentinel(T[] array, T value) {
        if (array.length == 0) {
            return -1;
        }

        T last = array[array.length - 1];
        array[array.length - 1] = value;

        int i = 0;
        while (true) {
            if (array[i] == value) {
                break;
            }
            i++; // sicuramente arriverà a i = array.length - 1
        }
        array[array.length - 1] = last; // ripristino l'ultimo elemento

        // se l'i è arrivato alla fine, e l'ultimo elemento è uguale a value
        if (i == array.length - 1 && value == last) {
            return i;
        } else if (i == array.length - 1 && value != last) {
            return -1;
        } else {
            return i;
        }
    }
}
