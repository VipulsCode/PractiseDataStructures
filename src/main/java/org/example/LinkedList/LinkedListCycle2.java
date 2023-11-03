package org.example.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCycle2 {
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
        LinkedListCycle2 ls = new LinkedListCycle2();
        ListNode ls1 = ls.detectCycle();
        ls.display(ls1);

    }

    public ListNode detectCycle() {
        ListNode head = new ListNode(1);
    /*    head.next = new ListNode(2);
        head.next.next = new ListNode(1);*/
/*        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = new ListNode(2);*/
        ListNode slow = head;
        ListNode faster = head;
        boolean flag = false;

        while(faster != null && faster.next != null) {
            slow = slow.next;
            faster = faster.next.next;
            if (slow == faster) {
                flag = true;
                break;
            }
        }
        slow = head;
        if (flag) {
            while (slow != faster) {
                slow = slow.next;
                faster = faster.next;
            }
            return slow;
        } else {
            return null;
        }
    }

    public void display(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " --> ");
            node = node.next;
        }
        System.out.println("End");
    }
}
