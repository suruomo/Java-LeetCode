import java.util.Arrays;

/**
 * @author: suruomo
 * @date: 2021/3/24 10:29
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        int[] nums={10,1,2,5,8,7,3,0,4,6,9};

    }

    public int lengthOfLIS(int[] nums) {
        int length=nums.length;
        int[] dp=new int[length];
        dp[0]=1;
        int maxDepth=0;
        for (int i = 1; i < length; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxDepth=Math.max(maxDepth,dp[i]);
        }
        return maxDepth;
    }


}
