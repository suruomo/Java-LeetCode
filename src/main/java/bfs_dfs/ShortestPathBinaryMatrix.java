package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: suruomo
 * @Date: 2021/8/20 10:18
 * @Description: 1091. 二进制矩阵中的最短路径
 * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
 *
 * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
 *
 * 路径途经的所有单元格都的值都是 0 。
 * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
 * 畅通路径的长度 是该路径途经的单元格总数。
 */
public class ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
        int[] dy = {0, 1, -1, 1, -1, 0, 1, -1};
        if (grid == null || grid.length == 0||grid[0][0]==1) {
            return -1;
        }
        int n = grid.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        // 表示走过了
        grid[0][0] = 1;
        int ans = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int index = queue.poll();
                int x = index / n;
                int y = index % n;
                if (x==n-1&&y==n-1){
                    return ans;
                }
                for (int i = 0; i < 8; i++) {
                    int newx = x + dx[i];
                    int newy = y + dy[i];
                    if (newx >= 0 && newx < n && newy >= 0 && newy < n && grid[newx][newy] == 0) {
                        grid[newx][newy] = 1;
                        queue.offer(newx * n + newy);
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
