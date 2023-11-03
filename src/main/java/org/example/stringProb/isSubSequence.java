package org.example.stringProb;

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters.
 * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 *
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 */

public class isSubSequence {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isItSubSequence(s,t));
    }

    public static boolean isItSubSequence(String s, String t) {
        int i = 0;
        int j = 0;

        while( i < s.length() && j < t.length()) { // if any of the length fails the while loop will terminate, so the idea is
            // the shorter length will terminate first, and if the shorter characters are all present in longer string with out changing
            // the order then it is a subsequence.
            if (s.charAt(i) == t.charAt(j)) {
                i++;    // increment only if the character s in found in t, if not no
            }
            j++;    // so why j++, coz we need to find if s is a subsequence of t, so keep on iterating t
        }
        return i == s.length(); // why compare with s.length as it is said to check if s is a subsequence of t, not the other way around
        // so if i get all the the present of s in t, only then i++, so check after collecting the length of i , is it same as length of S
    }
}
