package com.github.lorenzoyang.algorithms.sorting;

import static com.github.lorenzoyang.algorithms.sorting.Utils.*;

public class ShellSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        int n = array.length; // lunghezza dell'array
        int h = 1; // sequenza di incremento: 3x + 1 (1, 4, 13, 40, 121, ...)

        while (h < n / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            // ordinamento per inserzione con incremento h
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(array, j, j - h); j -= h) {
                    swap(array, j, j - h);
                }
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        var array = generateIntegerArray(10);
        printArray(array, ShellSort::sort);
    }
}
