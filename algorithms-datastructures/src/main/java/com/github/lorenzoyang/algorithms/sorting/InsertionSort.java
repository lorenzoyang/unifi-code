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

    public static <T extends Comparable<T>> void indirectSort(T[] array) {
        int[] indices = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            indices[i] = i;
        }
        for (int i = 1; i < array.length; i++) {
            int tmp = indices[i];
            int j = i;
            while (j > 0 && array[indices[j - 1]].compareTo(array[tmp]) > 0) {
                indices[j] = indices[j - 1];
                j--;
            }
            indices[j] = tmp;
        }
        System.out.println("Indices: ");
        for (int i = 0; i < indices.length; i++) {
            System.out.print(indices[i] + " ");
        }


    }

    public static void main(String[] args) {
        var array1 = generateIntegerArray(10);
        printArray(array1, InsertionSort::sort);

        indirectSort(array1);
    }
}
