package org.example.LinkedList;

public class CircularLinkedList {
    private Node head;
    private Node tail;
    private class Node {
        private int value;
        private Node next;

        private Node (int value) {
            this.value = value;
        }
        private Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    private int size;
    public CircularLinkedList() {
        this.size = 0;
    }

    public void insertFirst(int val) {
        Node nd = new Node(val);
        if (head == null) {
            head = nd;
            tail = nd;
            size++;
            return;
        }
        nd.next = head;
        tail.next = nd;
        head = nd;
        size++;
    }
    public void insertAtLast(int val) {
        Node nd = new Node(val);
        if (head == null) {
            head = nd;
            tail = nd;
            size++;
            return;
        }
        nd.next = head;
        tail.next = nd;
        tail = nd;
        size++;
    }

    public void delete(int val) {
        Node node = head;
        if (node == null) {
            return;
        }
        if (node.value == val) {
            tail.next = head.next;
            head = head.next;
            return;
        }
        do {
            Node n = node.next;
            if (n.value == val) {
                node.next = n.next;
                break;
            }
            node = node.next;
        } while (node != head); // Since it's circular thats the reason
    }

    public void display() {
        Node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.value + "-->");
                    temp = temp.next;
            } while (temp != head && temp != null);
            System.out.println("end");
        }
    }
}
