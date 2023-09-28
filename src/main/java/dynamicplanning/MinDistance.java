package dynamicplanning;

/**
 * @Author: suruomo
 * @Date: 2021/7/28 12:59
 * @Description: 72 最短编辑距离
 * 给定两个字符串str1和str2，再给定三个整数ic，dc和rc，分别代表插入、删除和替换一个字符的代价，
 * 请输出将str1编辑成str2的最小代价。
 */
public class MinDistance {
    public int minEditCost (String str1, String str2, int ic, int dc, int rc) {
        int m = str1.length();
        int n = str2.length();
        //初始化dp[0][i]与dp[i][0]
        int[][] dp = new int[m+1][n+1];
        for(int i = 1;i <= m;i++){
            dp[i][0] = i*dc;
        }
        for(int i = 1;i <= n;i++){
            dp[0][i] = i*ic;
        }
        //开始遍历
        for(int i = 1;i <= m;i++){
            char c1 = str1.charAt(i-1);
            for(int j = 1;j <= n;j++){
                char c2 = str2.charAt(j-1);
                if(c1 == c2){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    //分类讨论，找到最小代价
                    // 1.插入：将i个字符串转变为前j-1个字符串在插入第j个字符->dp[i][j-1]+ic
                    // 2.删除：将i-1个字符串转换为前j个字符串删除第i个字符->dp[i-1][j]+dc
                    // 3.替换：将i-1个字符串转换为前j-1个字符串替换掉第i个字符为第j个字符->dp[i-1][j-1]+rc
                    int insert = dp[i][j-1] + ic;
                    int delete = dp[i-1][j] + dc;
                    int replace = dp[i-1][j-1] + rc;
                    dp[i][j] = Math.min(replace,Math.min(delete,insert));
                }
            }
        }
        return dp[m][n];
    }
}
