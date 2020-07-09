package com.rek.datastructures.StackAndQueue;

import java.util.LinkedList;

// FIFO data structure
public class Queue<K> {

    Node<K> head;
    Node<K> last;

    public Queue() {
    }

    public void add(K k) {
        if (head == null) {
            head = new Node(k);
            last = head;
        } else {
            last.next = new Node(k);
            last = last.next;
        }
    }

    public K element() {
        return head.data;
    }

    public boolean offer(K k) {
        last.next = new Node(k);
        last = last.next;
        return true;
    }

    public K peek() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    public K poll() {
        if (head == null) {
            return null;
        }
        K ret = head.data;
        head = head.next;
        return ret;
    }

    public K remove() {
        K ret = head.data;
        head = head.next;
        return ret;
    }
}
