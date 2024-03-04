package com.github.lorenzoyang.algorithms.sorting;

import static com.github.lorenzoyang.algorithms.sorting.Utils.printArray;

public class InsertionSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            T tmp = array[i];
            int j = i;
            while (j > 0 && array[j - 1].compareTo(tmp) > 0) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Integer[] array1 = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        Integer[] array2 = {5, 3, 534, 3, 2, 44};
        Integer[] array3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        InsertionSort.sort(array1);
        InsertionSort.sort(array2);
        InsertionSort.sort(array3);

        printArray(array1);
        printArray(array2);
        printArray(array3);
    }
}
