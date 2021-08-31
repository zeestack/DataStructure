package com.zahid;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        dynamicArrays();
        ArrayExcercise();
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
