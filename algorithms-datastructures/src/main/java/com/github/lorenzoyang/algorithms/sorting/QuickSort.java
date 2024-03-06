package com.github.lorenzoyang.algorithms.sorting;

import static com.github.lorenzoyang.algorithms.sorting.Utils.*;

public class QuickSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {
        if (high > low) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int low, int high) {
        int i = low;
        int j = high + 1;
        T pivot = array[low];
        while (true) {
            // ++i perche' il pivot e' in posizione low
            while (less(array[++i], pivot)) {
                if (i == high) break;
            }

            // --j perche' j e' in posizione high + 1, per coerenza l'ho scritto comunque con il prefix
            while (less(pivot, array[--j])) {
                if (j == low) break; // ridondante, perche' il pivot e' in posizione low
            }

            // se si incrociano i due indici, si esce dal ciclo
            if (i >= j) break;

            // altrimenti si scambiano gli elementi
            swap(array, i, j);
        }

        // si scambia il pivot con l'elemento in posizione j
        swap(array, low, j);

        // adesso: a[low..j-1] <= a[j] <= a[j+1..high]
        return j;
    }

    public static <T extends Comparable<T>> T select(T[] array, int k) {
        if (k < 0 || k >= array.length) throw new IllegalArgumentException("index out of bounds");
        int low = 0, high = array.length - 1;
        while (high > low) {
            int pivot = partition(array, low, high);
            if (pivot > k) high = pivot - 1;
            else if (pivot < k) low = pivot + 1;
            else return array[pivot];
        }
        // restituisce l'elemento in posizione k (0 compreso)
        return array[low];
    }

    public static void main(String[] args) {
        Integer[] array1 = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        Integer[] array2 = {5, 3, 534, 3, 2, 44};
        Integer[] array3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        QuickSort.sort(array1);
        QuickSort.sort(array2);
        QuickSort.sort(array3);

        printArray(array1);
        printArray(array2);
        printArray(array3);

        System.out.println("-----------------");
        int k = 0;
        var array4 = new Integer[]{1, 33, 3, 55, 2, 4, 6};
        System.out.println("Select " + k + " rd element: " + QuickSort.select(array4, k));
        QuickSort.sort(array4);
        printArray(array4);

    }
}
