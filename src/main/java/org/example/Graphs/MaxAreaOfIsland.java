package org.example.Graphs;

public class MaxAreaOfIsland {
    int maxCount = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] visited = new int[m][n];
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 1) {
                   int totalArea = getTheMaxAreaOdIsland(grid, visited, i, j);
                    maxArea = Math.max(maxArea, totalArea);
                }
            }
        }
        return maxArea;
    }

    public int getTheMaxAreaOdIsland(int[][] grid, int[][] visited, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] == 1 || grid[row][col] == 0) {
            return 0;
        }

        visited[row][col] = 1; // here do not do count++ , as to get total area we need to add all the direction + position where we are standing

        int rightDir = getTheMaxAreaOdIsland(grid, visited, row, col + 1);
        int leftDir = getTheMaxAreaOdIsland(grid, visited, row, col - 1);
        int upwards = getTheMaxAreaOdIsland(grid, visited, row - 1, col);
        int downwards = getTheMaxAreaOdIsland(grid, visited, row + 1, col);

        int total = 1 + rightDir + leftDir + upwards + downwards; // Now why 1 + coz you are standing at 1 , and you are moving in all the direction,
        // to check if you have adjacent lands or not, i mean if you have 1 or not, so ypu covered up all the dirn, the place which u are standing should be included as well in an area.

        return total;
    }

    public static void main(String[] args) {
        int[][] grid= {{0,0,1,0,0,0,0,1,0,0,0,0,0}};
        MaxAreaOfIsland mx = new MaxAreaOfIsland();
        System.out.println( mx.maxAreaOfIsland(grid));
    }
}
