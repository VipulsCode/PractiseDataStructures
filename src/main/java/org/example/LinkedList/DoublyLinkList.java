package org.example.LinkedList;

public class DoublyLinkList {
    private class Node {
        private int value;
        private Node next;
        private Node previous;

        private Node (int value) {
            this.value = value;
        }
        private Node (int value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }
    private int size;
    private Node head;
    private Node tail;
    public DoublyLinkList() {
        this.size = 0;
    }

    public void insertFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        if (head != null) {
            head.previous = newNode;
        }
        newNode.previous = null;
        head = newNode;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int value) {
        if (head == null) {
            insertFirst(value);
        }
        Node lastNode = head;

        while(lastNode.next != null) {
            lastNode = lastNode.next;
        }
        Node newNode = new Node(value);
        lastNode.next = newNode;
        newNode.previous = lastNode;
        lastNode = newNode;
        lastNode.next = null;
        size++;
    }
    /*public void insertLast(int value) {
        if (tail == null) {
            insertFirst(value);
            return;
        }
        Node newNode = new Node(value);
        tail.next = newNode;
        newNode.previous = tail;
        newNode.next = null;
        tail = newNode;
        size++;
    }*/

    public void insertAtTheAskedIndex(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }
        Node prevNode = getThePreviousNode(index - 1);
        Node nNode = new Node(val);
        nNode.next = prevNode.next;
        nNode.previous = prevNode;
        prevNode.next = nNode;
        nNode.next.previous = nNode;
        size++;
    }

    public void insertAfterTheValue(int afterTheValue, int insertingValue) {
        Node nd = new Node(insertingValue);
        Node prevNodeOfInsertingValue = find(afterTheValue);
        if (prevNodeOfInsertingValue == null) {
            System.out.println("The after value does not exist");
            return;
        }
        nd.previous = prevNodeOfInsertingValue;
        nd.next = prevNodeOfInsertingValue.next;
        if (nd.next != null) {
            nd.next.previous = nd;
        }
        prevNodeOfInsertingValue.next = nd;
        size++;
    }

    public Node getThePreviousNode(int index) {
        Node prevNode = head;
        for (int i = 0; i < index; i++) {
             prevNode = prevNode.next;
        }
        return prevNode;
    }

    public int removeFirst() {
        Node newNode = head;
        head = head.next;
        head.previous = null;
        size--;
        return newNode.value;
    }

    public Node find(int data) {
        Node node = head;
        while(node != null) {
            if (node.value == data) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "<--->");
            temp = temp.next;
        }
        System.out.println("END");
    }
}
