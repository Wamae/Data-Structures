package com.company;

public class MyLinkedList {
    Node head;

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
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

    public void delete(int data) {
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

    private static void printList(MyLinkedList list) {
        StringBuilder builder = new StringBuilder();
        Node current = list.head;
        while (current != null) {
            builder.append(current.data + ",");
            current = current.next;
        }

        System.out.println(builder.toString());
    }


    static class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }
}

