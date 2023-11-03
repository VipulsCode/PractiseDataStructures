package org.example.Stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ImplementStackUsingList {

    private static class StackImplementation {

        List<Integer> ls;
        public StackImplementation () {
            ls = new ArrayList<>();
        }
        public void push (int data) {
            ls.add(data);
        }

        public int pop() {
            if (ls.size() == 0) {
                return -1;
            }
            int data = ls.get(ls.size() - 1);
            ls.remove(ls.size() - 1);
            return data;
        }

        public int peek () {
            if (ls.size() == 0) {
                return -1;
            }
            return ls.get(ls.size() - 1);
        }

        public boolean isEmpty() {
            return ls.size() == 0;
        }

    }

    public static void main(String[] args) {
        StackImplementation st = new StackImplementation();
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(12);
        st.push(8);
        st.push(10);
        st.push(7);

        while(!st.isEmpty()) {
            System.out.println(st.peek());
            st.pop();
        }
    }


}
