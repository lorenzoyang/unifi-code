package com.github.lorenzoyang.algorithms.datastructures;

public class DynamicArray<T> {
    private T[] array;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    public DynamicArray(int capacity) {
        //noinspection unchecked
        this.array = (T[]) new Object[capacity];
        this.size = 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public void set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = value;
    }

    private void resize() {
        int newCapacity;
        if (size >= array.length * 3 / 4) {
            newCapacity = array.length * 2;
        } else if (size == array.length / 4) {
            newCapacity = array.length / 2;
        } else {
            return;
        }
        @SuppressWarnings("unchecked") T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public void add(T value) {
        resize();
        array[size++] = value;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
    }

    public int size() {
        return size;
    }
}
