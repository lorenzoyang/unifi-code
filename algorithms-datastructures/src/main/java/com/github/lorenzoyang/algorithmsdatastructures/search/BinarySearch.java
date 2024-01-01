package com.github.lorenzoyang.algorithmsdatastructures.search;

import java.util.Arrays;

/**
 * Ricerca binaria
 */
public class BinarySearch {
    public static <T extends Comparable<T>> int iterativeSearch(T[] array, T target) {
        // array deve essere ordinato
        Arrays.sort(array);
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target.compareTo(array[mid]) == 0) {
                return mid;
            } else if (target.compareTo(array[mid]) < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static <T extends Comparable<T>> int recursiveSearch(T[] array, T target) {
        // array deve essere ordinato
        Arrays.sort(array);
        return recursiveSearch(array, target, 0, array.length - 1);
    }

    /**
     * metodo privato ricorsivo per la ricerca binaria
     */
    private static <T extends Comparable<T>> int recursiveSearch(T[] array, T target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (array[mid].compareTo(target) == 0) {
            return mid;
        } else if (array[mid].compareTo(target) < 0) {
            return recursiveSearch(array, target, mid + 1, high);
        } else {
            return recursiveSearch(array, target, low, mid - 1);
        }
    }
}
