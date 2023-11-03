package org.example.Stacks;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    /**
     *What is Reverse Polish Notation: In reverse Polish notation, the operators follow their operands. For example, to add 3 and 4 together, the expression
     * is 3 4 + rather than 3 + 4. The expression 3 − 4 + 5 in conventional notation is 3 4 − 5 + in reverse Polish notation: 4 is first subtracted from 3, then 5 is
     * added to it.
     */

    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        int data1, data2;

        if (tokens.length == 0) { // base condition
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {

            if (!(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/"))) {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                if (stack.peek() == 0 && tokens[i].equals("/")) { // this is to be away from Arithmetic exception
                    stack.pop();
                    continue;
                }
                data2 = stack.pop();
                data1 = stack.pop();
// Switch case is required to use the operator between two numerics, So here if you use expression as ":" , you have to use break statement after executing every case, but if you use
                // expression "->" (introduced in java 12) no need to use the break statement after each case.
                switch (tokens[i]) {
                    case "+" -> stack.push(data1 + data2);
                    case "-" -> stack.push(data1 - data2);
                    case "*" -> stack.push(data1 * data2);
                    case "/" -> stack.push(data1 / data2);
                }
            }
        }
        return stack.peek();
    }
}
