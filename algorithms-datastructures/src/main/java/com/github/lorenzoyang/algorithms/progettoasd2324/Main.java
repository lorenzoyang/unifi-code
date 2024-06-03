package com.github.lorenzoyang.algorithms.progettoasd2324;

/**
 * Lorenzo Yang
 * Matricola: 7136074
 */
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
        Nodo H = new Nodo("H");
        Nodo[] nodi = {A, B, C, D, E, F, G, H};

        try {
            for (Nodo vertice : nodi) {
                grafo.aggiungiVertice(vertice);
            }
            System.out.println("Creati " + grafo.numeroVertici() + " vertici");

            grafo.aggiungiArco(A, B);
            grafo.aggiungiArco(B, C);
            grafo.aggiungiArco(C, D);
            grafo.aggiungiArco(D, E);
            grafo.aggiungiArco(E, F);
            grafo.aggiungiArco(F, D);
            grafo.aggiungiArco(E, A);
            grafo.aggiungiArco(A, H);
            grafo.aggiungiArco(H, G);
            System.out.println("Creati " + grafo.numeroArchi() + " archi");

            System.out.println("Stato attuale del grafo:");
            System.out.println(grafo);

            System.out.println("----------------------------------------");

            GestoreAlberiVisita gestore = new GestoreAlberiVisita();

            gestore.aggiornaAlbero(grafo.getAlberoBFS(A));
            System.out.println("Albero BFS partendo da A:");
            System.out.println(gestore.figliDelNodo(A));

            gestore.aggiornaAlbero(grafo.getAlberoDFS(A));
            System.out.println("Albero DFS partendo da A:");
            System.out.println(gestore.figliDelNodo(A));

            System.out.println("----------------------------------------");

            grafo.rimuoviVertice(B);
            System.out.println("Rimosso vertice " + B + ":");
            System.out.println("Vertici rimanenti: " + grafo.numeroVertici());
            System.out.println("Archi rimanenti: " + grafo.numeroArchi());

            grafo.rimuoviArco(A, E);
            System.out.println("Rimosso arco (" + A + ", " + E + "):");
            System.out.println("Archi rimanenti: " + grafo.numeroArchi());

            System.out.println("Stato finale del grafo:");
            System.out.println(grafo);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
