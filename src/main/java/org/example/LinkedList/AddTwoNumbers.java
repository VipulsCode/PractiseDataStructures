package org.example.LinkedList;
/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
 * and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 */

import org.w3c.dom.Node;
import org.w3c.dom.ls.LSException;

public class AddTwoNumbers {
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
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode node = addTwoNumbers.addTwoNumbers();
        addTwoNumbers.display(node);

    }
    public ListNode addTwoNumbers() {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
         l2.next = new ListNode(9);
         l2.next.next = new ListNode(9);
         l2.next.next.next = new ListNode(9);


        int sum = 0;
        int carry = 0;
        ListNode head = new ListNode();
        ListNode currNode = head;

        while (l1 != null && l2 != null) {
            sum = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;

            currNode.next = new ListNode(sum);
            currNode = currNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            sum = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;

            currNode.next = new ListNode(sum);
            currNode = currNode.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            sum = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;

            currNode.next = new ListNode(sum);
            currNode = currNode.next;
            l2 = l2.next;
        }

        if (carry != 0) {
            currNode.next = new ListNode(carry);
            currNode = currNode.next;
        }

        return head.next;
    }

    public void display (ListNode node) {
        while (node != null) {
            System.out.print(node.val + "--> ");
            node = node.next;
        }
        System.out.println("End");
    }

}
