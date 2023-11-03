package org.example.LinkedList;

/** 707. Design Linked List*/

public class DesignLinkedList {
    private Node head;
    private Node tail;
    private class Node {
        private int value;
        private Node next;

        private Node (int value) {
            this.value = value;
        }
        private Node (int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    private int size;
    public DesignLinkedList() {
        this.size = 0;
    }

    public int get(int index) {
        if (index < 0 || index > size - 1) {
            return -1;
        }
        Node node = head;
        int value = -1;
        for (int i = 0; i <= index; i++) {
            value = node.value;
            node = node.next;
        }
        return value;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (tail == null) {
            addAtHead(val);
            return;
        }
        tail.next = newNode;
        newNode.next = null;
        tail = newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        Node newNode = new Node(val);
        if (index == size) {
            addAtTail(val);
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index > size || index < 0) {
            return;
        }
        Node previousNode = find(index);
        newNode.next = previousNode.next;
        previousNode.next = newNode;
        size++;
    }
    public Node find(int index) {
        Node temp = head;
        for (int i = 0; i < index-1; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index > size-1) {
            return;
        }
        Node node = head;
        if (index == size-1) {
            node = find(index);
            node.next = null;
            tail = node;
            size--;
            return;
        }
        if (index == 0) {
            head = node.next;
            size--;
            return;
        }
        node = find(index);
        if(node.next != null) {
            node.next = node.next.next;
        }
    }

    public void display() {
        Node newNode = head;
        while (newNode != null) {
            System.out.print(newNode.value + "-->");
            newNode = newNode.next;
        }
        System.out.println("End");
    }
}
