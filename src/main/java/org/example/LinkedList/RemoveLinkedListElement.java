package org.example.LinkedList;

public class RemoveLinkedListElement {
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
        RemoveLinkedListElement ls = new RemoveLinkedListElement();
        ListNode ks= ls.removeElements(7);
        ls.display(ks);


    }
    public ListNode removeElements(int val) {
        ListNode head = new ListNode(7);
        head.next = new ListNode(7);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(7);
/*        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);*/


        ListNode temp = head;
        ListNode head1 = new ListNode();
        ListNode head2 = head1;
        while(temp != null) {
            if (temp.val == val) {
                temp = temp.next;
            }
            else {
                head2.next = temp;
                head2 = temp;
                temp = temp.next;
                head2.next = null; //to make sure if the last value matches the given val, even that's removed
            }
        }
        return head1.next;
    }
    public void display(ListNode node) {
        while(node != null) {
            System.out.print(node.val + "-->");
            node = node.next;
        }
        System.out.println("End");
    }
}
