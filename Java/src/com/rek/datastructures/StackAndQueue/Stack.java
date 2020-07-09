package com.rek.datastructures.StackAndQueue;

import java.util.LinkedList;

// LIFO data structure
public class Stack<K> {

    Node<K> head;

    public Stack() {
    }

    public void push(K k) {
        if (head == null) {
            head = new Node(k);
        } else {
            head = new Node(k, head);
        }
    }

    public boolean empty() {
        return head == null;
    }

    public K peek() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    public K pop() {
        if (head == null) {
            return null;
        }
        K ret = head.data;
        head = head.next;
        return ret;
    }

    public int search(K k) {
        int count = 0;
        while (head != null) {
            if (head.data == k) {
                return count;
            }
            count++;
        }
        return count;
    }
}
