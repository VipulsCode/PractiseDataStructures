package org.example.LinkedList;

import java.util.List;

public class LinkedListReversalToSaidValue {
    public static ListNode reverseLinkedListTillIndex(ListNode head, int k) {
        ListNode curr = head;
        ListNode prev = null;
        int count = 0; // to utilize in function

        while (curr != null && count < k) {
            ListNode temp = curr.next;
            curr.next = prev; // this is separating the curr node (i mean it breaks the node separately from the ListNode), and joining it to the previous making sure the reversal
            // order is followed
            prev = curr;
            curr = temp;// the curr node will be assigned by it's next node, such that now it can separate the new node from the ListNode , and again join back to the prev.
            count++;
        }

        if (curr != null) {// now i am checking if there is left node after reversing , then we knew that the 1st node in question was our head, and now that has been reversed to
            // to the asked k , so it would be at the k - 1 th index after reversing, so now if we say head.next , that means 1st node in the question now k-1th node after reversing the
            // next value of it will be curr--> which has left over's after reversing ois done

            head.next = curr; // so prev next will be holding head.next value, why , as prev last index node is 1st node of head in the question
        }

        return prev;
    }

    public static void displayLinkedList(ListNode node) {
        while(node != null) {
            System.out.print(node.value + " --> ");
            node = node.next;
        }

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        displayLinkedList(head);
        ListNode reverseList = reverseLinkedListTillIndex(head, 3);
        System.out.println();
        displayLinkedList(reverseList);
    }

}
class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null; // starting keeping the next as null
    }
}
