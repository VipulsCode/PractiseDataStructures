package org.example.stringProb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> data = partition(s);
        System.out.println(Arrays.toString(data.toArray()));
    }

    public static List<List<String>> partition(String s) {
        List<String> l1 = new ArrayList<>();
        List<List<String>> l2 = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            l1.add(s.charAt(i) + "");
        }
        l2.add(l1);
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(0, i+1);
            if (checkIfTheStringIsPalindrome(str)) {
                l1 = new ArrayList<>();
                l1.add(str);
                l2.add(l1);
            }
        }
        return l2;
    }

    public static Boolean checkIfTheStringIsPalindrome(String s) {
        int j = s.length() - 1;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(j)) {
                j--;
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

}
