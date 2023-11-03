package org.example.LinkedList;


import org.w3c.dom.Node;

import java.util.List;

public class MergeTwoSortedLists {

    /** given in leet code */
    private class ListNode {
        int value;
        ListNode next;

        private ListNode(int value) {
            this.value = value;
        }
        private ListNode() {

        }
        private ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }

    public MergeTwoSortedLists() {
    }

    /** END OF DATA given in leet code */


    public static void main(String[] args) {

        MergeTwoSortedLists mr = new MergeTwoSortedLists();
        mr.mergeTwoLists();
    }


    public ListNode mergeTwoLists() {

        /** given in leet code */
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        /** END OF DATA given in leet code */

        ListNode head = new ListNode();
        ListNode tail = head;

        while (list1 != null && list2 != null) {
            if (list1.value < list2.value) {
                tail.next = list1;
                tail = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                tail = list2;
                list2 = list2.next;
            }
        }
        if (list1 == null) {
            tail.next = list2;
        }
        if (list2 == null) {
            tail.next = list1;
        }
        //display(head.next);
        return head.next;
    }



// Testing method
    public void display(ListNode node) {
        while (node != null) {
            System.out.print(node.value + "--> ");
            node = node.next;
        }
        System.out.println("End");
    }
}

