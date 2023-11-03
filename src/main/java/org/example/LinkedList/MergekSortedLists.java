package org.example.LinkedList;

public class MergekSortedLists {
    private class ListNode {
        private int val;
        private ListNode next;

        private ListNode() {

        }
        private ListNode(int val) {
            this.val = val;
        }
        private ListNode(ListNode next) {
            this.next = next;
        }
    }
    public static void main(String[] args) {
        MergekSortedLists mr = new MergekSortedLists();
        mr.mergeKLists();
    }
    public ListNode mergeKLists() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = new ListNode[3];
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;

        if (lists == null || lists.length == 0) {
            return null;
        }


        ListNode temp = null; // so the first time temp will be null, that is it will act as a 0th node for first time, later the nodes will be properly
                                // populated after the method getTheMeegedKListFramed is called and computed
        for (int i = 0; i < lists.length; i++) {
            temp = getTheMergedKListFramed(temp, lists[i]);
        }
        display(temp);
        return temp;
    }
    public ListNode getTheMergedKListFramed(ListNode firstNode, ListNode secondNode) {
        ListNode head = new ListNode();
        ListNode temp = head;

        while (firstNode != null && secondNode != null) {
            if (firstNode.val < secondNode.val) {
                temp.next = firstNode;
                temp = firstNode;
                firstNode = firstNode.next;
            } else {
                temp.next = secondNode;
                temp = secondNode;
                secondNode = secondNode.next;
            }
        }
        if (firstNode == null) {
            temp.next = secondNode;
        }
        if (secondNode == null) {
            temp.next = firstNode;
        }
        return head.next;
    }
    public void display (ListNode node) {
        while (node != null) {
            System.out.print(node.val + "-->");
            node = node.next;
        }
        System.out.println("End");
    }
}
