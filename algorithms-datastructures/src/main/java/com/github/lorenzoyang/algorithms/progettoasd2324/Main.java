package com.github.lorenzoyang.algorithms.progettoasd2324;

public class Main {
    public static void main(String[] args) {
        Grafo grafo1 = new Grafo();
        try {
            grafo1.aggiungiVertice("A");
            grafo1.aggiungiVertice("B");
            grafo1.aggiungiVertice("C");
            grafo1.aggiungiVertice("D");
            grafo1.aggiungiVertice("E");
            grafo1.aggiungiVertice("F");

            grafo1.aggiungiArco("A", "B");
            grafo1.aggiungiArco("B", "C");
            grafo1.aggiungiArco("B", "D");
            grafo1.aggiungiArco("C", "E");
            grafo1.aggiungiArco("C", "F");

            System.out.println("Numero vertici: " + grafo1.numeroVertici());
            System.out.println("Numero archi: " + grafo1.numeroArchi());
            System.out.println("Numero archi incidenti a C: " + grafo1.numeroArchiIncidenti("C"));
            System.out.println("Adiacenti A e B: " + grafo1.adiacenti("A", "B"));
            System.out.println("Adiacenti A e C: " + grafo1.adiacenti("A", "C"));

            System.out.println("Aggiunto il vertice G:");
            grafo1.aggiungiVertice("G");
            System.out.println("Numero vertici: " + grafo1.numeroVertici());

            System.out.println("Aggiunto l'arco A - G:");
            grafo1.aggiungiArco("A", "G");
            System.out.println("Numero archi: " + grafo1.numeroArchi());
            System.out.println("Numero archi incidenti a G: " + grafo1.numeroArchiIncidenti("G"));

            System.out.println("Rimosso l'arco A - G:");
            grafo1.rimuoviArco("A", "G");
            System.out.println("Numero archi: " + grafo1.numeroArchi());
            System.out.println("Numero archi incidenti a G: " + grafo1.numeroArchiIncidenti("G"));

            System.out.println("Rimosso il vertice B:");
            grafo1.rimuoviVertice("B");
            System.out.println("Numero vertici: " + grafo1.numeroVertici());
            System.out.println("Numero archi: " + grafo1.numeroArchi());
            System.out.println("Adiacenti A e C: " + grafo1.adiacenti("A", "C"));
            System.out.println("Adiacenti A e D: " + grafo1.adiacenti("A", "D"));
            grafo1.informazioneVertice("G");

            // visite del grafo
            Grafo grafo2 = new Grafo();
            grafo2.aggiungiVertice("A");
            grafo2.aggiungiVertice("B");
            grafo2.aggiungiVertice("C");
            grafo2.aggiungiVertice("D");
            grafo2.aggiungiVertice("E");
            grafo2.aggiungiVertice("F");
            grafo2.aggiungiVertice("G");

            grafo2.aggiungiArco("A", "B");
            grafo2.aggiungiArco("A", "C");
            grafo2.aggiungiArco("A", "D");
            grafo2.aggiungiArco("B", "E");
            grafo2.aggiungiArco("C", "F");
            grafo2.aggiungiArco("F", "G");
            System.out.println("Visite grafo:");

            GestoreAlberiVisita gestore = new GestoreAlberiVisita();
            System.out.println("DFS: ");
            gestore.salvaAlberoVisita(grafo2.getAlberoBFS("A"));
            System.out.println(gestore.figliDelNodo("A"));
            System.out.println(gestore.figliDelNodo("C"));
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
