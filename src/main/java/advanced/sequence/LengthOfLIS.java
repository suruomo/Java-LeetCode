package advanced.sequence;

/**
 * @Author: suruomo
 * @Date: 2021/7/29 9:48
 * @Description: 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int len=nums.length;
        int[] dp=new int[len];
        dp[0]=1;
        int maxLength=0;
        for (int i = 1; i < len; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxLength=Math.max(maxLength,dp[i]);
        }
        return maxLength;
    }
}
