package com.github.lorenzoyang.algorithms.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BinaryTree<T> {
    private Node<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Node<T> getRoot() {
        return root;
    }

    public Node<T> addRoot(T value) {
        if (root != null) {
            throw new IllegalStateException("La radice esiste già");
        }

        root = new Node<>(value);
        return root;
    }

    public Node<T> addLeft(Node<T> parent, T value) {
        validateParent(parent);

        if (parent.left != null) {
            throw new IllegalStateException("Il figlio sinistro esiste già");
        }

        parent.left = new Node<>(value);
        return parent.left;
    }

    public Node<T> addRight(Node<T> parent, T value) {
        validateParent(parent);

        if (parent.right != null) {
            throw new IllegalStateException("Il figlio destro esiste già");
        }

        parent.right = new Node<>(value);
        return parent.right;
    }

    private void validateParent(Node<T> parent) {
        if (parent == null) {
            throw new IllegalArgumentException("Il nodo padre non può essere null");
        }

        if (!containsReference(root, parent)) {
            throw new IllegalArgumentException("Il nodo padre non appartiene a questo albero");
        }
    }

    private boolean containsReference(Node<T> current, Node<T> target) {
        if (current == null) {
            return false;
        }

        if (current == target) {
            return true;
        }

        return containsReference(current.left, target)
                || containsReference(current.right, target);
    }

    public List<T> preorder() {
        List<T> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(Node<T> node, List<T> result) {
        if (node == null) {
            return;
        }

        result.add(node.value);
        preorder(node.left, result);
        preorder(node.right, result);
    }

    public List<T> inorder() {
        List<T> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(Node<T> node, List<T> result) {
        if (node == null) {
            return;
        }

        inorder(node.left, result);
        result.add(node.value);
        inorder(node.right, result);
    }

    public List<T> postorder() {
        List<T> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(Node<T> node, List<T> result) {
        if (node == null) {
            return;
        }

        postorder(node.left, result);
        postorder(node.right, result);
        result.add(node.value);
    }

    public List<Node<T>> findAll(T value) {
        List<Node<T>> result = new ArrayList<>();
        findAll(root, value, result);
        return result;
    }

    private void findAll(Node<T> node, T value, List<Node<T>> result) {
        if (node == null) {
            return;
        }

        if (Objects.equals(node.value, value)) {
            result.add(node);
        }

        findAll(node.left, value, result);
        findAll(node.right, value, result);
    }

    public int size() {
        return size(root);
    }

    private int size(Node<T> node) {
        if (node == null) {
            return 0;
        }

        return 1 + size(node.left) + size(node.right);
    }

    public int height() {
        return height(root);
    }

    private int height(Node<T> node) {
        if (node == null) {
            return -1;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

    static void main() {

        /*
                Albero:
                    1
                   / \
                  1   1
                 / \   \
                2   3   2
        */

        BinaryTree<Integer> tree = new BinaryTree<>();

        Node<Integer> root = tree.addRoot(1);

        Node<Integer> leftOne = tree.addLeft(root, 1);
        Node<Integer> rightOne = tree.addRight(root, 1);

        tree.addLeft(leftOne, 2);
        tree.addRight(leftOne, 3);

        tree.addRight(rightOne, 2);

        System.out.println("Is empty: " + tree.isEmpty());
        System.out.println("Root: " + tree.getRoot());
        System.out.println("Preorder:  " + tree.preorder());
        System.out.println("Inorder:   " + tree.inorder());
        System.out.println("Postorder: " + tree.postorder());

        System.out.println("Size: " + tree.size());
        System.out.println("Height: " + tree.height());

        System.out.println();

        List<Node<Integer>> nodesWithValueOne = tree.findAll(1);
        System.out.println("Nodi con valore 1: " + nodesWithValueOne.size());

        System.out.println();

        System.out.println(tree.getRoot().getValue());
        System.out.println(tree.getRoot().getLeft().getValue());
        System.out.println(tree.getRoot().getRight().getValue());
    }
}
