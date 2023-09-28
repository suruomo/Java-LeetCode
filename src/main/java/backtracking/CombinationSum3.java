package backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: suruomo
 * @Date: 2020/9/11 9:52
 * @Description: 216 组合总和3
 * 找出所有相加之和为 n 的 k 个数的组合。
 * 组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 */
public class CombinationSum3 {
    public static void main(String[] args) {
        int k=3;
        int n=7;
        System.out.println(combinationSum3(k,n));
    }

    private static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        backtrack(k,n,1,ans,path);
        return ans;
    }

    /**
     * 方法一
     * @param k
     * @param n
     * @param cur 当前数字
     * @param ans
     * @param path
     */
    private static void backtrack(int k, int n, int cur, List<List<Integer>> ans, List<Integer> path) {
        if(k==0&&n==0){
            ans.add(new ArrayList<>(path));
            return;
        }
        if (cur>9||cur>n||n>45){
            return;
        }
        // 1.选当前数字
        path.add(cur);
        backtrack(k-1,n-cur,cur+1,ans,path);
        path.remove(path.size()-1);
        // 2.不选当前
        backtrack(k,n,cur+1,ans,path);
    }

    /**
     * 方法二
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum31(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();//存储根节点开始的路径
        dfs3(1, k, path, n, res);
        return res;
    }

    /**
     *
     * @param begin 当前索引
     * @param k
     * @param path
     * @param target 目标和
     * @param res
     */
    public  void dfs3(int begin, int k, Deque<Integer> path, int target, List<List<Integer>> res) {
        // 1.结束条件
        if (target == 0 && path.size() == k) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        // 2.选择列表
        for (int i = begin; i < 10; i++) {
            // 大剪枝
            if (target - i < 0) {
                return;
            }
            // 选择
            path.addLast(i);
            // 递归
            dfs3(i + 1, k, path, target - i, res);
            // 撤销选择
            path.removeLast();
        }
    }
}
