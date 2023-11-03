package org.example.LinkedList;

public class SinglyLinkList {
    // two important part of singly linked list is
    private Node head;
    private Node tail;


    private class Node {
        private int val;
        private Node next;

        private Node(int val) {
            this.val = val;
        }
        private Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
    private int size;

    public SinglyLinkList(){
        this.size = 0;
    }

    public void insertFirst(int val) {
        // create the box with val i.e, Node with val
        Node node = new Node(val);
        // now just node is created we need to point it to head to get attached to the list
        node.next = head;
        // now we know that the head should always point to the first node , so assign newly created node to head
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + "-->");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node lastNode = new Node(val);
        // here the tail has to point to the next new node rather the new node pointing to tail
        tail.next = lastNode;
        tail = lastNode;
        size++;
    }

    // Inserting at the asked indexed value
    public void insertAtTheAskedIndexed(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }

        // so to reach till asked index we need to iterate so assign head to temporary Node as temp,
        // why node because temp should have val as well the address of the next node
        Node temp = head;
        for(int i = 1; i < index; i++) { // why i = 1 , coz "Node temp = head" represents 0th data
            temp = temp.next; // get to the previous index of asked index
        }
        //Now create a node with new asked val

        Node nd = new Node(val, temp.next);
            // why this coz while we insert a new node in mid, let us say we need to insert in 3rd index,
            // so previous 3rd and 4th index link needs to be broken , so now the second index will treat a new node as a 3rd indexed value and
            // this new node will also carry the address of 4th index(i.e. temp.next)

        temp.next = nd; // now temp.next needs to be aligned to new node
        size++;
    }

    public int deleteFirst() {
        // store the number which you want to delete
        int value = head.val;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    public int deleteLast() {
        if(size <= 1) {
            return deleteFirst();
        }
        tail = getTheIndexNode(size - 2);
        tail.next = null;
        size--;
        return tail.val;
    }

    public int deleteAtTheAskedIndex(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }
        Node indexesPreviousNode = getTheIndexNode(index - 1);
        int deletedValue = indexesPreviousNode.next.val;
        indexesPreviousNode.next = indexesPreviousNode.next.next;
        size--;
        return deletedValue;

    }

    public int findTheNode(int value) {
        Node itrNode = head;
        for (int i = 0; i < size; i++) {
            if (itrNode.val == value) {
                return i;
            }
            itrNode = itrNode.next;
        }
        return -1;
    }

    public Node getTheIndexNode(int index) {
        Node itrNode = head;
        for (int i = 0; i < index; i++) {
            itrNode = itrNode.next;
        }
        return itrNode;
    }

}
