import java.util.*;

/**
 * @author: suruomo
 * @date: 2021/4/1 14:12
 * @description: 表达式求值
 */
public class Calculate {
    public String[][] topKstrings (String[] strings, int k) {
        TreeMap<String,Integer> treeMap=new TreeMap<>();
        for (String s:strings){
            treeMap.put(s,treeMap.getOrDefault(s,0)+1);
        }
        ArrayList<Map.Entry<String,Integer>> list=new ArrayList<>(treeMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> s1, Map.Entry<String, Integer> s2) {
                return s1.getValue().compareTo(s2.getValue())==0?s1.getKey().compareTo(s2.getKey()):s2.getValue().compareTo(s1.getValue());
            }
        });
        String[][] strings1=new String[k][2];
        for (int i = 0; i < k; i++) {
            strings1[i][0]=String.valueOf(list.get(i).getKey());
            strings1[i][1]=String.valueOf(list.get(i).getValue());
        }
        return strings1;
    }
}
