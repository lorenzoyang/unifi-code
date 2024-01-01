package com.github.lorenzoyang.algorithmsdatastructures.search;

import com.github.lorenzoyang.algorithmsdatastructures.DynamicArray;

/**
 * Ricerca sequenziale
 */
public class SequentialSearch {
    /**
     * Ricerca sequenziale standard
     * restituisce l'indice della prima occorrenza di target
     */
    public static <T> int search(T[] array, T target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Ricerca sequenziale con sentinella
     * restituisce l'indice della prima occorrenza di  target
     * <p>
     * questo piccolo accorgimento consente di
     * evitare questo doppio confronto ad ogni passo
     */
    public static <T> int search(DynamicArray<T> array, T target) {
        // la n + 1-esima posizione per memorizzare la sentinella
        array.insert(array.size(), target);
        int i = 0;
        while (array.get(i++) != target) ;
        array.remove(array.size() - 1);
        return i >= array.size() ? -1 : i - 1;
    }

    /**
     * Ricerca sequenziale con sentinella senza l'utilizzo di DynamicArray
     * restituisce l'indice della prima occorrenza di target
     */
    public static <T> int searchSentinel(T[] array, T target) {
        if (array.length == 0) {
            return -1;
        }

        T last = array[array.length - 1];
        array[array.length - 1] = target;

        int i = 0;
        while (true) {
            if (array[i] == target) {
                break;
            }
            i++; // sicuramente arriverà a i = array.length - 1
        }
        array[array.length - 1] = last; // ripristino l'ultimo elemento

        // se l'i è arrivato alla fine, e l'ultimo elemento è uguale a target
        if (i == array.length - 1 && target == last) {
            return i;
        } else if (i == array.length - 1 && target != last) {
            return -1;
        } else {
            return i;
        }
    }
}
