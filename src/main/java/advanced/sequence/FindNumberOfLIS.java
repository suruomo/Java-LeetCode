package advanced.sequence;

import java.util.Arrays;

/**
 * @Author: suruomo
 * @Date: 2021/7/29 10:43
 * @Description: 673. 最长递增子序列的个数
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 */
public class FindNumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return 1;
        }

        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int maxLength = 0;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }else if(dp[j] + 1 == dp[i]){
                        count[i] += count[j];
                    }
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        int res = 0;
        for(int i = 0; i < n; i++){
            if(dp[i] == maxLength){
                res += count[i];
            }
        }
        return res;
    }
}
