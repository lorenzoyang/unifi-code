package com.github.lorenzoyang.algorithms.unionfind;

public class QuickFind {
    private final int[] id; // id[i] e' il componente a cui appartiene i
    private int count; // numero di componenti

    public QuickFind(int num) {
        count = num;
        id = new int[num];
        for (int i = 0; i < num; i++) {
            id[i] = i;
        }
    }

    // trova il componente a cui appartiene v
    public int find(int v) {
        validate(v);
        return id[v];
    }

    // restituisce true se v e w sono nello stesso componente
    public boolean connected(int v, int w) {
        validate(v);
        validate(w);
        return id[v] == id[w];
    }

    public void union(int v, int w) {
        validate(v);
        validate(w);
        int vId = id[v];
        int wId = id[w];

        if (vId == wId) { // gia' nello stesso componente
            return;
        }

        // i componenti di v e w sono diversi, quindi devo unirli
        // tutti i vertici del componente di v passano a far parte del componente di w
        for (int i = 0; i < id.length; i++) {
            if (id[i] == vId) {
                id[i] = wId;
            }
        }
        count--; // ho unito due componenti
    }

    public int count() {
        return count;
    }

    private void validate(int v) {
        if (v < 0 || v >= id.length) {
            throw new IllegalArgumentException("Index " + v + " is not between 0 and " + (id.length - 1));
        }
    }
}
