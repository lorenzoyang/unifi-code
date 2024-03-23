package com.github.lorenzoyang.algorithms.sorting;

public class CountingSort {
    public static void sort(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int i : array) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        int[] count = new int[max - min + 1];

        for (int i : array) {
            count[i - min]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                array[index++] = i + min;
            }
        }
    }
}
