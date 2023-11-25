package org.example.InterviewCodes;

import java.util.*;

public class InteviewSoln {

    // {{{[[]]))}
    public static void main(String[] args) {
        String s = "[{()}]";

        System.out.println(validateTheParanthese(s));
    }

public static boolean validateTheParanthese(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' ||  s.charAt(i) == '(') {
                st.push(s.charAt(i));
            } else if (st.isEmpty()) {
                return false;
            } else {
                if ((s.charAt(i) == '}' && st.peek() == '{') || (s.charAt(i) == ']' && st.peek() == '[') ||
                        (s.charAt(i) == ')' && st.peek() == '(')) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

}
