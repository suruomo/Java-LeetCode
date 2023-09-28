package advanced.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: suruomo
 * @Date: 2021/8/9 10:21
 * @Description: 1245. 树的直径
 * 给你这棵「无向树」，请你测算并返回它的「直径」：这棵树上最长简单路径的 边数。
 *
 * 我们用一个由所有「边」组成的数组 edges 来表示一棵无向树，其中 edges[i] = [u, v] 表示节点 u 和 v 之间的双向边。
 *
 * 树上的节点都已经用 {0, 1, ..., edges.length} 中的数做了标记，每个节点上的标记都是独一无二的。
 * 输入：edges = [[0,1],[0,2]]
 * 输出：2
 * 解释：这棵树上最长的路径是 1 - 0 - 2，边数为 2。
 */
public class TreeDiameter {
    public int treeDiameter(int[][] edges) {
        // 节点数
        int points=edges.length+1;
        // 邻接表存储节点之间关系
        List<ArrayList<Integer>> list=new ArrayList<>();
        for(int[] edge:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        // 最长直径节点数
        int ans=0;
        for (int i = 0; i < points; i++) {
            // 最长的路径的端点的度一定为1，这样能去掉不必要的DFS
            if (list.get(i).size()==1){
                ans=Math.max(ans,dfs(list,-1,i));
            }
        }
        // 返回的是边数应该是节点数减一
        return ans-1;
    }

    /**
     * 深度优先搜索：返回当前节点下的最大节点数
     * @param list
     * @param pre 先驱节点
     * @param cur 当前节点
     * @return
     */
    private int dfs(List<ArrayList<Integer>> list, int pre, int cur) {
        int ans=0;
        // 获取当前节点相连的所有节点
        List<Integer> list1=list.get(cur);
        for (int i = 0; i < list1.size(); i++) {
            int next=list1.get(i);
            if (next!=pre){
                ans=Math.max(ans,dfs(list,cur,next));
            }
        }
        // 加上当前节点
        return ans+1;
    }
}
