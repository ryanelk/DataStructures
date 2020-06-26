# hashtable in java

public class HashTable<K, V> {

	double loadFactor;
	int capacity;
	int size;
	Array<HashNode> arr;

	public HashTable() {
		loadFactor = .7;
		capacity =  10;
		size = 0;
		arr = new Array<HashNode>(capacity);
		initArr();
	}

	public HashTable(double lf, int cap) {
		loadFactor = lf;
		capacity =  cap;
		arr = new Array<HashNode>(capacity);
		initArr();
	}

	private int hashcode(K key) {
		return key.hashcode() % capacity;
	}

	public void add(K key, V value) {
		if (size/capacity > loadFactor) {
			resize();
		}

		int idx = this.hashcode(key);
		HashNode curr = arr[idx];
		while (curr != null) {
			// first node in chain
			if (curr.key == null) {
				curr.key = key;
				curr.value = value;
				size++;
				break;
			}
			if (curr.key == key) {
				curr.value = value;
				break;
			}
			if (curr.next == null) {
				curr.next = new HashNode(key, value);
				size++;
				break;
			}
			curr = curr.next;
		}

	}

	public V remove(K key, V value) {
		int idx = this.hashcode(key);
		HashNode curr = arr[idx];
		if (curr == null) {
			return null;
		}

		// if first node in chain is to be removed
		if (curr.key == key && curr.value==value) {
			V value = curr.value
			arr[idx] = curr.next;
			size--;
			return value;
		}

		// if node is located further into chain
		HashNode prev;
		while (curr != null) {
			if (curr.key == key && curr.value == value) {
				V value = curr.value;
				size--;
				prev.next = curr.next;
				return value;
			}
			prev = curr;
			curr = curr.next;
		}
		return null;
	}

	public V get(K key) {
		int idx = this.hashcode(key);
		HashNode curr = arr[idx];
		while (curr != null) {
			if (curr.key == key) {
				return curr.value;
			}
			curr = curr.next;
		}
		return null;
	}

	private void resize() {
		Array<HashNode> oldArr = arr;
		// create array of double the capacity
		capacity = capacity * 2;
		size = 0;
		Array<HashNode> arr = new Array<HashNode>(capacity*2);
		initArr();

		// rehash all elements based on higher capacity
		for (HashNode h: oldArr) {
			while (h != null) {
				add(h.key, h.value);
				h = h.next;
			}
		}

	}

	private void initArr() {
		for (int i = 0; i < capacity; i++) {
			arr[i] = new HashNode<K, V>();
		}
	}


}

public class HashNode<K, V> {
	K key;
	V value;

	HashNode<K,V> next;

	public HashNode(K k, V v) {
		this.key = k;
		this.value = v;
		this.next = null;
	}

}