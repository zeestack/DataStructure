package com.zahid;

public class Array {
    private int[] items;
    private int count;

    //O(1)
    public Array(int length) {
        items = new int[length];
        count = 0;
    }

    //O(n)
    public void insert(int item) {
        if (items.length == count) {
            int[] newItems = new int[count * 2];
            System.arraycopy(items, 0, newItems, 0, count);
            items = newItems;
        }
        items[count++] = item;
    }

    //O(n)
    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException();
        System.arraycopy(items, index + 1, items, index, count - index);
        count--;
    }

    //O(n)
    public int indexOf(int item) {
        for (int i = 0; i < count; i++)
            if (items[i] == item)
                return i;
        return -1;
    }

    //O(n)
    public int max() {
        if (count <= 0) throw new ArrayStoreException();
        int mx = items[0];
        for (int i = 1; i < count; i++)
            if (items[i] > mx)
                mx = items[i];
        return mx;
    }

    //O(n^2)
    public Array intersect(int[] arr) {
        if (count <= 0 || arr.length <= 0) throw new ArrayStoreException();
        int commonLength = count <= arr.length ? count : arr.length;
        Array common = new Array(commonLength);
        int k = 0;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (items[i] == arr[j])
                    if (common.indexOf(items[i]) == -1)
                        common.insert(items[i]);
            }
        }
        return common;
    }

    //O(n)
    public Array reverse() {
        Array rev = new Array(count);

        for (int i = count - 1; i >= 0; i--) {
            rev.insert(items[i]);
        }
        return rev;
    }

    //O(n)
    public void insertAt(int item, int index) {
        if (index < 0 || index > count) throw new IndexOutOfBoundsException();

        //add item at the end to extend array by one item
        insert(item);

        for (int i = count - 1; i > index; i--) {
            items[i] = items[i - 1];
        }
        items[index] = item;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    public int size() {
        return count;
    }
}
