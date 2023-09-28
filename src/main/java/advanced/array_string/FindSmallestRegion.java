package advanced.array_string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: suruomo
 * @Date: 2021/8/9 10:43
 * @Description: 1257. 最小公共区域
 * 给你一些区域列表 regions ，每个列表的第一个区域都包含这个列表内所有其他区域。
 *
 * 很自然地，如果区域 X 包含区域 Y ，那么区域 X 比区域 Y 大。
 *
 * 给定两个区域 region1 和 region2 ，找到同时包含这两个区域的 最小 区域。
 *
 * 如果区域列表中 r1 包含 r2 和 r3 ，那么数据保证 r2 不会包含 r3 。
 *
 * 数据同样保证最小公共区域一定存在。
 * 输入：
 * regions = [["Earth","North America","South America"],
 * ["North America","United States","Canada"],
 * ["United States","New York","Boston"],
 * ["Canada","Ontario","Quebec"],
 * ["South America","Brazil"]],
 * region1 = "Quebec",
 * region2 = "New York"
 * 输出："North America"
 */
public class FindSmallestRegion {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String,String> map = new HashMap<>();
        for(List<String> list : regions){
            String ParentRegion = list.get(0);
            for(int i = 1;i < list.size();i++){
                //构建map，key是当前区域，value是最小父区域
                map.put(list.get(i),ParentRegion);
            }
        }
        // 分别按照顺序获取父区域列表
        List<String> res1 = find(region1,map);
        List<String> res2 = find(region2,map);
        for(String s : res1){
            //因为父节点队列是有序的，排在前面的是最小的父节点，所以遍历返回的是最小的公共区域。
            if(res2.contains(s)){
                return s;
            }
        }
        return "";
    }

    /**
     * 按序获取当前区域的父区域列表
     * @param region
     * @param map
     * @return
     */
    public List<String> find(String region,Map<String,String> map){
        List<String> res = new ArrayList<>();
        //注意：这里需要把区域本身加进父节点list中，对应测试用例："Canada","Quebec"
        String parent = region;
        while(map.get(parent)!=null){
            res.add(parent);
            parent = map.get(parent);
        }
        //这里是将最大的公共区域加进父节点list中
        res.add(parent);
        return res;
    }
}
