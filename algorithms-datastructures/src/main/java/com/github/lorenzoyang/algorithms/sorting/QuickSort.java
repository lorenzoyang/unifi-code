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
        var array1 = generateIntegerArray(10);
        printArray(array1, QuickSort::sort);

        int k = 5;
        var array2 = generateIntegerArray(10);
        System.out.println("Select " + k + " rd element: " + QuickSort.select(array2, k));
        printArray(array2);
    }
}
