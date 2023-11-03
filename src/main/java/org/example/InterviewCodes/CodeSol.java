package org.example.InterviewCodes;

public class CodeSol {
// Implemt reversal of  Liked list to a given a number

    public static ListNode linkedListReversal (ListNode head, int p) {
        // base con
        if (head == null || p <= 1) {
            return head;
        }

        ListNode curr = head;
        ListNode prev =null;
        int count = 0;

        while (curr != null && count < p) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            count++;
        }

        if (curr != null) {
            head.next = curr;// since hear head is 1 for the input 123456, and p = 3 , so till 123 is reversed and allotted to prev , now prev has 3 -> 2 -> 1
            // but initially head starts from node 1 , so once the reversal done in prev , the rest of left over nodes , will be held by curr Node = 4 -> 5 -> 6, if i say head.next = curr
            // i meant 1.next = 4 -> 5 -> 6, so the prev last node after reversal is 1 (i.e. 3 -> 2 -> 1) and just now we said 1.next will be 4 -> 5 -> 6, so the the cumulated Linked list in
            // prev node is 3 -> 2 -> 1 -> 4 -> 5 -> 6 , hence returning prev.
        }
        return prev;
    }

    public static void printLinkedList(ListNode head) {
        ListNode itrNode = head;
        while (itrNode != null) {
            System.out.print(itrNode.val + "--> ");
            itrNode = itrNode.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        int p = 3;

        printLinkedList(head);
        System.out.println();
        ListNode data = linkedListReversal(head, p);
        printLinkedList(data);


    }
}

class ListNode{
    int val;
    ListNode next;

    ListNode (int val) {
        this.val = val;
    }

}
