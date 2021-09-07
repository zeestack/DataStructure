package com.zahid;

public class AVLTree {
    private class AVLNode {
        private int value;
        private int height;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Value=" + value;
        }
    }

    private AVLNode root;

    public void insert(int value) {
        this.root = insert(this.root, value);
    }

    public AVLNode insert(AVLNode root, int value) {
        if (root == null)
            return new AVLNode(value);

        if (value < root.value)
            root.leftChild = insert(root.leftChild, value);
        else
            root.rightChild = insert(root.rightChild, value);

        var leftHeight = height(root.leftChild);
        var rightHeight = height(root.rightChild);

        root.height = Math.max(leftHeight, rightHeight) + 1;

        var balanceFactor = leftHeight - rightHeight;
        //balanceFactor > 1 - left heavy
        //balanceFactor < -1 - right heavy
        if (balanceFactor > 1) System.out.println("left heavy at node:" + root.value);
        if (balanceFactor < -1) System.out.println("Right heavy at node:" + root.value);

        return root;
    }

    private int height(AVLNode node) {
        return node == null ? -1 : node.height;
    }

    public void print() {
        System.out.println(root);
    }
}
