package com.zahid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

        public Node[] getChildren() {
            return this.children.values().toArray(new Node[0]);
        }

        public boolean hasChildren() {
            return !this.children.isEmpty();
        }

        public void removeChild(char ch) {
            this.children.remove(ch);
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

    public boolean contains(String word) {
        if (word == null)
            return false;

        var current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                return false;
            current = current.getChild(ch);
        }

        return current.isEndOfWord;
    }

    public void remove(String word) {
        if (word == null) return;
        remove(this.root, word, 0);
    }

    private void remove(Node root, String word, int index) {

        if (index == word.length()) {
            root.isEndOfWord = false;
            return;
        }

        var character = word.charAt(index);
        var child = root.getChild(character);

        if (child == null) {
            return;
        }

        remove(child, word, index + 1);

        if (!child.hasChildren() && !child.isEndOfWord)
            root.removeChild(character);

    }

    public List<String> search(String prefix) {

        var words = new ArrayList<String>();

        var lastNode = findLastNode(prefix);

        searchWords(lastNode, prefix, words);

        return words;
    }

    private void searchWords(Node root, String prefix, List<String> words) {

        if (root == null)
            return;

        if (root.isEndOfWord)
            words.add(prefix);

        for (var child : root.getChildren())
            searchWords(child, prefix + child.value, words);
    }

    private Node findLastNode(String prefix) {

        if (prefix == null)
            return null;

        var lastNode = root;
        for (char ch : prefix.toCharArray()) {
            var child = lastNode.getChild(ch);
            if (child == null)
                return null;
            lastNode = child;
        }
        return lastNode;
    }
}
