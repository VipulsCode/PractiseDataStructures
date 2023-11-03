package org.example.Sets;

import java.util.HashSet;

public class ValidSudoku {

    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {

         /*since we need to check that neither the current row nor the current column nor the 3*3 sub box with in the grid should have duplicates
         from 1 to 9 numbers, we can say we are dealing with uniqueness
         so we can use HashSet , to make sure that there's no duplicates as HashSet does not allow duplicates,
         and also keep a track, if the data is already added in Hash set or not*/

        HashSet<String> set = new HashSet<>();
        // why String as we will keep the tracks in terms of string, you'll get to know as you follow the code

        char currentVal;

        for(int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                currentVal = board[i][j];

                if (board[i][j] != '.') {

                /*     the below addition should only be done if the condition satisfies
                     now we know that the HashSet return boolean while we add anything to it, it returns true and adds the data in it, if the data isn't
                     existing already, if the data is already present the hashSet returns FALSe, now we will use this logic for underneath if condition.*/


                    if (!set.add(currentVal +" in Row number " + i) // this is to check if there's any duplicate in the pointed row
                            || !set.add(currentVal + " in Column number " + j) // this is to check if there's any duplicate in the pointed column
                            || !set.add(currentVal + " in the SubBox " + i/3 + "-" + j/3)) { // this is to check if there's any duplicate value in the current sub box

                        /*EXPLANATION ABT --> i/3 + "-" + j/3 --> this gives the current box in form 0f 0 - 0, 0 - 1
                         box ( here 0 is first 3 rows, and data followed by - is box
                         number like 0th box, in 0th row 2nd box and so on.) why divide 3 coz the question says the sub box are 3*3.*/


                        // so we are saying if this string data is already present in //HashSet that means there is/are duplicate('s), when there is/are
                        // duplicate('s) as per question just return false.

                        return false;
                    }
                }

            }
        }
        return true;

    }
}
