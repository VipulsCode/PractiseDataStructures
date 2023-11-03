package org.example.Stacks;

import java.util.List;
import java.util.Stack;

public class ImplementStack {
// Implementing using LINKED LIST

    private static class ListNode {

        private int data;
        private ListNode next;

        private ListNode(int data) {
            this.data = data;
            next = null;
        }
    }

    private static class Stack {
        // to start the top of the data in Stack let's take head
        private ListNode head;

        public void push(int data) {
            ListNode node = new ListNode(data);
            if (head == null) {
                head = node;
                return;
            }
            node.next = head;
            head = node;
        }

        public int pop() {
            if (head == null) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        public int peek () {
            if (head == null) {
                return -1;
            }
            return head.data;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }

    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(5);
        st.push(4);
        st.push(3);
        st.push(8);
        st.push(9);
        st.push(10);
        while(!st.isEmpty()) {
            System.out.println(st.peek());
            st.pop();
        }
    }
}
