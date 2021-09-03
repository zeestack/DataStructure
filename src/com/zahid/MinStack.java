package com.zahid;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack = new Stack<>();

    private Stack<Integer> minStack = new Stack<>();
    private Stack<Integer> maxStack = new Stack<>();

    public void push(int item) {
        stack.push(item);
        pushMin(item);
        pushMax(item);
    }

    public int pop() {

        if (stack.isEmpty())
            throw new IllegalStateException();

        popMin();
        popMax();

        return stack.pop();
    }

    public int min() {
        if (minStack.isEmpty())
            throw new IllegalStateException();
        return minStack.peek();
    }

    public int max() {
        if (maxStack.isEmpty())
            throw new IllegalStateException();

        return maxStack.peek();
    }

    private void pushMin(int item) {
        if (!minStack.isEmpty()) {
            var top = minStack.peek();
            if (item <= top)
                minStack.push(item);
        } else minStack.push(item);
    }

    private void pushMax(int item) {
        if (!maxStack.isEmpty()) {
            var top = maxStack.peek();
            if (item >= top)
                maxStack.push(item);
        } else maxStack.push(item);
    }

    private void popMin() {
        if (stack.isEmpty()) return;
        var top = stack.peek();

        if (!minStack.isEmpty()) {
            var min = minStack.peek();
            if (top.equals(min)) {
                minStack.pop();
            }
        }
    }

    private void popMax() {
        if (stack.isEmpty()) return;
        var top = stack.peek();

        if (!maxStack.isEmpty()) {
            var max = maxStack.peek();

            if (top.equals(max)) {
                maxStack.pop();
            }
        }

    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
