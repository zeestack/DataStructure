package com.zahid;

import java.util.HashMap;

public class Trie {

    private class Node {
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
            this.isEndOfWord = false;
        }

        @Override
        public String toString() {
            return "value=" + this.value;
        }

        public boolean hasChild(char ch) {
            return this.children.containsKey(ch);
        }

        public void addChild(char ch) {
            this.children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return this.children.get(ch);
        }

    }

    private Node root;

    public Trie() {
        this.root = new Node(' ');
    }

    public void insert(String word) {
        var current = root;
        for (char ch : word.toCharArray()) {

            if (!current.hasChild(ch))
                current.addChild(ch);

            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

}
