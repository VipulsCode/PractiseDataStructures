package org.example.Stacks;

import java.util.Stack;

class ValidParentheses {
    public static void main(String[] args) {
        String str = "()[]{}";
        System.out.println(validParentheses(str));
    }

    public static boolean validParentheses(String s) {
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                    stack.push(s.charAt(i));
                }
                else {
                    if(stack.isEmpty()) { // if i do not use this condition it will give empty stack exception for s ="]"
                        return false;   // as there wont be anything in stack
                    }
                    if ((s.charAt(i) == '}' && stack.peek() == '{') ||
                            (s.charAt(i) == ']' && stack.peek() == '[') ||
                            (s.charAt(i) == ')' && stack.peek() == '(')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
}
