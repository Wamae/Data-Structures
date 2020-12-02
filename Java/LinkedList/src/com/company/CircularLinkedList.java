package com.company;

import java.util.List;

public class CircularLinkedList<T> {
    Node head;

    public static void main(String[] main) {
        CircularLinkedList list = new CircularLinkedList();
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

    private static void printList(CircularLinkedList list) {
        StringBuilder builder = new StringBuilder();
        Node current = list.head;
        if (current != null) {
            do {
                builder.append("[data: " + current.data + " next: " + current.next + "],");
                current = current.next;
            } while (current != null && current != list.head);
        }

        System.out.println(builder.toString());
    }

    public void append(T data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node current = head;
        while (current.next != null && current.next != head) {
            current = current.next;
        }

        Node newLast = new Node(data);
        current.next = newLast;
        newLast.next = head;

    }

    public int size() {
        Node current = this.head;
        int size = 0;
        while (current.next != null && current.next != this.head) {
            current = current.next;
            size++;
        }
        return size;
    }

    public void prepend(T data) {
        Node newHead = new Node(data);
        if (head == null) {
            head = newHead;
            return;
        }

        // If length is one

        Node current = head;
        if (this.size() > 1) {
            while (current.next != this.head) {
                current = current.next;
            }
        }

        current.next = newHead;
        newHead.next = this.head;
        head = newHead;
    }

    public void delete(T data) {
        if(head == null){
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while(current.next != null && current.next != head){
            if(current.next.data == data){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    static class Node<T> {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }
}
