package slidingwindow;

/**
 * @Author: suruomo
 * @Date: 2021/8/16 10:08
 * @Description: 713. 乘积小于K的子数组
 * 给定一个正整数数组 nums和整数 k 。
 *
 * 请找出该数组内乘积小于 k 的连续的子数组的个数。
 */
public class NumSubarrayProductLessThanK {
    /**
     * 本题有这样一个规律：窗口内每加入一个数，如果乘积仍然小于k，则 满足条件的子数组数量 += 窗口内元素数量
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left++];
            }
            ans += right - left + 1;
        }
        return ans;
    }
}
