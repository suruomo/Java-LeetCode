package advanced.array_string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: suruomo
 * @Date: 2021/7/24 16:54
 * @Description: 163.缺失的区间
 * 给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。
 *
 * 示例：
 *
 * 输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
 * 输出: ["2", "4->49", "51->74", "76->99"]
 */
public class FindMissingRanges {
    public static void main(String[] args) {
        int[] nums={0, 1, 3, 50, 75};
        int lower=0,upper=99;
        System.out.println(findMissingRanges(nums,lower,upper));
    }
    public static List<String> findMissingRanges(int[] nums, int lower, int upper){
        List<String> ans=new ArrayList<>();
        if (nums==null||nums.length==0){
            ans.add(process(lower,upper));
            return ans;
        }
        // 处理头尾
        if (lower<nums[0]){
            ans.add(process(lower,nums[0]-1));
        }
        if (nums[nums.length-1]<upper){
            ans.add(process(nums[nums.length-1]+1,upper));
        }
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i]<nums[i+1]&&nums[i]!=nums[i+1]-1){
                ans.add(process(nums[i]+1,nums[i+1]-1));
            }
        }
        return ans;
    }

    /**
     * 区间处理
     * @param lower
     * @param upper
     * @return
     */
    private static String process(int lower, int upper) {
        if (lower==upper){
            return String.valueOf(lower);
        }else {
            return lower+"->"+upper;
        }
    }
}
