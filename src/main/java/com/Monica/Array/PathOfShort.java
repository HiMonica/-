package com.Monica.Array;

/**
 * 最小路径和
 */
public class PathOfShort {

    /**
     * 思路：动态规划，既然是找最左边到最右边最小的，那么我从最右边开始找，路径是
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < column; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][column - 1];
    }

    public static void main(String[] args) {
        PathOfShort pathOfShort = new PathOfShort();
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int i = pathOfShort.minPathSum(grid);
        System.out.println(i);
    }
}
