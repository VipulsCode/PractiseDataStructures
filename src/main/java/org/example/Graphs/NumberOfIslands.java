package org.example.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public static class Edge {
        int source;
        int destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    public static int numIslands(char[][] grid) {
        int m = grid.length; // row length
        int n = grid[0].length; // col length

        int[][] isVisited = new int[m][n]; // if the Aij = 0 , the index is not visited yet, if Aij = 1 it's visited already

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isVisited[i][j] == 0 && grid[i][j] == '1') {
                    getTheNumsIslandUsingBFS(grid, isVisited, i, j);
                    count++;
                    /** So Now the count goes ++ only when the above condition satisfies, so if there's broken graph , or if 1
                     * in grid matrix is at last index and we need to check if it's an island or not, as it's not fully connected graph,
                     * we only call the method getTheNumsIslandUsingBFS if it's not traced, so the number of times its called is an answer for number of island present.
                     */
                }
            }
        }
        return count;
    }

    public static void getTheNumsIslandUsingBFS(char[][] grid, int[][] isVisited, int row, int col) {
        isVisited[row][col] = 1;
        Queue<Edge> q = new LinkedList<>();
        q.add(new Edge(row, col));

        int m = grid.length;
        int n = grid[0].length;

        while (!q.isEmpty()) {
            int ro = q.peek().source;
            int co = q.peek().destination;

            q.poll();

            // Now the part is to move from the place where we are standing to upward direction, and then downward direction (vertically),
            // left and right side as well(horizontally) to check whether the adjacent values is land or water, to make it as a island
            // so when you move up = (row +1 , col),  down = (row -1, col), left = (row, col-1), right = (row, col + 1), so it can be seen that
            // the movement is from -1 to +1 (generally), so we take a simple way to make sure the point where we are standing moves to all the
            // directions and checks is adjacent is 1 or 0. we take deltaRow ranging from -1 to 1 , and similarly deltaColumn ranging from -1 to 1.

            for (int rowDelta = -1; rowDelta <= 1; rowDelta++) {
                for (int colDelta = -1; colDelta <= 1; colDelta++) {
                    if ((rowDelta == -1 && colDelta == -1) || (rowDelta == -1 && colDelta == 1) || (rowDelta == 1 && colDelta == -1) ||
                            (rowDelta == 1 && colDelta == 1)) {
                        continue;
                    }
                    int newRow = ro + rowDelta; // This gives the new computed row'th index to check
                    int newCol = co + colDelta; // This gives the new computed columth index to check

                    // So the below if condition also checks the boundaries of newRow and newCol, such that it's not negative or index val
                    // shouldn't be more than grid length for row and column. And we only add in Queue , if the traversed data we find as 1, no need to add 0 in queue.
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                    grid[newRow][newCol] == '1' && isVisited[newRow][newCol] == 0) {
                        isVisited[newRow][newCol] = 1;
                        q.add(new Edge(newRow, newCol));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println("The number is " +numIslands(grid));
    }


}
