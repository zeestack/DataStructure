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

    public void print() {
        System.out.println(root);
    }

    private AVLNode insert(AVLNode root, int value) {
        if (root == null)
            return new AVLNode(value);

        if (value < root.value)
            root.leftChild = insert(root.leftChild, value);
        else
            root.rightChild = insert(root.rightChild, value);

        root.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;

        //leftheavy ==> right rotation
        if (isLeftHeavy(root)) System.out.println("left heavy at node:" + root.value);

        //rightheavy ==> left rotation
        if (isRightHeavy(root)) System.out.println("Right heavy at node:" + root.value);

        return root;
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node) {
        return node == null ? -1 : height(node.leftChild) - height(node.rightChild);
    }

    private int height(AVLNode node) {
        return node == null ? -1 : node.height;
    }

}
