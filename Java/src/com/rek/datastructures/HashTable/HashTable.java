package com.rek.datastructures.HashTable;

import java.util.ArrayList;

public class HashTable<K, V> {

	double loadFactor;
	int capacity;
	int size;
	ArrayList<HashNode<K,V>> arr;

	public HashTable() {
		loadFactor = .7;
		capacity =  10;
		size = 0;
		arr = new ArrayList<HashNode<K,V>>(capacity);
		initArr();
	}

	public HashTable(double lf, int cap) {
		loadFactor = lf;
		capacity =  cap;
		arr = new ArrayList<HashNode<K,V>>(cap);
		initArr();
	}

	private int hashcode(K key) {
		return key.hashCode() % capacity;
	}

	public void add(K key, V value) {
		if (size/capacity > loadFactor) {
			resize();
		}

		int idx = this.hashcode(key);
		HashNode curr = arr.get(idx);
		// first node in array
		if (curr.key == null && curr.value == null) {
			curr.key = key;
			curr.value = value;
			size++;
		} else {
			while (curr != null) {
				// key already exists
				if (curr.key == key) {
					curr.value = value;
					break;
				}
				// reached end of chain
				if (curr.next == null) {
					curr.next = new HashNode(key, value);
					size++;
					break;
				}
				curr = curr.next;
			}
		}
	}

	public V remove(K key, V value) {
		int idx = this.hashcode(key);
		HashNode curr = arr.get(idx);
		if (curr.key == null && curr.value == null) {
			return null;
		}

		// if first node in chain is to be removed
		if (curr.key == key && curr.value==value) {
			arr.remove(curr);
			size--;
			return value;
		}

		// if node is located further into chain
		HashNode prev;
		while (curr.next != null) {
			curr = curr.next;
			prev = curr;
			if (curr.key == key && curr.value == value) {
				size--;
				prev.next = curr.next;
				return value;
			}

		}
		return null;
	}

	public V get(K key) {
		int idx = this.hashcode(key);
		HashNode curr = arr.get(idx);
		while (curr != null) {
			if (curr.key == key) {
				return (V) curr.value;
			}
			curr = curr.next;
		}
		return null;
	}

	public int getCapacity() {
	    return capacity;
    }

    public int getSize() {
	    return size;
    }

    public double getLoadFactor() {
	    return loadFactor;
    }

    private void initArr() {
		for (int i = 0; i < capacity; i++ ) {
			arr.add(new HashNode<K,V>());
		}
	}

	private void resize() {
		ArrayList<HashNode<K,V>> oldArr = arr;
		// create array of double the capacity
		capacity = capacity * 2;
		size = 0;
		arr = new ArrayList<HashNode<K,V>>(capacity);
		initArr();

		// rehash all elements based on higher capacity
		for (HashNode h: oldArr) {
			while (h != null) {
				this.add((K) h.key, (V) h.value);
				h = h.next;
			}
		}
	}

}