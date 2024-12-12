package org.example.LinkedList;





public class ReorderList {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**This problem can be solved by the combination of 3 problems
     * 1. Find the mid of linked list
     * 2. reverse the 2nd half of the linked list , starting index should be mid
     * 3. Join together 2 sorted lists, here it might not be sorted , a bit of tweaking should work*/

   //public void reorderList(ListNode head) {
    public void reorderList() {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);


        // Initial check: this checks states that if the contains 2 or less nodes, no need to do anything further
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        // 1st step : get the mid of the linked list, when you see the question and asked answer , you will se the node after mid is reversed, so find the mid node first

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next; //*1 speed
            fast = fast.next.next; //*2 speed
        }

        //2nd step: time to reverse the nodes which appear after mid node, so we know slow gives us mid node, so slow.next will be the node which needs to be reversed,
        //and we say the resersed nodes as SecondHalf Nodes.

        ListNode secondHalfNodes = reverseNodesAfterMid(slow.next);

        //3rd step: when we had considered nodes after mid i.e., slow.next will be oartcipating in reverse, so now it's time to segrgate the node starting from head node till
        //mid to be treated as one half of nodes, and the secondHalf is what we got after reversal. So to make the first half after reversal can we say slow.next = null,
        //so the nodes from head till mid(which is slow) will be forst half of the nodes.

        slow.next = null; // so the first half of the node is represented as head, which will contain nodes only till mid, as we have broken the linked list after mid

        //4th step: Now mwege both the firstHalp (head) and second half of the nodes to obtain the result
        merge(head, secondHalfNodes);

        print(head); // just an additional , to print all the merged nodes at last.
    }

    public ListNode reverseNodesAfterMid(ListNode node) {
        ListNode curr = node;
        ListNode prev = null;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;

            curr = temp;
        }
        return prev;
    }

    public void merge(ListNode firstNode, ListNode secondNode) {
        // to merge it we run till secondNode != null, as this are nodes after mid+1 , so eventually there size will be lesser or equl to firstNode, but not greater.
        while (secondNode != null) {
            // Now we need to merge as per the asked solution

            ListNode firstNodeNext = firstNode.next;
            ListNode secondNodeNext = secondNode.next;
            // so storing the next nodes in advance as we will be changing the pointers

            firstNode.next = secondNode;
            secondNode.next = firstNodeNext;

            firstNode = firstNodeNext; // now making sure that we hold the firstNode pointer at the node where we are standing in first half nodes list.
            secondNode = secondNodeNext; // similary to this as well, making sure that pointer is at current standing node in secomd half node list

        }
    }

    public void print (ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val +"-->");
            temp = temp.next;
        }
        System.out.print("null"); // after all the iteration the last arrow should point to null
    }

    public static void main(String[] args) {
        ReorderList rl = new ReorderList();
          rl.reorderList();
    }
}
