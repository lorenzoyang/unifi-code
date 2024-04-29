package com.github.lorenzoyang.algorithms.progettoasd2324;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        try {
            grafo.aggiungiVertice("A");
            grafo.aggiungiVertice("B");
            grafo.aggiungiVertice("C");
            grafo.aggiungiVertice("D");
            grafo.aggiungiVertice("E");
            grafo.aggiungiVertice("F");

            grafo.aggiungiArco("A", "B");
            grafo.aggiungiArco("B", "C");
            grafo.aggiungiArco("B", "D");
            grafo.aggiungiArco("C", "E");
            grafo.aggiungiArco("C", "F");

            System.out.println("Numero vertici: " + grafo.numeroVertici());
            System.out.println("Numero archi: " + grafo.numeroArchi());
            System.out.println("Numero archi incidenti a C: " + grafo.numeroArchiIncidenti("C"));
            System.out.println("Adiacenti A e B: " + grafo.adiacenti("A", "B"));
            System.out.println("Adiacenti A e C: " + grafo.adiacenti("A", "C"));

            System.out.println("Aggiunto il vertice G:");
            grafo.aggiungiVertice("G");
            System.out.println("Numero vertici: " + grafo.numeroVertici());

            System.out.println("Aggiunto l'arco A - G:");
            grafo.aggiungiArco("A", "G");
            System.out.println("Numero archi: " + grafo.numeroArchi());
            System.out.println("Numero archi incidenti a G: " + grafo.numeroArchiIncidenti("G"));

            System.out.println("Rimosso l'arco A - G:");
            grafo.rimuoviArco("A", "G");
            System.out.println("Numero archi: " + grafo.numeroArchi());
            System.out.println("Numero archi incidenti a G: " + grafo.numeroArchiIncidenti("G"));

            System.out.println("Rimosso il vertice B:");
            grafo.rimuoviVertice("B");
            System.out.println("Numero vertici: " + grafo.numeroVertici());
            System.out.println("Numero archi: " + grafo.numeroArchi());
            System.out.println("Adiacenti A e C: " + grafo.adiacenti("A", "C"));
            System.out.println("Adiacenti A e D: " + grafo.adiacenti("A", "D"));

            grafo.informazioneVertice("G");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
