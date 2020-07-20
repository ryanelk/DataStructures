package com.rek.datastructures.TreesAndGraphs;

public class Node<Integer> {

    int data;
    Node left;
    Node right;

    public Node(int k) {
        data = k;
    }

    public Node(int k, Node l, Node r) {
        data = k;
        left = l;
        right = r;
    }



}
