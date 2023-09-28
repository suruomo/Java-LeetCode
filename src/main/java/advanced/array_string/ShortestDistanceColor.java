package advanced.array_string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: suruomo
 * @Date: 2021/8/5 13:00
 * @Description: 1182-与目标颜色间的最短距离
 * 给你一个数组 colors，里面有 1、2、 3 三种颜色。
 * 我们需要在 colors 上进行一些查询操作 queries，其中每个待查项都由两个整数 i 和 c 组成。
 * 现在请你帮忙设计一个算法，查找从索引 i 到具有目标颜色 c 的元素之间的最短距离。
 * 如果不存在解决方案，请返回 -1。
 */
public class ShortestDistanceColor {
    public static List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        List<Integer> ans=new ArrayList<>();
        if (queries==null||queries.length==0){
            return ans;
        }
        // 存放每种颜色的对应下标列表
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        map.put(1,new ArrayList<>());
        map.put(2,new ArrayList<>());
        map.put(3,new ArrayList<>());
        for (int i = 0; i < colors.length; i++) {
           map.get(colors[i]).add(i);
        }
        for (int i = 0; i < queries.length; i++) {
            List<Integer> list=map.get(queries[i][1]);
            if (list.size()==0){
                ans.add(-1);
                continue;
            }
            Collections.sort(list);
            int index=queries[i][0];
            if (list.contains(index)){
                ans.add(0);
                continue;
            }else {
                if (index<list.get(0)){
                    ans.add(Math.abs(index-list.get(0)));
                }else if(index>list.get(list.size()-1)){
                    ans.add(Math.abs(index-list.get(list.size()-1)));
                }else {
                   for(int k:list){
                       if (k>index){
                           ans.add(index-k);
                           break;
                       }
                   }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] colors={1,1,2,1,3,2,2,3,3};
        int[][] queries={{1,3},{2,2},{6,1}};
        System.out.println(shortestDistanceColor(colors,queries).toString());
    }
}
