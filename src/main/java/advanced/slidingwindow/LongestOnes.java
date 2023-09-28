package advanced.slidingwindow;

/**
 * @Author: suruomo
 * @Date: 2021/8/6 9:48
 * @Description: 1004. 最大连续1的个数 III
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 *
 * 返回仅包含 1 的最长（连续）子数组的长度。
 */
public class LongestOnes {
    /**
     * 其实就是找一个最长子数组，其中0的数量不超过k个
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes(int[] nums, int k) {
        int N = nums.length;
        int res = 0;
        int left = 0, right = 0;
        int zeros = 0;
        while (right < N) {
            if (nums[right] == 0) {
                zeros ++;
            }
            while (zeros > k) {
                if (nums[left++] == 0) {
                    zeros --;
                }
            }
            res = Math.max(res, right - left + 1);
            right ++;
        }
        return res;

    }
}
