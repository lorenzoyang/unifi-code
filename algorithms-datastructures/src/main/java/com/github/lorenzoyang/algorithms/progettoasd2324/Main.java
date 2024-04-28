package com.github.lorenzoyang.algorithms.progettoasd2324;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.aggiungiVertice("A");
        grafo.aggiungiVertice("B");
        grafo.aggiungiVertice("C");
        grafo.aggiungiVertice("D");

        grafo.aggiungiArco("A", "B");
        grafo.aggiungiArco("A", "C");
        grafo.aggiungiArco("B", "C");
        grafo.aggiungiArco("B", "D");

        grafo.informazioneVertice("A");
    }
}
