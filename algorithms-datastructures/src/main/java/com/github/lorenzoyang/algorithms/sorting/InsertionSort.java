package com.github.lorenzoyang.algorithms.sorting;

import static com.github.lorenzoyang.algorithms.sorting.Utils.generateIntegerArray;
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
        var array1 = generateIntegerArray(10);
        printArray(array1, InsertionSort::sort);
    }
}
