package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: suruomo
 * @date: 2021/8/7 11:16
 * @description: 542. 01 矩阵
 * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，
 * 其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 */
public class UpdateMatrix {
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    public int[][] updateMatrix(int[][] mat) {
        if (mat==null||mat.length==0){
            return mat;
        }
        int rows=mat.length;
        int cols=mat[0].length;
        boolean[][] visited=new boolean[rows][cols];
        Queue<int[]> queue=new LinkedList();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j]==0){
                    queue.offer(new int[]{i,j});
                    visited[i][j]=true;
                }
            }
        }
        while (!queue.isEmpty()){
            int[] point=queue.poll();
            int x=point[0];
            int y=point[1];
            for (int i = 0; i < 4; i++) {
                int newx=x+dx[i];
                int newy=y+dy[i];
                if (newx>=0&&newx<rows&&newy>=0&&newy<cols&&!visited[newx][newy]){
                    mat[newx][newy]=mat[x][y]+1;
                    queue.offer(new int[]{newx,newy});
                    visited[newx][newy]=true;
                }
            }
        }
        return mat;
    }


}
