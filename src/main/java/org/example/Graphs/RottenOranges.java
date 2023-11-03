package org.example.Graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 */
public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] visited = new int[m][n];

        Queue<Pair> q = new LinkedList<>();

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j= 0 ; j < n; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 2) {
                    q.add(new Pair(i,j,0)); // so why time as 0 , coz we need to find the number initially declared rotten oranges, and this can be found in 0 time,
                    // by iterating and looking for 2
                    visited[i][j] = 2; // soa s soon as you find rotten oranges which are rep as 2, once added in queue (indicating starting point) , need to change in
                    // visited array as well stating i have visited initially all the rotten oranges which was in question.
                }
                if (grid[i][j] == 1) {
                    count++; // counting how many number of fresh oranges are there, which needs to be rotten
                }
            }
        }

        // So now you have initial present rotten oranges added in queue, next step is to find its adjacent 4 direction fresh orange to rotten, and thats the reason
        // we need use one by one data from queue and find its adjacent 4 directional fresh oranges.

        int[] deltaRow = {-1,0,1,0}; // so this represents all the 4 side of row value ( e.g., row for up is +ve(row+1), next is right row is 0, next is bottom , row is -1 (row-1), and left row is again 0
        int[] deltaCol = {0,1,0,-1}; // similarly column
        int convCount = 0;
        int finalTimeTaken = 0;
        while(!q.isEmpty()) {
            int r = q.peek().row; // getting the data from the queue in FIFO manner and getting to know the row for that particular rotten orange
            int c = q.peek().col; // getting to know the col of that particular rotten orange, so that we can use as grid(row][col] and look for its 4 direction(up, right, left, bottom)
            int t = q.peek().time;// getting to know the time, so npw when i traverse to the every individual direction i need add as at next'h minute i found this orange to be getting rotten

            finalTimeTaken = Math.max(finalTimeTaken,t); // as t will be changing in the underneath code;

            q.poll(); // now the data is taken from the use of peek and all the process is done on that data, so remove ot from queue, so that we can go next data in the while loop.

            // now need to travel in 4 directions, so 4 time traversal hence i < 4
            for (int i = 0; i < 4; i++) {
                int nRow = r + deltaRow[i]; // this gives row value as per i val, for moving up, right, bottom and left
                int nCol = c + deltaCol[i];// this gives col value as per i val
                // so the combination of both [nRow][nCol] helps you to move in 4 direction one by one

                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && visited[nRow][nCol] == 0 && grid[nRow][nCol] == 1) { // check the edge cases and also checking for
                    // this dirn does grid contains fresh oranges, if it does then rot it. and also say that you belong to queue as well

                    q.add(new Pair(nRow, nCol, t + 1)); // so this line is to say that the adjacent fresh oranges which are found to be rotten has to be put in cue, i mean there row and col should be put in cue
                    // along with the time , and the should be said that this was next minute, from the previous one. So prev is 1 minute next will be in 1 + 1 min

                    visited[nRow][nCol] = 2;// and we are telling by changing the value in visited that, the fresh orange at this row and col value was rottened successfully
                    convCount++; // and this keeps count of conversion of fresh orange to rotten one
                }
            }
        }

        if (convCount == count) {
            return finalTimeTaken;
        }
        return -1;
    }

    public static void main(String[] args) {
        RottenOranges rt = new RottenOranges();
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(rt.orangesRotting(grid));
    }

}



class Pair {
    int row; // this is like source if you imagine as a graph written
    int col; // this is noting but destination
    int time;// why time coz we need to give them the answer as min time needed to rot all the adjacent oranges

    public Pair (int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }

}

// So the Intuition is
