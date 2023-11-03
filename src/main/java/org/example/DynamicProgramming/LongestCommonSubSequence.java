package org.example.DynamicProgramming;

public class LongestCommonSubSequence {
    public int longestCommonSubsequence(String text1, String text2) {

        // let text2 = be the row
        // let text1 be the column
        int[][] cache = new int[text2.length() + 1][text1.length() + 1];

        // why +1 as for finding the longest common subsequence in dp we add additional 1st row and 1st column of value as "" (empty string)
        // the value for the rows will be populated in later stage in the table

        for (int strRow = 0; strRow <= text2.length(); strRow++) { // i am using here <= as i have added 1 additional row and column
            for (int strCol = 0; strCol <= text1.length(); strCol++) {
                if (strRow == 0 || strCol == 0) { // cannot use "&&" as for 1st row the col increments , u can see the 2nd for loop
                    cache[strRow][strCol] = 0;
                }

                else if (text2.charAt(strRow - 1) == text1.charAt((strCol - 1))) { // here why strRow - 1 and strCol - 1 coz, no matter we have had increased a row and column, but
                    // need to start comparing the character from string's 0th index.
                    // if equal we say both the characters from String text2 and text1 are same, so we need to slash the last characters from both the string, and take the new Left over
                    // String as two new string and compute on those, so what are we doing here is breaking a problem in to sub problems, in other words following bottom up approach

                    cache[strRow][strCol] = 1 + cache[strRow - 1][strCol - 1]; // here 1+ states that the both the characters from text2 and text1 matches directly, and cache[strRow - 1][strCol - 1]
                    // is nothing but as we said we are slashing last string character from both the string text2 and text1, to do in the table representation we are slashing row by 1 , i mean we
                    // are moving a 1 row up, and when we slashed last character from text1, as we know text1 will behave as a column, we decrease the column from the same pointer by 1.
                    // and when we do cache[strRow - 1][strCol - 1], we know that the data would have been populated for the prev row index and prev Column in table.

                }

                else {
                    cache[strRow][strCol] = Math.max(cache[strRow - 1][strCol], cache[strRow][strCol - 1]); // here if both the last characters from string text2 and text1
                    // does not match directly, so there will be two possibily, either decrease text1 (i.e., 1 col towards left) and keep the newly obtained text2 as it is or
                    // either decrease last character of text2 i.e., row by slashing one last character, just to check if there's a possibility to match the character of text1 now.

                    // so we take the maximum of both after there computation.
                }
            }

        }
        return cache[text2.length()][text1.length()]; // the last indexes of cache is LCS integer
    }
}
