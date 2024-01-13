package com.github.lorenzoyang.algorithms.datastructures;

/**
 * Lista concatenata
 */
public class LinkedList<T> {
    // quando si ha un solo elemento, head e tail puntano allo stesso elemento
    private Node<T> head; // punta sempre al primo elemento della lista
    private Node<T> tail; // punta sempre all'ultimo elemento della lista
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size) { // se l'indicie è fuori dal range della lista, lancio un'eccezione
            throw new IndexOutOfBoundsException();
        }
        // per evitare di modificare la vera testa della lista, creo un nuovo puntatore
        // che punta alla testa
        var current = head;
        for (int i = 0; i < index; i++) {
            current = current.next();
        }
        return current.value();
    }

    public void set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        var current = head;
        for (int i = 0; i < index; i++) {
            current = current.next();
        }
        current.value(value);
    }

    public void add(T value) {
        var node = new Node<>(value, null); // il nuovo nodo contenenete il valore
        if (head == null) {
            head = tail = node;
        } else {
            tail.next(node);
            tail = tail.next();
        }
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) { // indicie 0 vuol dire rimuovere la testa
            head = head.next();
            if (head == null) {
                tail = null;
            }
        } else {
            var current = head;
            // altrimenti devo trovare l'elemento precedente a quello da rimuovere
            for (int i = 0; i < index - 1; i++) {
                current = current.next();
            }
            // il nodo successivo a quello da rimuovere diventa il successivo del nodo
            current.next(current.next().next());
            // se il nodo da rimuovere è l'ultimo, aggiorno la coda
            if (current.next() == null) {
                tail = current;
            }
        }
        size--;
    }

    public int size() {
        return size;
    }

}
