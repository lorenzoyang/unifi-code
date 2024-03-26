package com.github.lorenzoyang.algorithms.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    private BreadthFirstSearch() {
    }

    public static void breadthFirstSearch(Graph graph, int source) {
        if (source < 0 || source >= graph.vertices())
            throw new IllegalArgumentException("Il vertice " + source + " non è valido");

        boolean[] visited = new boolean[graph.vertices()]; // i vertici visitati
        Queue<Integer> queue = new LinkedList<>(); // la coda dei vertici da visitare

        visited[source] = true;
        queue.add(source);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + ", ");
            // per ogni vertice adiacente a v
            for (int w : graph.adjacencies(v)) {
                if (!visited[w]) {
                    visited[w] = true;
                    queue.add(w);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        var graph = GraphGenerator.generateGraphFromString(GraphGenerator.graphString1);
        System.out.println(graph);
        System.out.println("BFS: ");
        breadthFirstSearch(graph, 0);
    }
}
