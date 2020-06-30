package com.rek.datastructures.HashTable;

public class HashNode<K, V> {
	K key;
	V value;

	HashNode<K,V> next;

	public HashNode(K k, V v) {
		this.key = k;
		this.value = v;
		this.next = null;
	}

	public HashNode() {
		this.key = null;
		this.value = null;
		this.next = null;
	}

}