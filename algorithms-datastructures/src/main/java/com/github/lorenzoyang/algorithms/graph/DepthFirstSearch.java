package com.github.lorenzoyang.algorithms.graph;

public class DepthFirstSearch {
    private DepthFirstSearch() {
    }

    public static void depthFristSearch(Graph graph, int source) {
        if (source < 0 || source >= graph.vertices())
            throw new IllegalArgumentException("Il vertice " + source + " non è valido");
        var marked = new boolean[graph.vertices()]; // i vertici visitati
        dfs(graph, source, marked);
    }

    private static void dfs(Graph graph, int v, boolean[] marked) {
        marked[v] = true;
        System.out.print(v + ", ");
        for (int w : graph.adjacencies(v)) {
            if (!marked[w]) {
                dfs(graph, w, marked);
            }
        }
    }

    public static void main(String[] args) {
        var graph = GraphGenerator.generateGraphFromString(GraphGenerator.graphString1);
        System.out.println(graph);
        System.out.println("DFS: ");
        depthFristSearch(graph, 0);
    }
}
