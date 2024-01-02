package com.github.lorenzoyang.algorithms.datastructures.priorityqueue;

import com.github.lorenzoyang.algorithms.datastructures.DynamicArray;

/**
 * La coda di priorità basata sulla struttura dati heap.
 * <p>
 * Per semplicita supponiamo che i record siano costituiti solo da una chiave intera
 * (che rappresenta il valore di priorita')
 * e siano memorizzati in un vettore "pq" di una data dimensione massima "pq.length",
 * e che "pq.size()" sia il numero di dati attualmente memorizzati a costituire lo heap.
 */
public class HeapPriorityQueue<Key extends Comparable<Key>> implements PriorityQueue<Key> {
    private final DynamicArray<Key> heap; // array di elementi

    public HeapPriorityQueue() {
        // creo un array di dimensione 1, e il primo elemento [0] sarà null (non lo uso)
        this.heap = new DynamicArray<>(1);
        this.heap.insert(0, null);
    }


    /**
     * Inserisce una nuova chiave nella coda di priorità
     */
    @Override
    public void insert(Key key) {
        // inserisce la chiave in fondo all'array, saltando l'elemento [0]
        heap.insert(heap.size(), key); // pq.size aumenta di 1
        upHeap(heap.size() - 1); // pq.size - 1 è l'indice dell'ultimo elemento inserito
    }

    /**
     * Restituisce la chiave con la priorità massima e la rimuove dalla coda di priorità
     */
    @Override
    public Key remove() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        Key max = heap.get(1); // il primo elemento è il massimo
        swap(1, heap.size() - 1); // scambio il primo elemento con l'ultimo
        heap.remove(heap.size() - 1); // rimuovo l'ultimo elemento
        downHeap(1); // riordino l'array (heap)
        return max;
    }

    @Override
    public Key max() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        return heap.get(1);
    }

    @Override
    public int size() {
        return heap.size() - 1; // il primo elemento non fa parte della coda di priorità
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    // --------------------------------------------------------------------------------
    // metodi privati di supporto
    // --------------------------------------------------------------------------------

    /**
     * fa risalire la nuova chiave lungo un cammino dalle foglie verso la radice
     * finche' non risulta ripristinata la proprieta' di heap.
     */
    private void upHeap(int k) {
        // finche' k non e' la radice(k=1) e la chiave del genitore(k/2) e' minore della chiave
        while (k > 1 && less(k / 2, k)) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    /**
     * Questa procedura si muove a partire dalla k-esima posizione del vettore verso il basso, scambiando
     * il nodo k con il piu grande dei suoi figli (si osservi che un nodo puo' avere anche un solo figlio)
     * finche' il nodo k non risulta piu' grande di entrambi i suoi figli oppure finche' non si e' raggiunto
     * il fondo dello heap.
     */
    private void downHeap(int k) {
        while (2 * k < heap.size()) {
            int j = 2 * k; // uno dei suoi due figli
            if (j < heap.size() - 1 && less(j, j + 1)) { // se il secondo figlio e' maggiore del primo
                j++;
            }
            if (!less(k, j)) { // se il nodo k e' maggiore del suo figlio j (figlio maggiore)
                break; // interrompo il ciclo
            }
            swap(k, j);
            k = j;
        }
    }


    /**
     * Scambia due elementi dell'array
     */
    private void swap(int i, int j) {
        Key temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Restituisce il numero di elementi nella coda di priorità
     */
    private boolean less(int i, int j) {
        return heap.get(i).compareTo(heap.get(j)) < 0;
    }
}
