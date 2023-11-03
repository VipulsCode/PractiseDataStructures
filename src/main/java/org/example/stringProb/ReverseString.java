package org.example.stringProb;

public class
ReverseString {
    public static void main(String[] args) {
        String[] str = {"h","e","l","l","o"};


    }
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length-1;

        while (l <= r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
