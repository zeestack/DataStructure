package com.zahid;

<<<<<<< HEAD
import java.util.HashMap;

=======
>>>>>>> 0764a77dc3118c7ed74a9e7a1f05d96d3bf0109f
public class Trie {

    private class Node {
        private char value;
<<<<<<< HEAD
        //private Node[] children = new Node[26];

        private HashMap<Character, Node> children = new HashMap<>();

        private boolean isEndOfWord;
=======
        private Node[] children = new Node[26];
        private boolean isEndofWord;
>>>>>>> 0764a77dc3118c7ed74a9e7a1f05d96d3bf0109f

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
<<<<<<< HEAD
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

=======
            return value + "";
        }
>>>>>>> 0764a77dc3118c7ed74a9e7a1f05d96d3bf0109f
    }

    private Node root;

    public Trie() {
<<<<<<< HEAD
        this.root = new Node(' ');
=======
        root = new Node(' ');
>>>>>>> 0764a77dc3118c7ed74a9e7a1f05d96d3bf0109f
    }

    public void insert(String word) {
        var current = root;
        for (char ch : word.toCharArray()) {
<<<<<<< HEAD

            if (!current.hasChild(ch))
                current.addChild(ch);

            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
=======
            var index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new Node(ch);
            }
            current = current.children[index];
        }
        current.isEndofWord = true;
>>>>>>> 0764a77dc3118c7ed74a9e7a1f05d96d3bf0109f
    }


}
<<<<<<< HEAD

=======
>>>>>>> 0764a77dc3118c7ed74a9e7a1f05d96d3bf0109f
