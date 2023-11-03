package org.example.DynamicProgramming;


/** This is similar to lowest common Subsequence problem , only difference is in else statement.
 utilise the video of https://www.youtube.com/watch?v=MiqoA-yF-0M

 ALso called Levenshtein Distance
 **/
public class EditDistance {
    public static int minDistance(String word1, String word2) {

        // taking word2 as row and taking word 1 as column
        int[][] edges = new int[word2.length() + 1][word1.length() + 1]; // taking +1 as i am adding additional row and additional column, and that will be 1st row and
        // 1st column taking string as EMpty String "" --> so the inputs , only for table, the row and column plotting will be like shown below with empty string

        //    | "" h o r s e
        //--------------------
        // "" |
        // r  |
        // o  |
        // s  |

        for (int strRow = 0; strRow <= word2.length(); strRow++) {
            int count = strRow;
            for (int strCol = 0; strCol <= word1.length(); strCol++) {
                if (strRow == 0 || strCol == 0) {
                    edges[strRow][strCol] = count++;// why count ++ , when we had added additional row of empty string "", now when the row is "" (empty string) and tyhe string1
                    // is horse with empty string at start (""horse) --> now if we want to convert "" to "" then we need to do nothing hence edge[0][0] = 0. Now if we want to convert
                    // h to "", we need to delete h so operation performed is delete hence edge[0][1] = 1, now consider substring "ho" now if we need to convert "ho" to "" empty string,
                    // we need to delete h and then delete o so total operation is 2, hence edge[0][2] = 2. Now consider substring "hor" --> converting to empty string "" --> operation requires
                    // 3 deletion hence edge[0][3] = 3. similarly for "hors" --> operation req to convert to empty string ("") is 4 deletion. and then "horse" , operation req to convert it to
                    //"" is 5 hence edge[0][5] = 5.
                    //Similarly when you take first column with the string including empty string (""ros)
                }
                else if (word2.charAt(strRow - 1) == word1.charAt(strCol - 1)) { // no matter we have increased the length for array by adding empty string as additional row and column
                    // but we need to check the character similarity of two strings from index 0 itself.
                    edges[strRow][strCol] = edges[strRow-1][strCol - 1];
                } else {
                    // here we know that chris crossing substring is not same
                    edges[strRow][strCol] = 1 + Math.min(Math.min(edges[strRow - 1][strCol], edges[strRow][strCol - 1]), edges[strRow - 1][strCol - 1]);
                    // here why 1+ because we are performing the operation so we are taking min between a kind of pattern delete ,replace and insertion
                }
            }
        }
        return edges[word2.length()][word1.length()];

    }

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(minDistance(word1, word2));
    }
}
