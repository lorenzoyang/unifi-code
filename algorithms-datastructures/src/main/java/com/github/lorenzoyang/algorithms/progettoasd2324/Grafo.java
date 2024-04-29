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
    private final Map<String, LinkedList<String>> listeAdiacenza;
    private int numeroArchi;

    public Grafo() {
        this.listeAdiacenza = new HashMap<>();
        this.numeroArchi = 0;
    }

    public int numeroVertici() {
        return listeAdiacenza.size();
    }

    public int numeroArchi() {
        return numeroArchi;
    }

    public int numeroArchiIncidenti(String vertice) {
        controlliVertici(vertice);
        return listeAdiacenza.get(vertice).size();
    }

    public boolean adiacenti(String vertice1, String vertice2) {
        controlliVertici(vertice1, vertice2);
        return listeAdiacenza.get(vertice1).contains(vertice2);
        // oppure
        // return listeAdiacenza.get(vertice2).contains(vertice1);
    }

    public void aggiungiVertice(String vertice) {
        if (listeAdiacenza.containsKey(vertice)) {
            throw new IllegalArgumentException("Il vertice " + vertice + " esiste già.");
        }
        listeAdiacenza.put(vertice, new LinkedList<>());
    }

    public void aggiungiArco(String vertice1, String vertice2) {
        controlliVertici(vertice1, vertice2);
        if (adiacenti(vertice1, vertice2)) {
            throw new IllegalArgumentException("L'arco tra " + vertice1 + " e " + vertice2 + " esiste già.");
        }
        listeAdiacenza.get(vertice1).add(vertice2);
        listeAdiacenza.get(vertice2).add(vertice1);
        numeroArchi++;
    }

    public void rimuoviVertice(String vertice) {
        controlliVertici(vertice);
        for (String adiacente : listeAdiacenza.get(vertice)) {
            listeAdiacenza.get(adiacente).remove(vertice);
            numeroArchi--;
        }
        listeAdiacenza.remove(vertice);
    }

    public void rimuoviArco(String vertice1, String vertice2) {
        controlliVertici(vertice1, vertice2);
        if (!adiacenti(vertice1, vertice2)) {
            throw new IllegalArgumentException("L'arco tra " + vertice1 + " e " + vertice2 + " non esiste.");
        }
        listeAdiacenza.get(vertice1).remove(vertice2);
        listeAdiacenza.get(vertice2).remove(vertice1);
        numeroArchi--;
    }

    public void informazioneVertice(String vertice) {
        if (!listeAdiacenza.containsKey(vertice)) {
            System.out.println("Il vertice " + vertice + " non fa parte del grafo.");
        }
        System.out.println("Vertice: " + vertice);
        System.out.println("Numero archi incidenti: " + numeroArchiIncidenti(vertice));
        System.out.println("Archi incidenti su " + vertice + ": ");
        for (String adiacente : listeAdiacenza.get(vertice)) {
            System.out.println("    (" + vertice + ", " + adiacente + ")");
        }
    }

    public Nodo getAlberoBFS(String vertice) {
        controlliVertici(vertice);

        Map<String, Boolean> visitati = new HashMap<>();
        Queue<Nodo> coda = new LinkedList<>();
        Nodo radice = new Nodo(vertice);
        coda.add(radice);
        visitati.put(radice.info(), true);

        while (!coda.isEmpty()) {
            Nodo radiceCorrente = coda.poll();
            for (String adiacente : listeAdiacenza.get(radiceCorrente.info())) {
                if (!visitati.containsKey(adiacente)) {
                    Nodo figlio = new Nodo(adiacente);
                    coda.add(figlio);
                    visitati.put(adiacente, true);
                    radiceCorrente.figli().add(figlio);
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
        for (String adiacente : listeAdiacenza.get(vertice)) {
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
            if (!listeAdiacenza.containsKey(vertice)) {
                throw new IllegalArgumentException("Il vertice " + vertice + " non esiste.");
            }
        }
    }
}
