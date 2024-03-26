package com.github.lorenzoyang.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int VERTICES; // il numero di vertici
    private int edges; // il numero di archi

    private final List<Integer>[] adjacencies; // la lista di adiacenza

    public Graph(int vertices) {
        if (vertices < 0) throw new IllegalArgumentException("Il numero di vertici deve essere positivo");
        this.VERTICES = vertices;
        this.edges = 0;
        //noinspection unchecked
        this.adjacencies = (List<Integer>[]) new List[vertices];
        for (int v = 0; v < vertices; v++) {
            this.adjacencies[v] = new ArrayList<>();
        }
    }

    // restituisce il numero di vertici
    public int vertices() {
        return this.VERTICES;
    }

    // restituisce il numero di archi
    public int edges() {
        return this.edges;
    }

    // aggiunge un arco tra i vertici v e w
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        edges++;
        adjacencies[v].add(w);
        adjacencies[w].add(v);
    }

    // restituisce i vertici adiacenti a v
    public Iterable<Integer> adjacencies(int v) {
        validateVertex(v);
        return adjacencies[v];
    }

    // restituisce il grado del vertice v
    public int degree(int v) {
        validateVertex(v);
        return adjacencies[v].size();
    }

    // controlla se il vertice è valido
    private void validateVertex(int v) {
        if (v < 0 || v >= vertices())
            throw new IllegalArgumentException("Il vertice " + v + " non è valido");
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(vertices()).append(" vertices, ").append(edges()).append(" edges ").append(System.lineSeparator());
        for (int v = 0; v < vertices(); v++) {
            s.append(v).append(": ");
            for (int w : adjacencies[v]) {
                s.append(w).append(", ");
            }
            s.append(System.lineSeparator());
        }
        return s.toString();
    }

    public static void main(String[] args) {
        var graph = GraphGenerator.generateGraphFromString(GraphGenerator.graphString1);
        System.out.println(graph);
    }
}
