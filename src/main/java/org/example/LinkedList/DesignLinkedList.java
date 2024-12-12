package org.example.LinkedList;

/** 707. Design Linked List*/

public class DesignLinkedList {
    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }

        Node (int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DesignLinkedList() {
        size = 0;
    }

    public int get(int index) {
        if (head == null || tail == null) {
            return -1;
        }
        if (index == 0) {
            return head.val;
        }
        if (index == size - 1) {
            return tail.val;
        }
        Node node = head;

        for (int i = 0; i < index; i++) {
            if (node != null)
                node = node.next;
        }
        if (node != null) {
            return node.val;
        }
        return -1;

    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            node.next = null;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size ++;
    }

    public void addAtTail(int val) {
        if (tail == null) {
            addAtHead(val);
        } else {
            Node tailNode = new Node(val);
            tail.next = tailNode;
            tailNode.next = null;
            tail = tailNode;
            size++;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            Node newNode = new Node(val);
            Node nd = getPrevNodeoFIndex(index);
            newNode.next = nd.next;
            nd.next = newNode;
            size++;
        }

    }

    public void deleteAtIndex(int index) {
        if (index > size - 1 || index < 0) {
            return;
        }
        Node node = getPrevNodeoFIndex(index);
        if (index == 0) {
            head = head.next;
        } else if (index == size - 1) {
            node .next = null;
            tail = node;
        } else {
            node.next = node.next.next;
        }
        size--;
    }

    public Node getPrevNodeoFIndex(int index) {
        Node node = head;
        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }
        return node;
    }

    public void display() {
        Node newNode = head;
        while (newNode != null) {
            System.out.print(newNode.val + "-->");
            newNode = newNode.next;
        }
        System.out.println("End");
    }


}
