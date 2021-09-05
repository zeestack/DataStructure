package com.zahid;

import java.util.Queue;
import java.util.Stack;

public class QueClass {

    public static void reverseQueue(Queue<Integer> que) {
        Stack<Integer> stack = new Stack<>();

        if (que.isEmpty()) throw new IllegalStateException();

        while (!que.isEmpty()) {
            stack.push(que.poll());
        }

        while (!stack.isEmpty()) {
            que.add(stack.pop());
        }
    }

}
