package com.rek.datastructures.ArrayList;

public class ArrayList {
    Object[] arr;
    private int size;
    private int capacity;

    public ArrayList() {
        capacity = 10;
        arr = new Object[capacity];
    }

    public ArrayList(int cap) {
        capacity = cap;
        arr = new Object[cap];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Object o) {
        if (capacity <= size) {
            resize();
        }
        arr[size++] = o;
    }
    public void add(int idx, Object o) {
        if (idx >= size || idx < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (capacity <= size) {
            resize();
        }
        if (arr[idx] != null) {
            // shift array to right
            int temp = size;
            while (idx < temp) {
                arr[temp] = arr[temp-1];
                temp--;
            }
        }
        arr[idx] = o;
        size++;
    }

    public Object remove(int idx) {
        if (idx >= size || idx < 0) {
            throw new IndexOutOfBoundsException();
        }
        // shift array to left
        Object o = arr[idx];
        int temp = idx;
        while (temp < size) {
            arr[temp++] = arr[temp + 1];
        }
        arr[--size] = null;

        return o;
    }

    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == o) {
                remove(i);
                return true;
            }
        }
        // not found
        return false;
    }

    public Object get(int idx) {
        if (idx >= size || idx < 0) {
            throw new IndexOutOfBoundsException();
        }
        return arr[idx];

    }

    public void set(int idx, Object o) {
        if (idx >= size || idx < 0) {
            throw new IndexOutOfBoundsException();
        }
        arr[idx] = o;
    }

    private void resize() {
        Object[] bigArr = new Object[capacity*2];
        for (int i = 0; i < size; i++) {
            bigArr[i] = arr[i];
        }
        arr = bigArr;
    }

}
