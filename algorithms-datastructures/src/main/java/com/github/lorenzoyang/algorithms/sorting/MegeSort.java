package com.github.lorenzoyang.algorithms.sorting;

import static com.github.lorenzoyang.algorithms.sorting.Utils.*;

public class MegeSort {
    // --------------------------------------------------
    // top-down merge sort, che si basa sulla ricorsione
    // --------------------------------------------------
    public static <T extends Comparable<T>> void sort(T[] array) {
        @SuppressWarnings("unchecked") T[] aux = (T[]) new Comparable[array.length];
        topDownSort(array, aux, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void topDownSort(T[] array, T[] aux, int low, int hight) {
        if (hight <= low) return;
        int mid = low + (hight - low) / 2; // calcola il punto medio dell'array, e' un modo per evita overflow
        topDownSort(array, aux, low, mid); // ordina la prima metà
        topDownSort(array, aux, mid + 1, hight); // ordina la seconda metà
        merge(array, aux, low, mid, hight); // merge le due metà
    }

    private static <T extends Comparable<T>> void merge(T[] array, T[] aux, int low, int mid, int hight) {
        // copia il contenuto di array in aux
        for (int k = low; k <= hight; k++) {
            aux[k] = array[k];
        }

        // merge
        int i = low, j = mid + 1;
        for (int k = low; k <= hight; k++) {
            if (i > mid) { // se la prima metà è finita
                array[k] = aux[j++];
            } else if (j > hight) { // se la seconda metà è finita
                array[k] = aux[i++];
            } else if (less(aux[j], aux[i])) { // se il valore di j è minore di i
                array[k] = aux[j++];
            } else {
                array[k] = aux[i++];
            }
        }
    }

    // --------------------------------------------------
    // bottom-up merge sort, che si basa sull'iterazione
    // --------------------------------------------------
    public static <T extends Comparable<T>> void bottomUpSort(T[] array) {
        int n = array.length;
        @SuppressWarnings("unchecked") T[] aux = (T[]) new Comparable[n];
        for (int len = 1; len < n; len *= 2) {
            for (int low = 0; low < n - len; low += len + len) {
                int mid = low + len - 1;
                int hight = Math.min(low + len + len - 1, n - 1);
                merge(array, aux, low, mid, hight);
            }
        }
    }

    public static void main(String[] args) {
        // test top-down merge sort
        System.out.println("Top-down merge sort");
        var array1 = generateIntegerArray(10);
        printArray(array1, MegeSort::sort);

        System.out.println();

        // test bottom-up merge sort
        System.out.println("Bottom-up merge sort");
        var array2 = generateIntegerArray(10);
        printArray(array2, MegeSort::bottomUpSort);
    }

}
