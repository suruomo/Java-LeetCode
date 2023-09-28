package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: suruomo
 * @Date: 2021/8/5 14:39
 * @Description: 733. 图像渲染
 * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 *
 * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
 *
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 *
 * 最后返回经过上色渲染后的图像。
 */
public class FloodFill {
    /**
     * 1.dfs
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image==null||image.length==0){
            return image;
        }
        int color=image[sr][sc];
        dfs(image,sr,sc,color,newColor);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int color, int newColor) {
        if (i<0||i>=image.length||j<0||j>=image[0].length||image[i][j]!=color){
            return;
        }
        image[i][j]=newColor;
        dfs(image,i-1,j,color,newColor);
        dfs(image,i,j-1,color,newColor);
        dfs(image,i+1,j,color,newColor);
        dfs(image,i,j+1,color,newColor);

    }

    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    /**
     * 2.bfs
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor == newColor) {
            return image;
        }
        int n = image.length, m = image[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == currColor) {
                    queue.offer(new int[]{mx, my});
                    image[mx][my] = newColor;
                }
            }
        }
        return image;
    }

}
