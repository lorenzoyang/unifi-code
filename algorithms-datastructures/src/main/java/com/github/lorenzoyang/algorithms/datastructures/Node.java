package com.github.lorenzoyang.algorithms.datastructures;

/**
 * classe Node che rappresenta un nodo generico di una lista concatenata
 */
public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public Node() {
        this(null, null);
    }

    public T value() {
        return value;
    }

    public Node<T> next() {
        return next;
    }

    public void value(T value) {
        this.value = value;
    }

    public void next(Node<T> next) {
        this.next = next;
    }
}
