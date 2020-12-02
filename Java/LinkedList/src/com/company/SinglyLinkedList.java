package com.company;

public class SinglyLinkedList <T>{
    Node head;

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList();
        System.out.println("prepend 0 to empty list");
        list.prepend(0);
        printList(list);

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);

        System.out.println("original list");
        printList(list);
        System.out.println("delete 2");
        list.delete(2);
        printList(list);
        System.out.println("delete 0");
        list.delete(0);
        printList(list);
        System.out.println("delete 5");
        list.delete(5);
        printList(list);
        System.out.println("prepend 9");
        list.prepend(9);
        printList(list);
    }

    public void append(int data) {

        if (head == null) {
            head = new Node(data);
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = new Node(data);
    }

    public void prepend(int data) {
        Node newHead = new Node(data);
        if (head == null) {
            head = newHead;
            return;
        }

        newHead.next = head;
        head = newHead;
    }

    public void delete(T data) {
        if (head == null) {
            return;
        }


        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    private static void printList(SinglyLinkedList list) {
        StringBuilder builder = new StringBuilder();
        Node current = list.head;
        while (current != null) {
            builder.append(current + ",");
            current = current.next;
        }

        System.out.println(builder.toString());
    }


    static class Node<T> {
        Node next;
        T data;

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

