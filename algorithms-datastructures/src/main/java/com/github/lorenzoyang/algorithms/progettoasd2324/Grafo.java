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
    // HashMap per memorizzare le liste di adiacenza.
    // Ogni lista di adiacenza (LinkedList<Nodo>) e' associata ad un nodo/vertice (Nodo).
    private final Map<Nodo, LinkedList<Nodo>> listeAdiacenza;
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

    public int numeroArchiIncidenti(Nodo vertice) {
        controlliEsistenzaVertici(vertice);
        return listeAdiacenza.get(vertice).size();
    }

    public boolean adiacenti(Nodo vertice1, Nodo vertice2) {
        controlliEsistenzaVertici(vertice1, vertice2);
        return listeAdiacenza.get(vertice1).contains(vertice2);
        // oppure
        // return listeAdiacenza.get(vertice2).contains(vertice1);
    }

    public void aggiungiVertice(Nodo vertice) {
        if (listeAdiacenza.containsKey(vertice)) {
            throw new IllegalArgumentException("Il vertice " + vertice + " esiste già.");
        }
        listeAdiacenza.put(vertice, new LinkedList<>());
    }

    public void aggiungiArco(Nodo vertice1, Nodo vertice2) {
        controlliEsistenzaVertici(vertice1, vertice2);
        if (adiacenti(vertice1, vertice2)) {
            throw new IllegalArgumentException("L'arco tra " + vertice1 + " e " + vertice2 + " esiste già.");
        }
        listeAdiacenza.get(vertice1).add(vertice2);
        listeAdiacenza.get(vertice2).add(vertice1);
        numeroArchi++;
    }

    public void rimuoviVertice(Nodo vertice) {
        controlliEsistenzaVertici(vertice);
        for (Nodo adiacente : listeAdiacenza.get(vertice)) {
            listeAdiacenza.get(adiacente).remove(vertice);
            numeroArchi--;
        }
        listeAdiacenza.remove(vertice);
    }

    public void rimuoviArco(Nodo vertice1, Nodo vertice2) {
        controlliEsistenzaVertici(vertice1, vertice2);
        if (!adiacenti(vertice1, vertice2)) {
            throw new IllegalArgumentException("L'arco tra " + vertice1 + " e " + vertice2 + " non esiste.");
        }
        listeAdiacenza.get(vertice1).remove(vertice2);
        listeAdiacenza.get(vertice2).remove(vertice1);
        numeroArchi--;
    }

    public void informazioneVertice(Nodo vertice) {
        if (!listeAdiacenza.containsKey(vertice)) {
            System.out.println("Il vertice " + vertice + " non fa parte del grafo.");
        }
        System.out.println("Vertice: " + vertice);
        System.out.println("Numero archi incidenti: " + numeroArchiIncidenti(vertice));
        System.out.println("Archi incidenti su " + vertice + ": ");
        for (Nodo adiacente : listeAdiacenza.get(vertice)) {
            System.out.println("    (" + vertice + ", " + adiacente + ")");
        }
    }

    public Albero getAlberoBFS(Nodo vertice) {
        controlliEsistenzaVertici(vertice);

        // Inizializzazione della mappa dei vertici visitati.
        Map<Nodo, Boolean> visitati = new HashMap<>();
        for (Nodo nodo : listeAdiacenza.keySet()) {
            visitati.put(nodo, false);
        }
        // la coda per la visita in ampiezza
        Queue<Albero> coda = new LinkedList<>();

        // Creazione dell'albero con la radice vertice.
        Albero albero = new Albero(vertice);
        coda.add(albero);
        visitati.put(vertice, true);

        while (!coda.isEmpty()) {
            Albero alberoCorrente = coda.poll();
            Nodo verticeCorrente = alberoCorrente.radice();
            for (Nodo adiacente : listeAdiacenza.get(verticeCorrente)) {
                if (!visitati.get(adiacente)) {
                    Albero figlio = new Albero(adiacente);
                    alberoCorrente.aggiungiFiglio(figlio);
                    coda.add(figlio);
                    visitati.put(adiacente, true);
                }
            }
        }
        return albero;
    }

    public Albero getAlberoDFS(Nodo vertice) {
        controlliEsistenzaVertici(vertice);

        Map<Nodo, Boolean> visitati = new HashMap<>();
        for (Nodo nodo : listeAdiacenza.keySet()) {
            visitati.put(nodo, false);
        }

        return getAlberoDFS(vertice, visitati);
    }

    // Metodo privato per la visita in profondità.
    private Albero getAlberoDFS(Nodo vertice, Map<Nodo, Boolean> visitati) {
        visitati.put(vertice, true);
        Albero albero = new Albero(vertice);
        for (Nodo adiacente : listeAdiacenza.get(vertice)) {
            if (!visitati.get(adiacente)) {
                Albero figlio = getAlberoDFS(adiacente, visitati);
                albero.aggiungiFiglio(figlio);
            }
        }
        return albero;
    }

    // Metodo privato per controllare l'esistenza dei vertici.
    private void controlliEsistenzaVertici(Nodo... vertici) {
        for (Nodo vertice : vertici) {
            if (!listeAdiacenza.containsKey(vertice)) {
                throw new IllegalArgumentException("Il vertice " + vertice + " non esiste.");
            }
        }
    }
}
