package com.github.lorenzoyang.algorithms.progettoasd2324;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        Nodo A = new Nodo("A");
        Nodo B = new Nodo("B");
        Nodo C = new Nodo("C");
        Nodo D = new Nodo("D");
        Nodo E = new Nodo("E");
        Nodo F = new Nodo("F");
        Nodo G = new Nodo("G");
        Nodo[] nodi = {A, B, C, D, E, F, G};

        try {
            for (Nodo vertice : nodi) {
                grafo.aggiungiVertice(vertice);
            }
            System.out.println("Creati " + grafo.numeroVertici() + " vertici");

            grafo.aggiungiArco(A, B);
            grafo.aggiungiArco(B, C);
            grafo.aggiungiArco(B, D);
            grafo.aggiungiArco(C, E);
            grafo.aggiungiArco(C, F);
            System.out.println("Creati " + grafo.numeroArchi() + " archi");

            System.out.println("Stato attuale del grafo:");
            System.out.println(grafo);

            System.out.println("----------------------------------------");

            GestoreAlberiVisita gestore = new GestoreAlberiVisita();
            gestore.aggiornaAlbero(grafo.getAlberoBFS(B));
            System.out.println("Albero BFS partendo da B:");
            System.out.println(gestore.figliDelNodo(B));

            gestore.aggiornaAlbero(grafo.getAlberoDFS(B));
            System.out.println("Albero DFS partendo da B:");
            System.out.println(gestore.figliDelNodo(B));

            System.out.println("----------------------------------------");

            grafo.rimuoviVertice(B);
            System.out.println("Rimosso vertice " + B + ": ");
            System.out.println("Vertici rimanenti: " + grafo.numeroVertici());
            System.out.println("Archi rimanenti: " + grafo.numeroArchi());

            grafo.rimuoviArco(C, E);
            System.out.println("Rimosso arco (" + C + ", " + E + "): ");
            System.out.println("Archi rimanenti: " + grafo.numeroArchi());

            System.out.println("Stato finale del grafo:");
            System.out.println(grafo);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
