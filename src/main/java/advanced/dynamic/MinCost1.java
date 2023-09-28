package advanced.dynamic;

/**
 * @Author: suruomo
 * @Date: 2021/8/3 11:24
 * @Description: 265. 粉刷房子 II
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成 k 种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 *
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n*k 的矩阵来表示的。
 *
 * 例如，costs[0][0] 表示第 0 号房子粉刷成 0 号颜色的成本花费；
 * costs[1][2] 表示第 1 号房子粉刷成 2 号颜色的成本花费，以此类推。请你计算出粉刷完所有房子最少的花费成本。
 */
public class MinCost1 {
    /**
     * 1.常规解法，会超时
     * @param costs
     * @return
     */
    public static int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }
        // 房子个数
        int m=costs.length;
        // 颜色个数
        int n=costs[0].length;
        int[][] dp=new int[m][n];
        // 初始化
        for (int i = 0; i < n; i++) {
            dp[0][i]=costs[0][i];
        }
        // 遍历房子
        for (int i = 1; i < m; i++) {
            // 遍历当前房子的每种颜色
            for (int j = 0; j < n; j++) {
                int min=Integer.MAX_VALUE;
                // 遍历前一个房子的k个颜色的消耗，找到不包括当前房子颜色的最小值。
                for (int k = 0; k < n; k++) {
                    if (k!=j){
                        min=Math.min(min,dp[i-1][k]);
                    }
                }
                dp[i][j]=min+costs[i][j];
            }
        }
        int ans=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans=Math.min(ans,dp[m-1][i]);
        }
        return ans;
    }
    public static int minCostII1(int[][] costs) {
        if(costs==null || costs.length==0) {
            return 0;
        }
        if(costs[0].length==1) {
            return costs[0][0];
        }
        //创建dp数组并进行初始化
        int m = costs.length;
        int n = costs[0].length;
        int[][] dp = new int[m+1][n];
        //进行计算
        for(int i=1; i<=m; i++){//对于第i个房子
            // 记录值
            int minValue = Integer.MAX_VALUE;
            int secMinValue = Integer.MAX_VALUE;
            // 记录下标
            int minIndex =-1;
            int secMinIndex = -1;
            for(int j=0; j<n; j++){//对于第j种颜色
                if(dp[i-1][j]<minValue){
                    secMinValue = minValue;
                    minValue = dp[i-1][j];
                    secMinIndex = minIndex;
                    minIndex = j;
                }
                else if(dp[i-1][j]<secMinValue){
                    secMinValue = dp[i-1][j];
                    secMinIndex = j;
                }
            }
            for(int j=0; j<n; j++){
                dp[i][j] = (j==minIndex?secMinValue:minValue) +costs[i-1][j];
            }
        }
        //返回最小值
        int res = Integer.MAX_VALUE;
        for(int k=0; k<n; k++){
            res = Math.min(res,dp[costs.length][k]);
        }
        return res;

    }

    public static void main(String[] args) {
        int[][] costs={{1,5,3},{2,9,4}};
        System.out.println(minCostII1(costs));
    }
}
