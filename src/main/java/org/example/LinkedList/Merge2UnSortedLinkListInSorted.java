package org.example.LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Merge2UnSortedLinkListInSorted {

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
        /** END OF DATA given in leet code */
    }

    public Merge2UnSortedLinkListInSorted() {
    }

    public void Merge2UnSortedLinkListInSorted() {
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(5);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(8);
        head1.next.next.next.next = new ListNode(4);

        ListNode head2 = new ListNode(7);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(5);
        head2.next.next.next = new ListNode(2);
        head2.next.next.next.next = new ListNode(4);

        //1st step : Merge the two unsorted list to make it a single list

        head1 = mergeInSingleLinkList(head1, head2);

        if (head1 == null) {
            System.out.println("Empty List");
            return;
        }

        // 2nd step: store every individual data of merged linked list in the List and then sort the list

        ListNode temp = head1;
        List<Integer> ls = new ArrayList<>();
        while (temp != null) {
            int data = temp.value;
            ls.add(data);
            temp = temp.next;
        }
        // sort the list using inbuilt method
        Collections.sort(ls);

        // 3rd step : Now we have the sorted list npw frame the head1 , by adding the value in it extracting from the list , this will get the sorted linked list

        temp = head1;
        for (int i = 0; i < ls.size(); i++) {
            temp.value = ls.get(i);
            temp = temp.next;
        }
        temp.next = null;// the tail should point to null at last

        display(head1);
    }

    private ListNode mergeInSingleLinkList(ListNode head1, ListNode head2) {
        ListNode temp = head1;

        if (head1 == null) { // a base condition
            return head2;
        }
        // iterate till last node of head1, and at last just point the last node pointer of head1 to the head of head2, to join both the linked list
        while (temp.next != null) {
            temp = temp.next;
        }
        // once reached to the last node of head1, point the last node next pointer to head2
        temp.next = head2;
        return head1;
    }

    private void display(ListNode head1) {
        ListNode temp = head1;
        while (temp != null) {
            System.out.println(temp.value + "-->");
            temp = temp.next;
        }
        System.out.print("null");
    }


}
