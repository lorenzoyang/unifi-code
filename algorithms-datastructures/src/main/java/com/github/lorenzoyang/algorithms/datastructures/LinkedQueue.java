package com.github.lorenzoyang.algorithms.datastructures;

public class LinkedQueue<T> {
    /**
     * class Nodo che rappresenta un elemento della coada
     */
    private static class Node<T> {
        private T value;
        private Node<T> next;
    }

    private Node<T> front; // punta sempre al primo elemento della coda
    private Node<T> rear; // punta sempre all'ultimo elemento della coda
    private int size;

    public LinkedQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    /**
     * aggiunge un elemento alla coda secondo la politica FIFO
     * aggiunge quindi l'elemento in fondo alla coda
     */
    public void enqueue(T element) {
        var oldRear = rear;
        rear = new Node<>();
        rear.value = element;
        rear.next = null;

        if (isEmpty()) front = rear;
        else oldRear.next = rear;
        size++;
    }

    /**
     * rimuove un elemento dalla coda secondo la politica FIFO
     * rimuove quindi l'elemento in testa alla coda
     * restituisce l'elemento rimosso
     */
    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        var element = front.value;
        front = front.next;
        size--;
        if (isEmpty()) rear = null;
        return element;
    }

    /**
     * restituisce l'elemento in testa alla coda senza rimuoverlo
     */
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return front.value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
