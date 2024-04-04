package com.github.lorenzoyang.algorithms.unionfind;

public class QuickUnion {
    private final int[] parent; // parent[i] e' il padre di i
    private int count; // numero di componenti

    public QuickUnion(int num) {
        count = num;
        parent = new int[num];
        for (int i = 0; i < num; i++) {
            parent[i] = i;
        }
    }

    public int find(int v) {
        validate(v);
        while (v != parent[v]) { // finche' v non e' la radice
            v = parent[v];
        }
        return v; // restituisce la radice
    }

    public boolean connected(int v, int w) {
        return find(v) == find(w); // v e w sono nello stesso componente se hanno la stessa radice
    }

    public void union(int v, int w) {
        int vRoot = find(v);
        int wRoot = find(w);

        if (vRoot == wRoot) { // gia' nello stesso componente
            return;
        }

        // unisco i due alberi
        parent[vRoot] = wRoot;
        count--; // ho unito due componenti
    }

    public int count() {
        return count;
    }

    private void validate(int v) {
        if (v < 0 || v >= parent.length) {
            throw new IllegalArgumentException("Index " + v + " is not between 0 and " + (parent.length - 1));
        }
    }
}
