package org.example.stringProb;

import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "9";
        int k = 1;
        System.out.println(removeKdigits(num, k));

    }

    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            // why while loop is because you can remove from in between as well rather than in linear , to understand better take this data as an eg 178694
            while (stack.size() > 0 && stack.peek() > num.charAt(i) && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        while(k > 0) { // This is done if the K times the items aren't removed but the for loop is done ,
                        // so the  data in stack will be in ascending form, so remove from the last till k completes it's said number of computation
            stack.pop();
            k--;
        }

        // now you need to take out the data from stack and put it in an array, by this you'll also come to know about leading zeros
        char[] ch = new char[stack.size()];

        int stackLength = stack.size() - 1;
        while (stackLength >= 0) {
            ch[stackLength--] = stack.pop();
        }

        // now to remove leading zeros from ch array if there are any, this can be done by counting number of leading continuous zeros in the array.
        int leadingZeroCount = 0;
        int charArrayLength = ch.length;
        while (charArrayLength > 0 && ch[leadingZeroCount] == '0') {
            leadingZeroCount++;
            charArrayLength--;
        }

        // Now appending the data in String builder or string
        StringBuilder sb = new StringBuilder();
        while(leadingZeroCount < ch.length) {

            sb.append(ch[leadingZeroCount++]);// why leadingZeroCount++ here , as we know that leadingZeroCount gives number of zeros occurring in continuous fashion in char array,
            // so start to taking the value from ch array post the count(inclusive number of above re-initialized data) of leading zeros.
        }
        if (sb.length() == 0) {
            return "0";
        }
        return String.valueOf(sb);
    }

      /*  Stack<Integer> sta = new Stack<>();
        int computingData = Integer.parseInt(num);
        int powerRaiseSize = num.length();
        String res = "";
        for (int i = 0; i < num.length(); i++) {
            int singularInteger = (int) (computingData / Math.pow(10, --powerRaiseSize));
            computingData = (int) (computingData % Math.pow(10, powerRaiseSize));
            if (i == 0) {
                sta.push(singularInteger);
            } else {

                if (sta.peek() > singularInteger && k > 0) {
                    sta.pop();
                    k--;
                }
                sta.push(singularInteger);
            }
        }
        while(k > 0) {
            sta.pop();
            k--;
        }

        int size = sta.size();
        for (int i = 0; i < size; i++) {
            res = sta.pop() + res;
        }
        if (res.isEmpty()) {
            return "0";
        }
        return String.valueOf(Integer.parseInt(res));*/

}
