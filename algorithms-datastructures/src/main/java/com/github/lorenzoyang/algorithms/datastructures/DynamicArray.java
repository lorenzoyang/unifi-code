package com.github.lorenzoyang.algorithms.datastructures;

/**
 * Vettore dinamico che si ridimensiona automaticamente quando necessario
 */
public class DynamicArray<T> {
    private T[] array; // array di elementi
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
        // se l'indice è fuori dai limiti dell'array, lancio un'eccezione
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

    /**
     * Inserisce un elemento in una posizione specifica
     * range di indici validi: [0, size]
     */
    public void insert(int index, T value) {
        resize(); // controllo prima di aggiungere un elemento se l'array è pieno
        // se l'indice è fuori dai limiti dell'array, lancio un'eccezione
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        // sposto tutti gli elementi successivi di una posizione a destra
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        size++;
    }

    /**
     * Raddoppia o dimezza la capacità dell'array se necessario
     */
    private void resize() {
        int newCapacity;
        if (size >= array.length * 3 / 4) { // se l'array è pieno al 75%, lo raddoppio
            newCapacity = array.length * 2;
        } else if (size == array.length / 4) { // se l'array è pieno al 25%, lo dimezzo
            newCapacity = array.length / 2;
        } else { // altrimenti non faccio nulla
            return; // interrompo l'esecuzione del metodo
        }
        // creo un nuovo array con la nuova capacità
        @SuppressWarnings("unchecked") T[] newArray = (T[]) new Object[newCapacity];
        // copio gli elementi dall'array vecchio al nuovo
        System.arraycopy(array, 0, newArray, 0, size);
        // assegno il nuovo array alla variabile d'istanza
        array = newArray;
    }

    /**
     * Aggiunge un elemento subito dopo l'ultimo elemento
     */
    public void add(T value) {
        resize(); // controllo prima di aggiungere un elemento se l'array è pieno
        array[size++] = value;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        // rimuovere un elemento consiste nel spostare tutti gli elementi successivi di una posizione a sinistra
        for (int i = index; i <= size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public int indexOf(T value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return array.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
