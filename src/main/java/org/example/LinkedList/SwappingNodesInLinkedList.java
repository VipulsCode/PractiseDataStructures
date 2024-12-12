package org.example.LinkedList;

import java.util.List;

public class SwappingNodesInLinkedList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        SwappingNodesInLinkedList sw = new SwappingNodesInLinkedList();
        ListNode res = sw.swapNodes(2);
        sw.display(res);
    }

    public ListNode swapNodes(int k) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int length = getTheLength(head);

        ListNode firstPointerNode = getTheNodeAddressForKIndex(head, k);// here i get the address of left side of kth indexed node
        ListNode secondNodePointer = getTheNodeAddressForKIndex(head, (length - k) + 1); // here i get the address of right side(traversing reversal from right) of kth indexed node

        // now computation of swapping the value in the above obtained addresses
        int temp = firstPointerNode.val;
        firstPointerNode.val = secondNodePointer.val;// here replacing the first node val with second node val at the address of First Node
        secondNodePointer.val = temp;// here replacing the second node val with first node val at the address of second Node

        return head; // all the action does take place in head it self, just replacement of value was done , need to return the whole listNode after replacing values
    }


    public ListNode getTheNodeAddressForKIndex(ListNode head, int k) {
        ListNode tempNode = head;
        int count = 1;
        while (tempNode != null && count < k) {
            count++;
            tempNode = tempNode.next;
        }
        return tempNode; // here i get the address of the asked indexed node
    }

    public int getTheLength(ListNode head) {
        ListNode node = head;
        int length = 0;
        while(node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    public void display (ListNode node) {
        while(node.next != null) {
            System.out.print(node.val + "-->");
            node = node.next;
        }
        System.out.println("End");
    }
}
