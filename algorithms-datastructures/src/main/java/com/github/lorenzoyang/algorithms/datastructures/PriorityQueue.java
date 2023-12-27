package com.github.lorenzoyang.algorithms.datastructures;

/**
 * La coda di priorità basata sulla struttura dati heap.
 * <p>
 * Per semplicità, ogni elemento della coda di priorità e' composto da solo una chiave di tipo Key.
 */
public class PriorityQueue<Key extends Comparable<Key>> {

    private final DynamicArray<Key> pq; // array di elementi

    public PriorityQueue() {
        // creo un array di dimensione 1, e il primo elemento [0] sarà null (non lo uso)
        pq = new DynamicArray<>(1);
        pq.insert(0, null);
    }

    /**
     * Inserisce una nuova chiave nella coda di priorità
     */
    public void insert(Key key) {
        pq.insert(pq.size(), key); // aggiungo la chiave in fondo all'array, saltando l'elemento [0]
        upHeap(pq.size() - 1);
    }

    /**
     * Restituisce la chiave con la priorità massima e la rimuove dalla coda di priorità
     */
    public Key delMax() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        Key max = pq.get(1);
        swap(1, pq.size() - 1);
        pq.remove(pq.size() - 1);
        downHeap(1);
        return max;
    }

    /**
     * Restituisce la chiave con la priorità massima senza rimuoverla dalla coda di priorità
     */
    public Key max() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return pq.get(1);
    }

    public int size() {
        return pq.size() - 1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // --------------------------------------------------------------------------------

    /**
     * fa risalire la nuova chiave lungo un cammino dalle foglie verso la radice
     * finche' non risulta ripristinata la proprieta' di heap.
     * <p>
     * metodo privato di supporto
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
        while (2 * k < pq.size()) {
            int j = 2 * k; // uno dei suoi due figli
            if (j < pq.size() && less(j, j + 1)) { // se il secondo figlio e' maggiore del primo
                j++;
            }
            if (!less(k, j)) { // se il nodo k e' maggiore del figlio j (figlio maggiore)
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
        Key temp = pq.get(i);
        pq.set(i, pq.get(j));
        pq.set(j, temp);
    }

    /**
     * Restituisce il numero di elementi nella coda di priorità
     */
    private boolean less(int i, int j) {
        return pq.get(i).compareTo(pq.get(j)) < 0;
    }

    public static void main(String[] args) {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.insert(0, null);
        array.insert(1, 1);
        System.out.println(array.size());
    }
}
