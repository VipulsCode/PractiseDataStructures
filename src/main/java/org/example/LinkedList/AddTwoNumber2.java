package org.example.LinkedList;

import java.util.Stack;

public class AddTwoNumber2 {
    private class ListNode {
        private int val;
        private ListNode next;

        private ListNode() {};

        private ListNode(int val) {
            this.val = val;
        }

        private ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        AddTwoNumber2 add = new AddTwoNumber2();
        ListNode node = add.addTwoNumbers();
        add.display(node);
    }

    public ListNode addTwoNumbers() {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        // so if the data had to be added from both the list from left to right then it can be achieved easily
        // but since the data has to be fetched from right to left so we can achieve this by using STACK

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.add(l2.val);
            l2 = l2.next;
        }
        // above i have added the data in STACK, now if we POP it is LIFO, so adding from right to left can be achieved
        int carry = 0;
        ListNode res = null;

        while (!s1.isEmpty() || !s2.isEmpty()) {  // i am utilizing OR rather AND over here, so that i do not have keep on checking for s1 and s2 being empty
            // separately in 2 separate while loop, if any one get's empty if using AND operator

            int a = 0, b = 0;

            if (!s1.isEmpty()) {
                a = s1.pop();
            }
            if (!s2.isEmpty()) {
                b = s2.pop();
            }
            int total = a + b + carry;
            ListNode temp = new ListNode(total % 10);
            carry = total/10;
            if ( res == null) {
                res = temp;
            } else {
                temp.next = res;
                res = temp;
            }
        }
        if (carry != 0) {
            ListNode temp = new ListNode(carry);
            temp.next = res;
            res = temp;
        }
        return res;
    }

    public void display (ListNode node) {
        while (node != null) {
            System.out.print(node.val + "--> ");
            node = node.next;
        }
        System.out.println("END");
    }
}
