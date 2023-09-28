package bfs_dfs;

/**
 * @Author: suruomo
 * @Date: 2021/8/5 15:06
 * @Description: 695. 岛屿的最大面积
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 *
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 *
 *
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int ans=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j]==1){
                    ans=Math.max(ans,dfs(grid,i,j));
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==0){
            return 0;
        }
        grid[i][j]=0;
        int ans=1;
        ans+=dfs(grid,i-1,j);
        ans+=dfs(grid,i+1,j);
        ans+=dfs(grid,i,j-1);
        ans+=dfs(grid,i,j+1);
        return ans;
    }
}
