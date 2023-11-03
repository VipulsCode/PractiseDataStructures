package org.example.stringProb;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') ||
                    (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                str.append(s.charAt(i));
            }
        }
        if (str.isEmpty()) {
            return true;
        }
        System.out.println("The filtered string is ==> " + str);
        int l = 0;
        int r = str.length() -1;
        while (l <= r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s =  "race a car" ;
        System.out.println(isPalindrome(s));
    }
}
