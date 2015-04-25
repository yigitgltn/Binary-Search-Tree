package binary.search.tree;

import java.util.Random;
import java.util.Scanner;

/**
 * Represents the Binary Search Tree.
 */
public class BinarySearchTree {

    /**
     * Represents a node in the Binary Search Tree.
     */
    public class Node<T> {

        //The value present in the node.
        public int value;

        //The reference to the left subtree.
        public Node left;

        //The reference to the right subtree.
        public Node right;

        public Node(int value) {
            this.value = value;
        }

    }
    //Refrence for the root of the tree.
    public Node root;

    public BinarySearchTree insert(int value) {
        Node node = new Node<>(value);

        if (root == null) {
            root = node;
            return this;
        }

        insertRec(root, node);
        return this;
    }

    private void insertRec(Node latestRoot, Node node) {

        if (latestRoot.value > node.value) {

            if (latestRoot.left == null) {
                latestRoot.left = node;
                return;
            } else {
                insertRec(latestRoot.left, node);
            }
        } else {
            if (latestRoot.right == null) {
                latestRoot.right = node;
                return;
            } else {
                insertRec(latestRoot.right, node);
            }
        }
    }

    /**
     * Returns the minimum value in the Binary Search Tree.
     */
    public int findMinimum() {
        if (root == null) {
            return 0;
        }
        Node currNode = root;
        while (currNode.left != null) {
            currNode = currNode.left;
        }
        return currNode.value;
    }

    /**
     * Returns the maximum value in the Binary Search Tree
     */
    public int findMaximum() {
        if (root == null) {
            return 0;
        }

        Node currNode = root;
        while (currNode.right != null) {
            currNode = currNode.right;
        }
        return currNode.value;
    }

    /**
     * Printing the contents of the tree in an inorder way.
     */
    public void printInorder() {
        printInOrderRec(root);
        System.out.println("");
    }

    /**
     * Helper method to recursively print the contents in an inorder way
     */
    private void printInOrderRec(Node currRoot) {
        if (currRoot == null) {
            return;
        }
        printInOrderRec(currRoot.left);
        System.out.print(currRoot.value + ", ");
        printInOrderRec(currRoot.right);
    }

    /**
     * Printing the contents of the tree in a Preorder way.
     */
    public void printPreorder() {
        printPreOrderRec(root);
        System.out.println("");
    }

    /**
     * Helper method to recursively print the contents in a Preorder way
     */
    private void printPreOrderRec(Node currRoot) {
        if (currRoot == null) {
            return;
        }
        System.out.print(currRoot.value + ", ");
        printPreOrderRec(currRoot.left);
        printPreOrderRec(currRoot.right);
    }

    /**
     * Printing the contents of the tree in a Postorder way.
     */
    public void printPostorder() {
        printPostOrderRec(root);
        System.out.println("");
    }

    /**
     * Helper method to recursively print the contents in a Postorder way
     */
    private void printPostOrderRec(Node currRoot) {
        if (currRoot == null) {
            return;
        }
        printPostOrderRec(currRoot.left);
        printPostOrderRec(currRoot.right);
        System.out.print(currRoot.value + ", ");

    }

    int countLeaves(Node node) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return 1;
        } else {
            return 1 + countLeaves(node.left) + countLeaves(node.right);
        }

    }
    int arama = 0;

    public int sayarakArama(int val) {
        Node focusNode = root;
        while (focusNode.value != val) {
            if (val < focusNode.value) {
                arama = arama + 1;
                focusNode = focusNode.left;

            } else {
                arama = arama + 1;
                focusNode = focusNode.right;

            }
            if (focusNode == null) {

                return arama;

            }
        }
        return arama;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(40)
                .insert(25)
                .insert(78)
                .insert(10)
                .insert(3)
                .insert(17)
                .insert(32)
                .insert(30)
                .insert(38)
                .insert(78)
                .insert(50)
                .insert(93);
        System.out.println("Inorder traversal");
        bst.printInorder();

        System.out.println("Preorder Traversal");
        bst.printPreorder();

        System.out.println("Postorder Traversal");
        bst.printPostorder();

        System.out.println("The minimum value in the BST: " + bst.findMinimum());
        System.out.println("The maximum value in the BST: " + bst.findMaximum());

        //******************Random***********
        Random rnd = new Random();

        BinarySearchTree bst1 = new BinarySearchTree();

        Scanner scan = new Scanner(System.in);
        System.out.println("Kaç Node lu ağaç oluşturacaksınız?");
        int node_sayisi = scan.nextInt();
        System.out.println("Kaç tane arama yapmak istersiniz?");
        int arama_sayisi = scan.nextInt();
        while (bst1.countLeaves(bst1.root) != node_sayisi) {
            bst1.insert(rnd.nextInt(2147483647));
        }
        int gezilen = 0;
        for (int i = 0; i < arama_sayisi; i++) {
            gezilen = gezilen + bst1.sayarakArama(rnd.nextInt(2147483647));
        }
        System.out.println("Gezinti Ortalaması:");
        System.out.println(gezilen / arama_sayisi);

    }
}
