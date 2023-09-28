package advanced.array_string;

/**
 * @Author: suruomo
 * @Date: 2021/8/4 10:17
 * @Description: 826. 安排工作以达到最大收益
 * 有一些工作：difficulty[i] 表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益。
 *
 * 现在我们有一些工人。worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。
 *
 * 每一个工人都最多只能安排一个工作，但是一个工作可以完成多次。
 *
 * 举个例子，如果 3 个工人都尝试完成一份报酬为 1 的同样工作，那么总收益为 $3。如果一个工人不能完成任何工作，他的收益为 $0 。
 *
 * 我们能得到的最大收益是多少？
 */
public class MaxProfitAssignment {
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int max=0;
        for(int k=0;k<worker.length;k++) {
            int maxProfit=0;
            for (int i = 0; i < difficulty.length; i++) {
                if (worker[k]>=difficulty[i]){
                    maxProfit=Math.max(maxProfit,profit[i]);
                }
            }
           max+=maxProfit;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] difficulty = {2,4,6,8,10};
        int[] profit = {10,20,30,40,50};
        int[] worker = {4,5,6,7};
        System.out.println(maxProfitAssignment(difficulty,profit,worker));
    }
}
