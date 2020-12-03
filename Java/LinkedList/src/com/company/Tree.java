package com.company;

class Tree {
    public static void main(String[] args) {
        Node tree = new Node();
        System.out.println("Insert some data");
        tree.insert(0);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        System.out.println("Print in order");
        tree.printInOrder();
        System.out.println("Contains 4?");
        System.out.println(tree.contains(4));
        System.out.println("Contains 6?");
        System.out.println(tree.contains(6));
        System.out.println("Contains -1?");
        System.out.println(tree.contains(-1));
    }

    static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }

        public Node() {
        }

        @Override
        public String toString() {
            return "Node{" +
                    "left=" + left +
                    ", right=" + right +
                    ", data=" + data +
                    '}';
        }

        public void insert(int value) {
            if (value < data) {
                if (left == null) {
                    left = new Node(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new Node(value);
                } else {
                    right.insert(value);
                }
            }
        }

        public boolean contains(int value) {
            if (value == data) {
                return true;
            } else if (value < data) {
                if (left == null) {
                    return false;
                } else {
                    return left.contains(value);
                }
            } else {
                if (right == null) {
                    return false;
                } else {
                    return right.contains(value);
                }
            }
        }

        public void printInOrder() {
            if (left != null) {
                left.printInOrder();
            }
            System.out.println(data);
            if (right != null) {
                right.printInOrder();
            }
        }
    }
}