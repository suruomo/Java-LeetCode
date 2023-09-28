package bfs_dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: suruomo
 * @Date: 2021/8/20 10:34
 * @Description: 797. 所有可能的路径
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 *
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。
 *
 * 译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a 。
 */
public class AllPathsSourceTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        if (graph.length == 0) {
            return res;
        }
        dfs(graph, 0, new ArrayList<Integer>(), res);
        return res;
    }

    /**
     * dfs
     * @param graph
     * @param curr 当前遍历节点
     * @param list 遍历路径
     * @param res 结果集
     */
    public void dfs(int[][] graph, int curr, List<Integer> list, List<List<Integer>> res){
        list.add(curr);
        if (curr == graph.length-1){
            res.add(new ArrayList<Integer>(list));
        }
        for (int i : graph[curr]){
            dfs(graph, i, list, res);
        }
        list.remove(list.size()-1);
    }
}
