package com.github.lorenzoyang.algorithms.sorting;

import static com.github.lorenzoyang.algorithms.sorting.Utils.generateIntegerArray;
import static com.github.lorenzoyang.algorithms.sorting.Utils.printArray;

public class HeapSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        int n = array.length;

        // costruzione dell'heap
        // si parte dalla metà dell'array e si scende fino a 1
        for (int k = n / 2; k >= 1; k--) {
            sink(array, k, n);
        }

        // ordinamento
        while (n > 1) {
            swap(array, 1, n--);
            sink(array, 1, n);
        }
    }

    private static <T extends Comparable<T>> void sink(T[] array, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(array, j, j + 1)) j++;
            if (!less(array, k, j)) break;
            swap(array, k, j);
            k = j;
        }
    }

    // ----------------------------------------------------------------------------------
    // metodi di supporto per l'ordinamento heap
    // essendo il primo elemento delo heap non viene utilizzato, si parte da l'indice 1
    // ----------------------------------------------------------------------------------

    private static <T extends Comparable<T>> boolean less(T[] array, int i, int j) {
        return array[i - 1].compareTo(array[j - 1]) < 0;
    }

    private static <T> void swap(T[] array, int i, int j) {
        T tmp = array[i - 1];
        array[i - 1] = array[j - 1];
        array[j - 1] = tmp;
    }

    public static void main(String[] args) {
        var array1 = generateIntegerArray(10);
        var array2 = generateIntegerArray(10);
        var array3 = generateIntegerArray(10);

        HeapSort.sort(array1);
        HeapSort.sort(array2);
        HeapSort.sort(array3);

        printArray(array1);
        printArray(array2);
        printArray(array3);
    }
}
