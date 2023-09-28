package advanced.array_string;

/**
 * @Author: suruomo
 * @Date: 2021/7/29 11:12
 * @Description: 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int len=nums.length;
        int[] max=new int[len];
        int[] min=new int[len];
        max[0]=nums[0];
        min[0]=nums[0];
        int ans=max[0];
        for (int i = 1; i < len; i++) {
            max[i]=Math.max(max[i-1]*nums[i],Math.max(nums[i],nums[i]*min[i-1]));
            min[i]=Math.min(min[i-1]*nums[i],Math.min(nums[i],nums[i]*max[i-1]));
            ans=Math.max(ans,max[i]);
        }
        return ans;
    }
}
