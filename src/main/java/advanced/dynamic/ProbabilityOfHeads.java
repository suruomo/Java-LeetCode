package advanced.dynamic;

/**
 * @Author: suruomo
 * @Date: 2021/7/24 15:30
 * @Description: 1230 抛硬币
 * 有一些不规则的硬币。在这些硬币中，prob[i] 表示第 i 枚硬币正面朝上的概率。
 *
 * 请对每一枚硬币抛掷 一次，然后返回正面朝上的硬币数等于 target 的概率。
 *
 * 示例 1：
 * 输入：prob = [0.4], target = 1
 * 输出：0.40000
 */
public class ProbabilityOfHeads {
    public double probabilityOfHeads(double[] prob, int target) {
        int len=prob.length;
        // dp[i][j]表示前i个硬币向上数量为j的概率
        int[][] dp=new int[len+1][target+1];
        dp[0][0]=1;
        for (int i = 1; i <=len; i++) {
            for (int j = 1; j <=target; j++) {
                // 当前硬币两种情况
                dp[i][j]= (int) (dp[i-1][j-1]*prob[i-1]+dp[i-1][j]*(1-prob[i-1]));
            }
        }
        return dp[len][target];
    }
}
