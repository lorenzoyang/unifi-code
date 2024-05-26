package com.github.lorenzoyang.algorithms.progettoasd2324;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Grafo non orientato rappresentato con le liste di adiacenza.
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

    public String informazioneVertice(Nodo vertice) {
        if (!listeAdiacenza.containsKey(vertice)) {
            System.out.println("Il vertice " + vertice + " non fa parte del grafo.");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Vertice ").append(vertice).append(":\n");
        sb.append("    Numero archi incidenti: ").append(numeroArchiIncidenti(vertice)).append("\n");
        sb.append("    Archi incidenti su ").append(vertice).append(":").append("\n");
        for (Nodo adiacente : listeAdiacenza.get(vertice)) {
            sb.append("        (").append(vertice).append(", ").append(adiacente).append(")\n");
        }
        return sb.toString();
    }

    public NodoLF getAlberoBFS(Nodo vertice) {
        controlliEsistenzaVertici(vertice);

        // Inizializzazione della mappa dei vertici visitati.
        Map<Nodo, Boolean> visitati = new HashMap<>();
        for (Nodo nodo : listeAdiacenza.keySet()) {
            visitati.put(nodo, false);
        }
        // la coda per la visita in ampiezza
        Queue<NodoLF> coda = new LinkedList<>();

        // Creazione dell'albero con la radice vertice.
        NodoLF albero = new NodoLF(vertice);
        coda.add(albero);
        visitati.put(vertice, true);

        while (!coda.isEmpty()) {
            NodoLF alberoCorrente = coda.poll();
            Nodo verticeCorrente = alberoCorrente.radice();
            for (Nodo adiacente : listeAdiacenza.get(verticeCorrente)) {
                if (!visitati.get(adiacente)) {
                    NodoLF figlio = new NodoLF(adiacente);
                    alberoCorrente.aggiungiFiglio(figlio);
                    coda.add(figlio);
                    visitati.put(adiacente, true);
                }
            }
        }
        return albero;
    }

    public NodoLF getAlberoDFS(Nodo vertice) {
        controlliEsistenzaVertici(vertice);

        Map<Nodo, Boolean> visitati = new HashMap<>();
        for (Nodo nodo : listeAdiacenza.keySet()) {
            visitati.put(nodo, false);
        }

        return getAlberoDFS(vertice, visitati);
    }

    // Metodo privato per la visita in profondità.
    private NodoLF getAlberoDFS(Nodo vertice, Map<Nodo, Boolean> visitati) {
        visitati.put(vertice, true);
        NodoLF albero = new NodoLF(vertice);
        for (Nodo adiacente : listeAdiacenza.get(vertice)) {
            if (!visitati.get(adiacente)) {
                NodoLF figlio = getAlberoDFS(adiacente, visitati);
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Grafo con ").append(numeroVertici()).append(" vertici e ")
                .append(numeroArchi()).append(" archi >>>>>>\n");
        for (Nodo vertice : listeAdiacenza.keySet()) {
            sb.append(informazioneVertice(vertice));
        }
        sb.append("<<<<<<");
        return sb.toString();
    }
}
