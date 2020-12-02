package com.company;

public class Stack<T> {
    Node head;

    public static void main(String[] args) {
        // Empty Stack
        Stack<Integer> stack = new Stack<>();
        System.out.println("Empty list");
        System.out.println("peek");
        System.out.println(stack.peek());
        // push 0
        System.out.println("push 0");
        stack.push(0);
        printStack(stack);
        // peek
        System.out.println("peek");
        System.out.println(stack.peek());
        // pop 0
        System.out.println("pop 0");
        stack.pop();
        printStack(stack);
        // push 0,1,2,3,4,5
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        printStack(stack);
        // pop 5
        System.out.println("pop 5");
        stack.pop();
        printStack(stack);
        // peek
        System.out.println("peek");
        System.out.println(stack.peek());
    }

    private static void printStack(Stack stack) {
        StringBuilder builder = new StringBuilder();

        Node current = stack.head;
        if (stack.head != null)
            while (current != null) {
                builder.append(current + ",");
                current = current.next;
            }

        System.out.println(builder.toString());
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T peek() {
        if (head != null) {
            return (T) head.data;
        } else {
            return null;
        }
    }

    public void push(T data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public T pop() {
        if (head == null) {
            throw new NullPointerException();
        }
        T data = (T) head.data;
        head = head.next;
        return data;
    }

    static class Node<T> {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
}
