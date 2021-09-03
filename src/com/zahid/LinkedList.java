package com.zahid;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {

        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public LinkedList() {
        first = last = null;
        size = 0;
    }

    public void addFirst(int value) {
        var node = new Node(value);
        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public void addLast(int value) {
        var node = new Node(value);
        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public int indexOf(int value) {
        var node = first;
        int index = 0;
        while (node != null) {
            if (node.value == value)
                return index;
            node = node.next;
            index++;
        }
        return -1;
    }

    public int getLast() {
        if (last == null) throw new NoSuchElementException();
        return last.value;
    }

    public int getFirst() {
        if (first == null) throw new NoSuchElementException();
        return first.value;
    }

    public void removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        if (first == last)
            first = last = null;
        else {
            var second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty()) throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }
        size--;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int arr[] = new int[size];
        var node = first;
        int index = 0;
        while (node != null) {
            arr[index++] = node.value;
            node = node.next;
        }
        return arr;
    }

    public void reverse() {
        Node current = first;
        Node previous = null;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        first = previous;
    }

    public int getKthFromTheEnd(int k) {

        if (isEmpty()) throw new IllegalStateException();
        if (k < 0 || k > size) throw new IllegalArgumentException();

        var a = first;
        var b = first;
        for (int i = 0; i < k; i++) {
            if (b == null) throw new IllegalArgumentException();
            b = b.next;
        }

        while (b != last) {
            a = a.next;
            b = b.next;
        }

        return a.value;
    }

    private boolean isEmpty() {
        return first == null;
    }

    private Node getPrevious(Node node) {
        var prevNode = first;
        while (prevNode != null) {
            if (prevNode.next == node)
                return prevNode;
            prevNode = prevNode.next;
        }
        return null;
    }


    @Override
    public String toString() {
        return Arrays.toString(this.toArray());
    }

}
