package com.github.lorenzoyang.algorithms.sorting;

import static com.github.lorenzoyang.algorithms.sorting.Utils.generateIntegerArray;
import static com.github.lorenzoyang.algorithms.sorting.Utils.printArray;

public class CountingSort {
    public static void sort(Integer[] array) {
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

    static void main() {
        var array1 = generateIntegerArray(10);
        printArray(array1, CountingSort::sort);
    }
}
