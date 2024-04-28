package com.github.lorenzoyang.algorithms.progettoasd2324;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Grafo non orientato rappresentato con liste di adiacenza.
 *
 * @author Lorenzo Yang
 */
public class Grafo {
    private final Map<String, Nodo> listaNodi;
    private int numeroArchi;

    public Grafo() {
        this.listaNodi = new HashMap<>();
        this.numeroArchi = 0;
    }

    public int numeroVertici() {
        return listaNodi.size();
    }

    public int numeroArchi() {
        return numeroArchi;
    }

    public int numeroArchiIncidenti(String vertice) {
        controlliVertici(vertice);
        return listaNodi.get(vertice).numeroArchiIncidenti();
    }

    public boolean adiacenti(String vertice1, String vertice2) {
        controlliVertici(vertice1, vertice2);
        return listaNodi.get(vertice1).adiacente(vertice2);
        // oppure
        // return listaNodi.get(vertice2).adiacente(vertice1);
    }

    public void aggiungiVertice(String vertice) {
        if (listaNodi.containsKey(vertice)) {
            throw new IllegalArgumentException("Il vertice " + vertice + " esiste già.");
        }
        listaNodi.put(vertice, new Nodo(vertice));
    }

    public void aggiungiArco(String vertice1, String vertice2) {
        controlliVertici(vertice1, vertice2);
        if (adiacenti(vertice1, vertice2)) {
            throw new IllegalArgumentException("L'arco tra " + vertice1 + " e " + vertice2 + " esiste già.");
        }
        listaNodi.get(vertice1).aggiungiAdiacente(vertice2);
        listaNodi.get(vertice2).aggiungiAdiacente(vertice1);
        numeroArchi++;
    }

    public void rimuoviVertice(String vertice) {
        controlliVertici(vertice);
        for (String adiacente : listaNodi.get(vertice).listaAdiacenti()) {
            listaNodi.get(adiacente).rimuoviAdiacente(vertice);
        }
        numeroArchi -= listaNodi.get(vertice).numeroArchiIncidenti();
        listaNodi.remove(vertice);
    }

    public void rimuoviArco(String vertice1, String vertice2) {
        controlliVertici(vertice1, vertice2);
        if (!listaNodi.get(vertice1).adiacente(vertice2)) {
            throw new IllegalArgumentException("L'arco tra " + vertice1 + " e " + vertice2 + " non esiste.");
        }
        listaNodi.get(vertice1).rimuoviAdiacente(vertice2);
        listaNodi.get(vertice2).rimuoviAdiacente(vertice1);
        numeroArchi--;
    }

    public void informazioneVertice(String vertice) {
        if (!listaNodi.containsKey(vertice)) {
            System.out.println("Il vertice " + vertice + " non fa parte del grafo.");
        }
        System.out.println("Vertice: " + vertice);
        System.out.println("Numero archi incidenti: " + listaNodi.get(vertice).numeroArchiIncidenti());
        System.out.println("Archi incidenti su " + vertice + ": ");
        for (String adiacente : listaNodi.get(vertice).listaAdiacenti()) {
            System.out.println("    (" + vertice + ", " + adiacente + ")");
        }
    }

    public Nodo getAlberoBFS(String vertice) {
        controlliVertici(vertice);

        Map<String, Boolean> visitati = new HashMap<>();
        Queue<String> coda = new LinkedList<>();

        coda.add(vertice);
        visitati.put(vertice, true);
        Nodo radice = new Nodo(vertice);
        while (!coda.isEmpty()) {
            String nodo = coda.poll();
            for (String adiacente : listaNodi.get(nodo).listaAdiacenti()) {
                if (!visitati.get(adiacente)) {
                    visitati.put(adiacente, true);
                    coda.add(adiacente);
                    Nodo figlio = new Nodo(adiacente);
                    radice.figli().add(figlio);
                }
            }
        }
        return radice;
    }

    public Nodo getAlberoDFS(String vertice) {
        controlliVertici(vertice);
        Map<String, Boolean> visitati = new HashMap<>();
        return getAlberoDFS(vertice, visitati);
    }

    // Metodo privato per la visita in profondità.
    private Nodo getAlberoDFS(String vertice, Map<String, Boolean> visitati) {
        visitati.put(vertice, true);
        Nodo radice = new Nodo(vertice);
        for (String adiacente : listaNodi.get(vertice).listaAdiacenti()) {
            if (!visitati.get(adiacente)) {
                Nodo figlio = getAlberoDFS(adiacente, visitati);
                radice.figli().add(figlio);
            }
        }
        return radice;
    }

    // Metodo privato per controllare l'esistenza dei vertici.
    private void controlliVertici(String... vertici) {
        for (String vertice : vertici) {
            if (!listaNodi.containsKey(vertice)) {
                throw new IllegalArgumentException("Il vertice " + vertice + " non esiste.");
            }
        }
    }
}
