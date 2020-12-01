package com.company;

public class MyDoublyLinkedList {
    Node head;

    public static void main(String[] args) {
        MyDoublyLinkedList list = new MyDoublyLinkedList();
        printList(list);
        System.out.println("append 1");
        list.append(1);
        printList(list);
        System.out.println("append 2");
        list.append(2);
        printList(list);
        System.out.println("append 3");
        list.append(3);
        printList(list);
        System.out.println("append 4");
        list.append(4);
        printList(list);


        System.out.println("prepend 0");
        list.prepend(0);
        printList(list);

        System.out.println("delete 1");
        list.delete(1);
        printList(list);

        System.out.println("delete 0");
        list.delete(0);
        printList(list);

        System.out.println("delete 4");
        list.delete(4);
        printList(list);

        System.out.println("prepend 0 to empty list");
        list = new MyDoublyLinkedList();
        list.prepend(0);
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

        Node newNode = new Node(data);
        newNode.previous = current;
        current.next = newNode;
    }

    public void prepend(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node newHead = new Node(data);
        head.previous = newHead;
        newHead.next = head;
        head = newHead;
    }

    public void delete(int data) {
        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                if(current.next.next == null){
                    current.next = null;
                    return;
                }
                current.next.next.previous = current;
                current.next = current.next.next;
                return;
            }

            current = current.next;
        }
    }

    private static void printList(MyDoublyLinkedList list) {
        StringBuilder builder = new StringBuilder();
        Node current = list.head;
        while (current != null) {
            builder.append("[data: " + current.data + " previous: " + current.previous + " next: " + current.next + "],");
            current = current.next;
        }

        System.out.println(builder.toString());
    }

    class Node {
        Node previous;
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return String.valueOf(this.data);
        }
    }
}
