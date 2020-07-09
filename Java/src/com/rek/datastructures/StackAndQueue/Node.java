package com.rek.datastructures.StackAndQueue;

public class Node<K> {

    K data;
    Node<K> next;

    public Node(K k) {
        data = k;
        next = null;
    }

    public Node(K k, Node n) {
        data = k;
        next = n;
    }

}
