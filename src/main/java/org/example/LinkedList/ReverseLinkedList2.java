package org.example.LinkedList;

public class ReverseLinkedList2 {
    private class ListNode {

        private int val;
        private ListNode next;

        private ListNode(){};

        private ListNode(int val) {
            this.val = val;
        }

        private ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedList2 rs = new ReverseLinkedList2();
        ListNode node = rs.reverseBetween(2,4);
        rs.display(node);

    }
    public ListNode reverseBetween(int left, int right) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // 1st we initiate a ListNode which will be used to hold the answer ListNode.

        ListNode temp1 = head;
        ListNode ansHead = new ListNode();
        ListNode temp2 = ansHead; // Here this is the ListNode which will be used to store the answered ListNode, initially it's null

        // Now store all the Node's till before left in temp 2
        for (int i = 1; i < left; i++) { // here the index value will start from 1 not from 0
            temp2.next = temp1; // here i am assigning the root , as the 1st node to temp2.next, hence temp1 is used to just iterate, And the Node will be from temp2.next, hence returning ansHead.next
            temp2 = temp2.next; // making sure that temp2 is on the iterated index. so here it temp2 will point to temp1 val, as i had already assigned temp2.next as temp1.
            temp1 = temp1.next; // checking further nodes of temp1 on for loop , so moving forward
        }

        // Now till here the temp2 hold's the node which shouldn't be reversed that is the nodes before left.

        // Now we need to do the reversal of the nodes , from left till given right, so we consider 2 ListNodes.
        ListNode curr;
        ListNode prev = null;
        int j = left;// this is used to keep the track that i iterate only till right, why assigning left to j , coz we will be needing the left which is in param, again, so to
        // iterate the left we take j.


        // Now we need to initialise the node curr, and the below if statement checks should we reverse the linkedlist from the very first index, in this case the starting
        // index is from 1.
        if (left > 1) {
            curr = temp2.next; //so here i haven't used temp1.next, as it can be seen in for loop the temp1 is already advanced forward. And temp2 was holding temp1 value and hadn't advanced
        } else {
            curr = head; // so here we say the left given here is from very first index so let the reversal begin from head it self.
        }

        while (j <= right) {
            ListNode temp = curr.next; //  And we are following here the typical reversal code.
            curr.next = prev;
            prev = curr; // and the prev will contain the reversed nodes of left to right nodes.
            curr = temp; // so once the loop contains the current will contain the node which is greater than right
            j++;
        }

        j = left; // so as i had said we will be using left again. Now the below while loop is to populate further nodes of temp2 with the reversed nodes using prev ListNode.
        while (j <= right) { // so till here we know temp2 contains the all the nodes before the given index left, now below code will populate temp2 after left till right
            // index all the nodes in reversed order
            temp2.next = prev;
            temp2 = temp2.next;// making sure we are on the current node.
            prev = prev.next;
            j++;
        }

        // Now till here the temp2 has the combination of nodes before left, and the reversal order of nodes from left till right index, now what about the nodes after the
        // index right, which did not participate in reversal, coz as per question we need to reverse only from index left till right.
        // so for the nodes after the right index, we know that "curr" ListNode holds the Node which is after right, check first while loop. so now just populate temp2.next = curr.
        // so if there's no Node after right index then curr would have been null, or if there are nodes present after right we take it as it is, and populate in the streak of temp2

        temp2.next = curr;

        return ansHead.next;

    }
    public void display(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " --> ");
            node = node.next;
        }
        System.out.println("End");
    }

}
