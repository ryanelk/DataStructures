package com.rek.datastructures.TreesAndGraphs;

public class BinarySearchTree {

    Node root;

    BinarySearchTree(Node n) {
        root = n;
    }

    BinarySearchTree(int[] arr) {
        for (int i: arr) {
            insert(i);
        }
    }

    public boolean insert(int num) {
        return true;
    }

    public boolean contains(int num) {
        return true;
    }

    public String preOrderTraversal(Node n, String s) {
        if (n == null) {
            return s;
        }
        s += n.data + " ";
        s += preOrderTraversal(n.left, s);
        s += preOrderTraversal(n.right, s);
        return s;
    }

    public String inOrderTraversal(Node n, String s) {
        if (n == null) {
            return s;
        }
        s += inOrderTraversal(n.left, s);
        s += n.data + " ";
        s += inOrderTraversal(n.right, s);
        return s;
    }

    public String postOrderTraversal(Node n, String s) {
        if (n == null) {
            return s;
        }
        s += postOrderTraversal(n.left, s);
        s += postOrderTraversal(n.right, s);
        s += n.data + " ";
        return s;
    }



}
