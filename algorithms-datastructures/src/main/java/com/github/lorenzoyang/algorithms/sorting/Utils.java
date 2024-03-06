package com.github.lorenzoyang.algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

public class Utils {
    private static final Random random = new Random();

    public static <T> void printArray(T[] array) {
        for (var i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printArray(int[] array) {
        for (var i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
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
        var array = generateIntArray(size);
        return Arrays.stream(array).boxed().toArray(Integer[]::new);
    }

    public static int[] generateIntArray(int size) {
        var array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }
}
