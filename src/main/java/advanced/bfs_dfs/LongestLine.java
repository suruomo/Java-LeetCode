package advanced.bfs_dfs;


/**
 * @Author: suruomo
 * @Date: 2021/7/24 15:40
 * @Description: 562. 矩阵中最长的连续1线段
 * 给定一个01矩阵 M，找到矩阵中最长的连续1线段。
 * 这条线段可以是水平的、垂直的、对角线的或者反对角线的。
 */
public class LongestLine {
    public static void main(String[] args) {
        int[][] matrix={
                {0,1,1,0},
                {0,1,1,0}
        };
        System.out.println(longestLine(matrix));
    }

    /**
     * 1.dfs
     * @param matrix
     * @return
     */
    public static int longestLine(int[][] matrix){
        int rows =matrix.length;
        int cols=matrix[0].length;
        int ans=0;
        for (int i = 0; i <rows; i++) {
            for (int j = 0; j < cols; j++) {
                    // 水平
                    int pingxing=dfs(matrix,i,j,0);
                    // 垂直
                    int chuizhi=dfs(matrix,i,j,1);
                    // 对角
                    int duijiao=dfs(matrix,i,j,2);
                    // 反对角
                    int fanduijiao=dfs(matrix,i,j,3);
                    ans=Math.max(ans,Math.max(pingxing,Math.max(chuizhi,Math.max(duijiao,fanduijiao))));
            }
        }
        return ans;
    }

    private static int dfs(int[][] matrix, int i, int j,int flag) {
        int rows =matrix.length;
        int cols=matrix[0].length;
        if (i<0||i>=rows||j<0||j>=cols||matrix[i][j]!=1){
            return 0;
        }
        switch(flag){
            case 0:
                return dfs(matrix, i, j+1,0)+1;
            case 1:
                return dfs(matrix, i+1, j,1)+1;
            case 2:
                return dfs(matrix, i+1, j+1,2)+1;
            case 3:
                return dfs(matrix, i+1, j-1,3)+1;
        }
        return 0;
    }

    /**
     * 2.动态规划
     * @param M
     * @return
     */
    public static int longestLine1(int[][] M){
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int ans = 0;
        // 四个方向数组
        int[][] horizontal = new int[M.length][M[0].length];
        int[][] vertical = new int[M.length][M[0].length];
        int[][] diagonal = new int[M.length][M[0].length];
        int[][] antidiagonal = new int[M.length][M[0].length];
        for (int i = 0; i != M.length; ++i) {
            for (int j = 0; j != M[0].length; ++j) {
                if (M[i][j] == 0) {
                    horizontal[i][j] = 0;
                    vertical[i][j] = 0;
                    diagonal[i][j] = 0;
                    antidiagonal[i][j] = 0;
                } else {
                    // 分别讨论
                    horizontal[i][j] = j > 0 ? horizontal[i][j - 1] + 1 : 1;
                    vertical[i][j] = i > 0 ? vertical[i - 1][j] + 1 : 1;
                    diagonal[i][j] = i > 0 && j > 0 ? diagonal[i - 1][j - 1] + 1 : 1;
                    antidiagonal[i][j] = i > 0 && j < M[0].length - 1 ? antidiagonal[i - 1][j + 1] + 1 : 1;
                    // 取四种情况最大值
                    ans = Math.max(ans, horizontal[i][j]);
                    ans = Math.max(ans, vertical[i][j]);
                    ans = Math.max(ans, diagonal[i][j]);
                    ans = Math.max(ans, antidiagonal[i][j]);
                }
            }
        }
        return ans;
    }

}
