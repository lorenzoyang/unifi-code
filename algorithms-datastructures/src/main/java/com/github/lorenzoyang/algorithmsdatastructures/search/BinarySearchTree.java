package com.github.lorenzoyang.algorithmsdatastructures.search;

/**
 * Albero binario di ricerca
 * per ogni nodo dell’ABR, la chiave in esso memorizzata
 * e' maggiore di tutte le chiavi memorizzate nei nodi del suo sottoalbero sinistro e
 * minore di tutte le chiavi memorizzate nei nodi del suo sottoalbero destro.
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private TreeNode<Key, Value> root; // radice dell'albero

    public BinarySearchTree() {
        this.root = null;
    }

    /**
     * Metodo per la ricerca di una chiave nell'albero
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("key is null");
        return get(root, key);
    }

    /**
     * Metodo ricorsivo per la ricerca di una chiave nell'albero utilizzato dal metodo get(Key key)
     */
    private Value get(TreeNode<Key, Value> node, Key key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

    /**
     * Metodo per l'inserimento di una chiave nell'albero
     * se la chiave è già presente, sovrascrive il valore
     * se il valore è null, elimina la chiave dall'albero
     */
    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("key is null");
        if (value == null) {
            delete(key);
            return;
        }
        root = put(root, key, value);
    }

    /**
     * Metodo ricorsivo per l'inserimento di una chiave nell'albero utilizzato dal metodo put(Key key, Value value)
     */
    private TreeNode<Key, Value> put(TreeNode<Key, Value> node, Key key, Value value) {
        if (node == null) {
            return new TreeNode<>(key, value, null, null);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            // se la chiave è già presente, sovrascrive il valore
            node.value = value;
        }
        return node;
    }

    /**
     * Metodo per la cancellazione di una chiave dall'albero
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("key is null");
        root = delete(root, key);
    }

    /**
     * Metodo ricorsivo per la cancellazione di una chiave dall'albero utilizzato dal metodo delete(Key key)
     */
    private TreeNode<Key, Value> delete(TreeNode<Key, Value> node, Key key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            // se il nodo ha un solo figlio, restituisco il figlio
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            TreeNode<Key, Value> successor = min(node.right); // trovo il successore del nodo da eliminare
            // il sottoalbero destro del nodo da eliminare diventa il sottoalbero destro del successore
            successor.right = deleteMin(node.right); // elimino il successore dal sottoalbero destro
            // il sottoalbero sinistro del nodo da eliminare diventa il sottoalbero sinistro del successore
            successor.left = node.left;
            // faccio puntare la variabile "node" al successore, in modo da poter restituire il successore
            node = successor;
        }
        return node;
    }

    /**
     * Restituisce la chiave più piccola dell'albero
     */
    public Key min() {
        if (isEmpty()) throw new IllegalStateException("tree is empty");
        return min(root).key;
    }

    /**
     * Metodo ricorsivo per la ricerca della chiave più piccola dell'albero utilizzato dal metodo min()
     */
    private TreeNode<Key, Value> min(TreeNode<Key, Value> node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    /**
     * Rimuove la chiave più piccola dell'albero
     */
    public void deleteMin() {
        if (isEmpty()) throw new IllegalStateException("tree is empty");
        root = deleteMin(root);
    }

    /**
     * Metodo ricorsivo per la rimozione della chiave più piccola dell'albero utilizzato dal metodo deleteMin()
     */
    private TreeNode<Key, Value> deleteMin(TreeNode<Key, Value> node) {
        // se il non ha figli, restituisco comunque null (right == null)
        // se il nodo non ha figlio sinistro (left == null), restituisco il figlio destro
        // eliminando così il nodo corrente
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        return node;
    }

    public Key max() {
        if (isEmpty()) throw new IllegalStateException("tree is empty");
        return max(root).key;
    }

    private TreeNode<Key, Value> max(TreeNode<Key, Value> node) {
        if (node.right == null) return node;
        return max(node.right);
    }

    public void deleteMax() {
        if (isEmpty()) throw new IllegalStateException("tree is empty");
        root = deleteMax(root);
    }

    private TreeNode<Key, Value> deleteMax(TreeNode<Key, Value> node) {
        if (node.right == null) return node.left;
        node.right = deleteMax(node.right);
        return node;
    }

    public boolean isEmpty() {
        return root == null;
    }
}

