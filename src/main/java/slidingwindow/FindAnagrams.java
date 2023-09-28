package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: suruomo
 * @Date: 2021/8/16 10:07
 * @Description: 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指字母相同，但排列不同的字符串。
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        // 对p串的每个字符进行hash计数
        int pLength = p.length();
        int sLength = s.length();
        int[] counts = new int[26];
        for(int i = 0; i < pLength; i++){
            counts[p.charAt(i) - 'a']++;
        }

        ArrayList<Integer> res = new ArrayList<>();

        // 从下标0开始遍历字符串s,对于每个下标，判断接下来长度为pLength的子串是否为目标串的字母异位词
        for(int i = 0; i <= sLength - pLength; i++){
            int[] tempCounts = Arrays.copyOf(counts, 26);
            int j = i;
            // 内部每次遍历p的长度个数的子串，把子串中每个字符的计数器减一，出现负数则进入下个子串的统计
            for(; j < sLength && j < pLength + i; j++){
                if(--tempCounts[s.charAt(j) - 'a'] < 0){
                    break;
                }
            }
            if(j >= pLength + i){  // 说明找到了一个符合条件的字母异位词
                res.add(i);
            }
        }
        return res;
    }
}
