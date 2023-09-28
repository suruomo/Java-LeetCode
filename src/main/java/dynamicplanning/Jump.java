package dynamicplanning;

import java.util.Arrays;

/**
 * @Author: suruomo
 * @Date: 2021/8/16 16:10
 * @Description: 45. 跳跃游戏 II
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 */
public class Jump {
    public int jump(int[] nums) {
     //设dp[i]表示到第i个位置需要的步数，则
        int len=nums.length;
        if(len<3) {
            return len-1;
        }
        int[] dp=new int[len];
        Arrays.fill(dp,len);
        dp[0]=0;
        for(int i=0;i<len;i++)
        {
            for(int j=1;j<=i+nums[i] && j<len;j++){
                dp[j]=Math.min(dp[i]+1,dp[j]);
                if(j==len-1) {
                    return dp[len-1];
                }
            }
        }
        return dp[len-1];
    }
}
