package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: suruomo
 * @Date: 2021/8/11 19:44
 * @Description: 随时找到数据流的中位数
 * 有一个源源不断的吐出整数的数据流，假设你有足够的空间来保存吐出的数。请设计一个名叫MedianHolder的结构，MedianHolder可以随时取得之前吐出所有数的中位数。
 * [要求]
 * 1. 如果MedianHolder已经保存了吐出的N个数，那么将一个新数加入到MedianHolder的过程，其时间复杂度是O(logN)。
 * 2. 取得已经吐出的N个数整体的中位数的过程，时间复杂度为O(1)
 *
 * 每行有一个整数opt表示操作类型
 * 若opt=1，则接下来有一个整数N表示将N加入到结构中。
 * 若opt=2，则表示询问当前所有数的中位数
 * 输入：
 * [[1,5],[2],[1,3],[2],[1,6],[2],[1,7],[2]]
 * 复制
 * 返回值：
 * [5,4,5,5.5]
 * 复制
 * 说明：
 * 第一次查询时结构内的数为：5
 * 第二次查询时结构内的数为：3 5
 * 第二次查询时结构内的数为：3 5 6
 * 第二次查询时结构内的数为：3 5 6 7
 */
public class Median {
    class MedianHolder{

        double medianNum = -1;

        // 建立最小堆存放排序后的右边的数据，堆顶是右边数据的最小值
        PriorityQueue<Integer> right = new PriorityQueue<>();
        // 建立最大堆，存放排序后左边的数据，堆顶是左边数据的最大值
        PriorityQueue<Integer> left =
                new PriorityQueue<>((o1,o2) -> o2 - o1);
        // 添加数据
        public void add(int num){
            // 1.新增一个数，总数量为变为偶数
            if(left.size() > right.size()){

                left.offer(num);
                right.offer(left.poll());
                // 更新中位数
                medianNum = (right.peek() + left.peek()) / 2.0;
                return ;
            }
            // 2.新增一个数，总数量变为奇数
            right.offer(num);
            left.offer(right.poll());
            medianNum = left.peek();
            return;

        }
        // 返回中值
        public double getMedian(){
            return this.medianNum;
        }
    }
    public double[] flowmedian (int[][] operations) {
        // 存储中位数
        List<Double> res = new ArrayList<>();
        MedianHolder holder = new MedianHolder();
        // 遍历命令
        for (int i = 0;i < operations.length;++i){
            if (operations[i][0] == 1){
                holder.add(operations[i][1]);
            }
            if (operations[i][0] == 2){
                res.add(holder.getMedian());
            }
        }
        double[] medians = new double[res.size()];
        for (int i = 0;i < res.size();++i){
            medians[i] = res.get(i);
        }
        return medians;
    }
}
