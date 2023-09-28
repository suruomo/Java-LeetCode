package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: suruomo
 * @Date: 2021/8/20 11:02
 * @Description: 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
public class SubsetsWithDup {
    int n=0;
    int k=0;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        boolean[] visited=new boolean[n];
        Arrays.sort(nums);
        find(nums,ans,new ArrayList(),visited,0);

        return ans;
    }

    private void find(int[] nums, List<List<Integer>> ans, ArrayList path,boolean visited[],int index) {
        ans.add(new ArrayList<>(path));
        if (index>=nums.length){
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i>0&&nums[i-1]==nums[i]&&!visited[i-1]){
                continue;
            }
            path.add(nums[i]);
            visited[i]=true;
            find(nums, ans, path, visited, i+1);
            visited[i]=false;
            path.remove(path.size()-1);
        }
    }
}
