package com.github.lorenzoyang.algorithms.datastructures;

/**
 * Classe TreeNode che rappresenta un nodo dell'albero binario (di ricerca)
 * ogni nodo contiene una chiave e due puntatori ai nodi figli
 */
public class TreeNode<Key, Value> {
    public final Key key;
    public Value value;
    public TreeNode<Key, Value> left, right;

    public TreeNode(Key key, Value value, TreeNode<Key, Value> left, TreeNode<Key, Value> right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }
}