package com.zahid;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        chracterFinderDemo();
    }

<<<<<<< HEAD
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println(queue);

        queue.dequeue();
        queue.enqueue(60);
        queue.dequeue();
        System.out.println(queue);
=======
    public static void chracterFinderDemo() {
        ChracterFinder n = new ChracterFinder();
        System.out.println("First non-repeated character: " + n.findFirstNonRepeatedChar("a green apple"));
        System.out.println("First repeated character: " + n.findFirstRepeatedChar("a green apple"));
    }

    public static void queueDemo() {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(1);
        que.add(2);
        que.add(3);
        QueClass.reverseQueue(que);
        System.out.println(que);
>>>>>>> b8cfee1ebdf4558366c5d0dca329b6bde8586e64
    }

    public static void minStackDemo() {
        var stack = new MinStack();
        stack.push(5);
        stack.push(100);

        stack.push(200);
        stack.push(1000);
        stack.push(2000);
        stack.push(3000);
        stack.push(4000);
        stack.push(3000);
        stack.push(3000);
        System.out.println(stack);
        System.out.println("Minimum: " + stack.min() + ", Maximum:" + stack.max());

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println(stack);
        System.out.println("Minimum: " + stack.min() + ", Maximum:" + stack.max());


    }

    public static void balanceBracketDemo() {
        var check = new Expression();
        String exp = ">{([1+2])}>";
        System.out.println(check.isBalanced(exp));
    }

    public static void stackDemo() {
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.isEmpty());
        System.out.println("Peek:" + stack.peek() + "Pop:" + stack.pop());
        System.out.println(stack);
    }

    public static void linkedListDemo() {
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(100);


        System.out.println(list);
        System.out.println("Size : " + list.size());

        System.out.println("Last Item:" + list.getLast());
        System.out.println("First Item:" + list.getFirst());

        int find = 20;
        System.out.println("contains " + find + ":" + list.contains(find) + " at Index: " + list.indexOf(find));


        System.out.println(list.getKthFromTheEnd(0));

    }

    public static void dynamicArrays() {
        //ArrayList grows 50% when it is full
        //VectorClass grows 100% and is synchronized;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.indexOf(20);
        list.size();
        list.toArray();
        System.out.println(list);
    }

    public static void ArrayExcercise() {
        Array numbers = new Array(3);
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);


        int findItem = 40;
        System.out.println("indexOf " + findItem + ":" + numbers.indexOf(findItem));

        System.out.println(numbers.max());

        Array common = numbers.intersect(new int[]{30, 40});

        System.out.println("Printing common items: ");
        common.print();


        System.out.println("Reversing Array: ");
        numbers.reverse().print();

        numbers.insertAt(100, 2);

        System.out.println("Insert At function call with new length: " + numbers.size());
        numbers.print();


    }

}
