package com.github.lorenzoyang.algorithms.sorting;

import static com.github.lorenzoyang.algorithms.sorting.Utils.*;

public class SelectionSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 0; i < array.length - 2; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length - 1; j++) {
                if (less(array, j, minIndex)) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    public static void main(String[] args) {
        var array = generateIntegerArray(10);
        printArray(array, SelectionSort::sort);
    }
}
