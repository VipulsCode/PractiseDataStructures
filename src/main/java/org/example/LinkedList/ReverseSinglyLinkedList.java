package org.example.LinkedList;

public class ReverseSinglyLinkedList {
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
    //private ListNode head1;

        public static void main(String[] args) {
            ReverseSinglyLinkedList reverseSinglyLinkedList = new ReverseSinglyLinkedList();
            ListNode node = reverseSinglyLinkedList.reverseList();
            reverseSinglyLinkedList.display(node);
        }
        public ListNode reverseList() {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);

            ListNode curr = head;
            ListNode prev = null;

            while (curr != null) {
                ListNode temp = curr.next; // so the next node is not lost as we will be assigning curr.next to prev node
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            return prev;
        }

    public void display(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "--> ");
            node = node.next;
        }
        System.out.println("End");
    }
}
