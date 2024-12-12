package org.example.Graphs;

public class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // need to get the row length and col length
        int m = maze.length;
        int n = maze[0].length;

        boolean[][] isVisited = new boolean[m][n]; // need to use isVisited array to track the cell which we have visited already, if not it might be in an infinite loop

        // we will be using dfs approach, we will go deep in every cell amd we will only change direction if the cell  has the wall
        return dfs(m, n, maze, start, destination, isVisited);
    }

    public boolean dfs(int m , int n, int[][] maze, int[] curr, int[] destination, boolean[][] isVisited) {
        // curr is nothing is shows which cell we are currently in, at the very initiation the curr is nothing but the start, later the curr changes as the ball moves to other cell

        if (isVisited[curr[0]][curr[1]]) { // here i am taking [curr[0]][curr[1]], so in the question you'll be given as start which is size 2 array, now the data in start array
            // says the index , which can be used in 2d array, let's say start = {0,4} --> nothing 0th row and 4th column while representing in 2d array, similarly destination
            // array needs to read in same way.
            return false;
        }

        if (curr[0] == destination[0] && curr[1] == destination[1]) { // This condition is to say that we have reached to destination
            return true;
        }

        // so the above if condition is for the curr array index 0th and 1st, to check if i have already traversed this cell , if yes then return false

        isVisited[curr[0]][curr[1]] = true;

        // Now create two array dirnX[] to move along x-axis, dirnY[] to move along y-axis, this array contains direction top, right, bottom, left, we will be using this
        // during iteration to get the direction where the ball will be moving next

        int[] dirnX = {0, -1, 0, 1}; // here we move in xAxis, so if we say to move in x Axis , so can we say we move only left and right , hence 1st index 0 is for top, then
        // then 1 is for right, then again 0 is for bottom which is a yaxis movement then -1 is moving left

        int[] dirnY = {1, 0, -1, 0}; // this is a Yaxis movement so can we say we move top and bottom in yaxis

        // now we iterate in all the 4 directions
        for (int i = 0; i < 4; i++) {
            // initially at very first beginning r and c takes the position of start, later it changes
            int r = curr[0];
            int c = curr[1]; // here r and c decides the cells which cell the ball needs to move to

// Move the ball in the chosen direction until it can.
            while (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] == 0) { // now this is iterated until the cell with wall is encountered or cell boundary os exhausted, this
                // is done to know till what cell the ball can move in a direction before changing the direction
                r = r + dirnX[i];
                c = c + dirnY[i];
            }
            // once while loop is broken we need to reverse back the cell by doing r = r - dirnX[i] and c = c - dirnY[i], and see if there is any other direction which
            // hasn't been traversed already, and if found move the ball in that direction and again start the flow, so to achieve this i'll be calling the dfs recursively

            // Revert the last move to get the cell to which the ball rolls. and this will be the value of curr

            if (dfs(m, n, maze, new int[]{r - dirnX[i], c - dirnY[i]}, destination, isVisited)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = {0,4};
        int[] destination = {3,2};

        TheMaze theMaze = new TheMaze();
        boolean resFlag = theMaze.hasPath(maze, start, destination);
        System.out.println(resFlag);

    }
}
