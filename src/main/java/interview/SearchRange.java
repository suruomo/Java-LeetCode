package interview;

/**
 * @author suruomo
 * @date 2020/8/8 15:10
 * @description: 34 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回[-1, -1]。
 *
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    /**
     * 当lower==true时查找左边界，第一个大于等于target
     * 当lower==false时查找右边界，第一个大于target的下标减一
     * @param nums
     * @param target
     * @param lower
     * @return
     */
    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 方法二
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange1(int[] nums, int target) {
         //先找>=target的第一个
        //再找>target的第一个
        //我真是这辈子都不想看见这题
        int l=search(nums,target);
        int r=search(nums,target+1);
        if(l==nums.length||nums[l]!=target)
            return new int[]{-1,-1};
        return new int[]{l,r-1};
    }
    //找>=target的第一个
    public int search(int[] nums,int target){
        int l=0,r=nums.length;
        while(l<r){
            int mid=(r+l)>>1;
            if(nums[mid]>=target)
                r=mid;
            else
                l=mid+1;
        }
        return l;
    }
}
