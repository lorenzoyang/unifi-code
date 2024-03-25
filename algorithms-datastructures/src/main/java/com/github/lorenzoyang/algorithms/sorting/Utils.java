package com.github.lorenzoyang.algorithms.sorting;

import java.util.Random;

class Utils {
    private static final Random random = new Random();

    public static <T> void printArray(T[] array) {
        for (var i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static <T extends Comparable<T>> void printArray(T[] array, ArraySorter<T> sorter) {
        System.out.println("Before sorting: ");
        printArray(array);
        sorter.sort(array);
        System.out.println("After sorting: ");
        printArray(array);
    }

    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static <T extends Comparable<T>> boolean less(T[] array, int i, int j) {
        return array[i].compareTo(array[j]) < 0;
    }

    public static <T extends Comparable<T>> boolean less(T i, T j) {
        return i.compareTo(j) < 0;
    }

    public static Integer[] generateIntegerArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }
}

