package org.example.LinkedList;

public class MiddleOfLinkedList {
    private class ListNode {
        private int val;
        private ListNode next;

        private ListNode() {

        }
        private ListNode(int val) {
            this.val = val;
        }
        private ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static void main(String[] args) {
        MiddleOfLinkedList ml = new MiddleOfLinkedList();
        ListNode ls = ml.middleNode();
        System.out.println(ls.val);
    }
    public ListNode middleNode() {
        ListNode ls = new ListNode(1);
        ls.next = new ListNode(2);
        ls.next.next = new ListNode(3);
        ls.next.next.next = new ListNode(4);
        ls.next.next.next.next = new ListNode(5);

        ListNode slow = ls;
        ListNode fast = ls;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
