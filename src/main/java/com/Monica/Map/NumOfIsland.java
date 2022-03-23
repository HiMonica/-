package com.Monica.Map;

/**
 * 岛屿数量
 */
public class NumOfIsland {

    /**
     * dfs遍历的时候遍历到跟自身是一个岛屿的就变为0，这样就不会重复取遍历一个相同的岛屿，相当于把岛屿缩小了
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        int num_island = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1'){
                    num_island++;
                    dfs(grid,i,j);
                }
            }
        }
        return num_island;
    }

    //dfs，r为行，c为列
    public void dfs(char[][] grid,int r,int c){
        //行
        int row = grid.length;
        //列
        int column = grid[0].length;
        if (r < 0 || c < 0 || r >= row || c >= column || grid[r][c] == '0'){
            return;
        }
        //将改位置至为0
        grid[r][c] = '0';
        //左边遍历
        dfs(grid,r - 1,c);
        //右边遍历
        dfs(grid,r + 1,c);
        //上边遍历
        dfs(grid,r,c - 1);
        //下边遍历
        dfs(grid,r,c + 1);
    }
}
