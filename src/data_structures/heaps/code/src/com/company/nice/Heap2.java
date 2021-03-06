package com.company.nice;

import java.util.ArrayList;
import java.util.HashMap;

public class Heap2<T extends Comparable<T>> {

    // to maintain index of elements in heap so that we can get index of an element in O(1) and upheap it when we change
    // the data in heap in AdjacencyMapGraph.java
    HashMap<T, Integer> map = new HashMap<>();
    private ArrayList<T> list;

    public Heap2() {
        list = new ArrayList<>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void add(T value) {
        list.add(value);
        map.put(value, this.list.size() - 1);
        upheap(list.size() - 1);
    }

    private void upheap(int index) {

        if (index == 0) {
            return;
        }

        int p = parent(index);

        if (list.get(index).compareTo(list.get(p)) < 0) {
            swap(index, p);
            upheap(p);
        }
    }

    public T remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Removing from empty Heap");
        }
        T temp = list.get(0);

        T last = list.remove(list.size() - 1);

        if (!list.isEmpty()) {
            list.set(0, last);

            downheap(0);
        }
        map.remove(temp);
        return temp;
    }

    private void downheap(int index) {

        int min = index;
        int left = left(index);
        int right = right(index);

        // check is left < min
        if (left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
            min = left;
        }
        // check if right < min
        if (right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
            min = right;
        }

        if (min != index) {
            swap(min, index);

            downheap(min);
        }
    }

    private void swap(int first, int second) {
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);

        map.put(list.get(first), second);
        map.put(list.get(second), first);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return index * 2 + 1;
    }

    private int right(int index) {
        return index * 2 + 2;
    }

    public ArrayList<T> heapSort() throws Exception {

        ArrayList<T> data = new ArrayList<>();

        while (!list.isEmpty()) {
            data.add(this.remove());
        }
        return data;
    }

    public void updatePriority(T pair) {
        int index = map.get(pair);
        upheap(index);
    }

    public int size() {
        return list.size();
    }
}