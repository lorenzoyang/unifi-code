package com.github.lorenzoyang.algorithms.graph;

public class GraphGenerator {
    private GraphGenerator() {
    }


    // genera un grafo da un file.txt con il seguente formato:
    // la prima riga contiene il numero di vertici
    // v = vertice, w = un vertice adiacente a v
    // formato:
    // v0-w0
    // v1-w1
    // ...
    public static final String graphString1 = """
            5
            0-1
            0-2
            1-3
            1-4
            2-4
            """;

    public static Graph generateGraphFromString(String graphString) {
        var lines = graphString.split("\n");

        var vertices = Integer.parseInt(lines[0].trim());
        var graph = new Graph(vertices);

        for (int i = 1; i < lines.length; i++) {
            var parts = lines[i].split("-");
            var v = Integer.parseInt(parts[0].trim());
            var w = Integer.parseInt(parts[1].trim());
            graph.addEdge(v, w);
        }
        return graph;
    }
}
