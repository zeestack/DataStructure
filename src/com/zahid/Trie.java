package com.zahid;

public class Trie {

    private class Node {
        private char value;
        private Node[] children = new Node[26];
        private boolean isEndofWord;

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value + "";
        }
    }

    private Node root;

    public Trie() {
        root = new Node(' ');
    }

    public void insert(String word) {
        var current = root;
        for (char ch : word.toCharArray()) {
            var index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new Node(ch);
            }
            current = current.children[index];
        }
        current.isEndofWord = true;
    }


}
