package com.github.lorenzoyang.algorithms.sorting;

@FunctionalInterface
interface ArraySorter<T extends Comparable<T>> {
    void sort(T[] array);
}
