package advanced.array_string;

/**
 * @Author: suruomo
 * @Date: 2021/7/26 9:59
 * @Description: 1063. 有效子数组的数目
 * 给定一个子数组，返回满足下面条件的非空、连续子数组
 * 子数组中，最左侧的元素不大于其他元素
 * 输入：[1,4,2,5,3]
 * 输出：11
 * 解释：有 11 个有效子数组，分别是：[1],[4],[2],[5],[3],[1,4],[2,5],[1,4,2],[2,5,3],[1,4,2,5],[1,4,2,5,3] 。
 */
public class ValidSubArrays {
    public int validSubarrays(int[] nums) {
        int len=nums.length;
        int count=len;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (nums[j]>=nums[i]){
                    count++;
                }else {
                    break;
                }
            }
        }
        return count;
    }
}
