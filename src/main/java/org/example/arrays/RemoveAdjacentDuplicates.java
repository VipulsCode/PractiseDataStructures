package org.example.arrays;

import java.util.Stack;

// FOR ARRAYS AS WELL AS STRING

public class RemoveAdjacentDuplicates {
    public static void main(String[] args) {

        int[] arr = {1,4,5,1,2,0,0,2,4,5};
        String s = "abbaca";
        removeDup(s);
        removeDuplicates(arr);

    }


    // FOR STRING
    public static void removeDup(String s) {

        Stack<Character> st = new Stack<>();
        st.add(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (!st.isEmpty() && s.charAt(i) == st.peek()) {
                st.pop();
            } else {
                st.add(s.charAt(i));
            }
        }
        String resStr = "";
        for(Character ch : st) {
            resStr = resStr + ch;
        }
        System.out.println(resStr);
    }


    // FOR ARRAY
    public static void removeDuplicates(int[] arr) {
        Stack<Integer> st = new Stack<>();
        st.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (!st.isEmpty() && arr[i] == st.peek()) {
                st.pop();
            } else {
                st.add(arr[i]);
            }
        }

        System.out.println(st);

    }
}
