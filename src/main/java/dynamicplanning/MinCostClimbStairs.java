package dynamicplanning;

/**
 * 问题：最小花费爬楼梯
 * @author 苏若墨
 * 746. 使用最小花费爬楼梯
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 *
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 */
public class MinCostClimbStairs {
    public static void main(String[] args) {
        int[] cost={5,2,56,3,45,21,4};
        System.out.println("最小花费是："+minCostClimbingStairs(cost));
    }

    private static int  minCostClimbingStairs(int[] cost) {
        int a=0;
        int b=0;
        for(int i=0;i<cost.length;i++){
            int cur=cost[i]+Math.min(a,b);
            a=b;
            b=cur;
        }
        return Math.min(a,b);
    }

    public int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        int prev = 0, curr = 0;
        for (int i = 2; i <= n; i++) {
            int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        // dp[i] 表示达到下标 i 的最小花费
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }

}
