package com.github.lorenzoyang.algorithms.search;

public class SequentialSearch<T> {
    public T search(T[] array, T value) {
        for (T item : array) {
            if (item.equals(value)) {
                return item;
            }
        }
        return null;
    }
}
