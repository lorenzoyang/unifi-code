package com.github.lorenzoyang.algorithms.sorting;

import static com.github.lorenzoyang.algorithms.sorting.Utils.*;

public class BubbleSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = array.length - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                if (less(array, j, j - 1)) {
                    swap(array, j, j - 1);
                }
            }
        }
    }

    public static <T extends Comparable<T>> void sortWithFlag(T[] array) {
        boolean sorted = false;
        int i = array.length - 1;
        while (!sorted) {
            sorted = true;
            for (int j = 1; j <= i; j++) {
                if (less(array, j, j - 1)) {
                    swap(array, j, j - 1);
                    sorted = false;
                }
            }
            i--;
        }
    }

    public static void main(String[] args) {
        var array1 = generateIntegerArray(10);
        printArray(array1, BubbleSort::sort);
        var array2 = generateIntegerArray(10);
        printArray(array2, BubbleSort::sortWithFlag);
    }
}
