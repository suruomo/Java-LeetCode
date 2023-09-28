package slidingwindow;

/**
 * @Author: suruomo
 * @Date: 2021/8/16 10:50
 * @Description: 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums==null||nums.length==0){
            return 0;
        }
        int ans=Integer.MAX_VALUE;
        int left=0;
        int temp=0;
        for (int right = 0; right < nums.length; right++) {
            temp+=nums[right];
            while (temp>=target){
                ans=Math.min(ans,right-left+1);
                temp-=nums[left++];
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}
