package com.github.lorenzoyang.algorithms.datastructures;

import java.util.stream.IntStream;

/**
 * Coda implementata con array circolare
 */
public class ArrayQueue<T> {
    private T[] array;
    private int size;
    private int front; // indica la posizione contenente la testa della coda
    private int rear; // indica la posizione contenente il fondo della coda

    public static final int DEFAULT_CAPACITY = 8;

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int capacity) {
        //noinspection unchecked
        array = (T[]) new Object[capacity];
        size = 0;
        front = 0;
        rear = 0;
    }

    /**
     * aggiunge un elemento alla coda secondo la politica FIFO
     * aggiunge quindi l'elemento in fondo alla coda
     */
    public void enqueue(T element) {
        if (size == array.length) resize(array.length * 2);
        array[rear++] = element;
        if (rear == array.length) rear = 0; // l'array e' circolare
        size++;
    }

    /**
     * rimuove un elemento dalla coda secondo la politica FIFO
     * rimuove quindi l'elemento in testa alla coda
     * restituisce l'elemento rimosso
     */
    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        var element = array[front];

        array[front] = null;
        size--;
        front++;

        if (front == array.length) front = 0; // l'array e' circolare
        if (size > 0 && size == array.length / 4) resize(array.length / 2); // ridimensiona l'array

        return element;
    }

    /**
     * restituisce l'elemento in testa alla coda senza rimuoverlo
     */
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return array[front];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * metodo di supporto per ridimensionare l'array
     */
    private void resize(int capacity) {
        //noinspection unchecked
        var temp = (T[]) new Object[capacity];
        IntStream.range(0, size).forEach(i -> temp[i] = array[(front + i) % array.length]);
        array = temp;
        front = 0;
        rear = size;
    }
}
