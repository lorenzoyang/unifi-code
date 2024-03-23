package com.github.lorenzoyang.algorithms.sorting;

@FunctionalInterface
public interface ArraySorter<T extends Comparable<T>> {
    void sort(T[] array);
}
