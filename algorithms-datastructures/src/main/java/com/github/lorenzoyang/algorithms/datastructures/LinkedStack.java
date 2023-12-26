package com.github.lorenzoyang.algorithms.datastructures;

/**
 * Pila implementata con una lista concatenata
 */
public class LinkedStack<T> {
    /**
     * class Nodo che rappresenta un elemento dello stack
     */
    private class Node {
        private final T value;
        private final Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head; // punta sempre al primo elemento dello stack
    private int size;

    public LinkedStack() {
        this.head = null;
        this.size = 0;
    }

    // restuituisce il valore del primo elemento dello stack
    public T peek() {
        if (head == null) {
            throw new IllegalStateException();
        }
        return head.value;
    }

    // inserisce un nuovo elemento in cima allo stack
    public void push(T value) {
        head = new Node(value, head);
        size++;
    }

    /**
     * rimuove il primo elemento dello stack e restituisce il suo valore
     */
    public T pop() {
        if (head == null) {
            throw new IllegalStateException();
        }
        var value = head.value;
        head = head.next;
        size--;
        return value;
    }

    public int size() {
        return size;
    }
}
