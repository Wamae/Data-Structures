package com.company;


public class Queue<T> {
    private Node head; // Remove from here
    private Node tail; // Add from here

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue();
        System.out.println("add 0 to empty queue");
        queue.add(0);
        printList(queue);

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println("original queue");
        printList(queue);
        System.out.println("remove first item");
        queue.add(2);
        printList(queue);
        System.out.println("remove first item");
        queue.remove();
        printList(queue);
        System.out.println("remove first item");
        queue.remove();
        printList(queue);
        System.out.println("add 9");
        queue.add(9);
        printList(queue);
    }

    private static void printList(Queue queue) {
        StringBuilder builder = new StringBuilder();
        Node current = queue.head;
        if (queue.head != null) {
            while (current.next != null) {
                builder.append(current + ",");
                current = current.next;
            }
        }

        System.out.println(builder.toString());
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T peek() {
        return (T) head.data;
    }

    public void add(T data) {
        Node node = new Node(data);
        if (tail != null) {
            tail.next = node;
        }

        tail = node;

        if (head == null) {
            head = node;
        }
    }

    public T remove() {
        T data = (T) head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }


    static class Node<T> {
        private T data;
        private Node next;

        private Node(T data) {
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
