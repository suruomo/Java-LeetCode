package backtracking;


import java.util.ArrayList;
import java.util.List;

/**
 * @author: suruomo
 * @date: 2020/9/16 9:40
 * @description: 78 子集 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 */
public class Subsets {
    List<List<Integer>> output = new ArrayList();
    int n, k;

    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        // if the combination is done
        if (curr.size() == k) {
            output.add(new ArrayList(curr));
        }

        for (int i = first; i < n; ++i) {
            // add i into the current combination
            curr.add(nums[i]);
            // use next integers to complete the combination
            backtrack(i + 1, curr, nums);
            // backtrack
            curr.remove(curr.size() - 1);
        }
    }

    /**
     * 方法一
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        for (k = 0; k < n + 1; ++k) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return output;
    }

    /**
     * 方法二
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets1(int[] nums) {
        n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        find(nums,ans,new ArrayList(),0);

        return ans;
    }

    private void find(int[] nums, List<List<Integer>> ans, ArrayList path,int index) {
        ans.add(new ArrayList<>(path));
        if (index>=nums.length){
            return;
        }
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            find(nums, ans, path, i+1);
            path.remove(path.size()-1);
        }
    }
}
