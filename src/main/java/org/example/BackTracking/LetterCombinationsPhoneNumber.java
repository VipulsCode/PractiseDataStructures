package org.example.BackTracking;

import java.util.*;

public class LetterCombinationsPhoneNumber {
    public List<String> letterCombinations(String digits) {
        int index = 0;// to keep track and useful in reaching base condition
        List<String> res = new ArrayList<>();

        if (digits.isBlank()) {
            return res;
        }

        // we will use map to store all the patterns of phone number , for eg in old phone key 2 holds abc, key 3 holds "def" and so on , so we consider 2 to 9, as key 1
        // does not hold anything

        Map<Character, String> digitsToLetters = new HashMap<>();
        digitsToLetters.put('2', "abc");
        digitsToLetters.put('3', "def");
        digitsToLetters.put('4', "ghi");
        digitsToLetters.put('5', "jkl");
        digitsToLetters.put('6', "mno");
        digitsToLetters.put('7', "pqrs");
        digitsToLetters.put('8', "tuv");
        digitsToLetters.put('9', "wxyz");

        backTrack(index, "", res, digits, digitsToLetters);
        return res;
    }

    public void backTrack(int index, String currString, List<String> res, String digits, Map<Character, String> mapDigitToString) {
        // base condition

        if (index == digits.length()) {
            res.add(currString);
            return;
        }

        char digit = digits.charAt(index);// to retrieve the number  from digit  given from question , so you'll obtain if digit is "23" youll obtain 2 and then 3
        String letters = mapDigitToString.get(digit);// to retrieve the letters from hashmap, so for 2 associated value is "abc"

        for (char ch : letters.toCharArray()) { // here i am iterating the values obtained from map
            backTrack(index + 1, currString + ch, res, digits, mapDigitToString); // the index is increased, the 1st time currString will hold "a", then "ad"
            // then "ae" , then "af", similarly "b" , then "bd', "be", "bf" but we won't consider single alphabet, as we need to give combination so "ad", "ae", "af", "bd", "be' and so on
            // will be combination
        }
    }

    public static void main(String[] args) {
        LetterCombinationsPhoneNumber ls = new LetterCombinationsPhoneNumber();
        List<String> res = ls.letterCombinations("23");
        System.out.println(res);
    }
}
