package com.github.lorenzoyang.algorithms.datastructures;

public class LinkedList<T> {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        var current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public void set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        var current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.value = value;
    }

    public void add(T value) {
        var node = new Node(value, null);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            var current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            if (current.next == null) {
                tail = current;
            }
        }
        size--;
    }

    public int size() {
        return size;
    }

    private class Node {
        private T value;
        private Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
