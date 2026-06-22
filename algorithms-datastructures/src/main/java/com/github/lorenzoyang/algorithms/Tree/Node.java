package com.github.lorenzoyang.algorithms.Tree;

public class Node<T> {
    T value;
    Node<T> left;
    Node<T> right;

    Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}