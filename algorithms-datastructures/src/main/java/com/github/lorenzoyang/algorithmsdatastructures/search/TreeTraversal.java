package com.github.lorenzoyang.algorithmsdatastructures.search;


/**
 * Attraversamento di un albero binario
 */
public class TreeTraversal {
    /**
     * Attraversamento anticipato: consiste nel visitare la radice
     * e poi nell'attraversare in ordine anticipato tutti i suoi sottoalberi (da sinistra a destra)
     */
    public static <Key, Value> void preorderTraversal(TreeNode<Key, Value> root) {
        if (root == null) return;
        System.out.println("key: " + root.key + ", value: " + root.value);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    /**
     * Attraversamento posticipato: in cui si attraversano in ordine posticipato
     * tutti i sottoalberi (da sinistra a destra) prima di visitare la radice.
     */
    public static <Key, Value> void postorderTraversal(TreeNode<Key, Value> root) {
        if (root == null) return;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.println("key: " + root.key + ", value: " + root.value);
    }

    /**
     * Attraversamento simmetrico: consiste nell'attraversare in ordine simmetrico il sottoalbero sinistro,
     * poi di visitare la radice e quindi di attraversare in ordine simmetrico il sottoalbero destro.
     */
    public static <Key, Value> void inorderTraversal(TreeNode<Key, Value> root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.println("key: " + root.key + ", value: " + root.value);
        inorderTraversal(root.right);
    }

    // test
    public static void main(String[] args) {
        /*
          Albero binario
                  1
                /  \
               2    3
              / \   / \
             4  5  6   7
         */

        var root = new TreeNode<>(1, "one", null, null);
        root.left = new TreeNode<>(2, "two", null, null);
        root.right = new TreeNode<>(3, "three", null, null);

        var two = root.left;
        two.left = new TreeNode<>(4, "four", null, null);
        two.right = new TreeNode<>(5, "five", null, null);

        var three = root.right;
        three.left = new TreeNode<>(6, "six", null, null);
        three.right = new TreeNode<>(7, "seven", null, null);

        System.out.println("preorderTraversal:");
        preorderTraversal(root);
        System.out.println("postorderTraversal:");
        postorderTraversal(root);
        System.out.println("inorderTraversal:");
        inorderTraversal(root);
    }
}
