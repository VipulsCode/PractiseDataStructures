package org.example.Graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** PROBLEM STATEMENT - LEET CODE 130
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example 1:
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * Explanation: Notice that an 'O' should not be flipped if:
 * - It is on the border, or
 * - It is adjacent to an 'O' that should not be flipped.
 * The bottom 'O' is on the border, so it is not flipped.
 * The other three 'O' form a surrounded region, so they are flipped.
 */

public class SurroundedRegions {

    public static void main(String[] args) {
        char[][] board = {{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
        flipTheZerosToX(board);
        System.out.println(Arrays.deepToString(board));

    }

    public static void flipTheZerosToX(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] visited = new int[m][n];

        // Trace out all the 4 edges of the matrix does any edge contain 'O'
        // to do so first we trace out top row and bottom row of the matrix board, by this 2 edges will be covered

        for (int j = 0; j < n; j++) { // now why choose j , coz 1st row i is always constant i.e., 00, 01 ,02, 03....
            // Tracing 1st row
            if (visited[0][j] == 0 && board[0][j] == 'O') {

                dfs(board, 0,j, visited); // this step is coz, while tracing if we find O at any index of the 1st row,
                // then we need to also find, if there's any adjacent 'O' to the edged 'O', as per quest, even adjacent 'O' to the edged cannot be flipped to X
            }

            //Tracing Last row, to chec if there's any edge containing 'O'

            if (visited[m-1][j] == 0 && board[m-1][j] == 'O') {
                dfs(board, m-1, j, visited);
            }
        }

        // Trace out the columns (1st and last column) as well now, to find of there's any 'O' at any of the edge

        for (int i = 0; i < m; i++) { // npw why i, coz for the 1st column the j remain constant 00, 10, 20, 30... similarly for last column
            // 0 m-1, 1 m-1, 2 m-1,....

            // 1st column iteration to find, if there's any 'O' in the edge
            if (visited[i][0] == 0 && board[i][0] == 'O') {// this condition asks to only go in search for the edge 0 and it's adjacent if the condn satisfies
                dfs(board, i, 0, visited);
            }

            // last column iteration to find, if there's any 'O' in the edge
            if (visited[i][n-1] == 0 && board[i][n-1] == 'O') {
                dfs(board, i, n-1, visited);
            }
        }

        // By Now the edges with 'O' are found and also the adjacent 'O' would have also been found through dfs and, the visited matrix
        // would have been marked by 1, at the same index of edged 'O' and it's adjacent, but in visited matrix.

        // Now it's time to fip left over 'O' which werent marked visited to flip to 'X'

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void dfs(char[][] board, int row, int col, int[][] visited) {
        int m = board.length;
        int n = board[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col] == 1 || board[row][col] != 'O') {
            return;
        }
        visited[row][col] = 1;

        dfs(board, row - 1, col, visited); // looking for the adjacent on TOP
        dfs(board, row, col + 1, visited); // looking for the adjacent at the right
        dfs(board, row + 1, col, visited);// looking for the adjacent at bottom
        dfs(board, row, col - 1, visited);// looking for the adjacent at left
    }

}
