package com.zahid;

import java.util.Arrays;

public class Stack {
    private final int[] stack;
    private int count;


    public Stack(int size) {
        this.stack = new int[size];
        this.count = 0;
    }

    public void push(int item) {
        if (isFull()) throw new StackOverflowError();
        stack[count++] = item;
    }


    public int pop() {
        if (isEmpty()) throw new IllegalStateException();
        return stack[--count];
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException();
        return stack[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private boolean isFull() {
        return stack.length == count;
    }

    @Override
    public String toString() {
        var contents = Arrays.copyOf(stack, count);
        return Arrays.toString(contents);
    }
}
