package org.example.stringProb;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 */
public class IsomorphicString {
    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        System.out.println(isIsomorphic(s, t));
    }

    public static  boolean isIsomorphic(String s, String t) {
        Map<Character, Character> hmap = new HashMap<>();
        String comparingString = "";
        for (int i = 0; i < s.length(); i++) {
            if (!hmap.containsKey(s.charAt(i)) && !hmap.containsValue(t.charAt(i))) {
                hmap.put(s.charAt(i), t.charAt(i));
            }
            comparingString += hmap.get(s.charAt(i));
        }
        return comparingString.equals(t);
    }
}

