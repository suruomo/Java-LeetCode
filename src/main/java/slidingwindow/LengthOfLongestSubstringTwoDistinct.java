package slidingwindow;

import java.util.Collections;
import java.util.HashMap;

/**
 * @Author: suruomo
 * @Date: 2021/8/6 9:59
 * @Description: 159. 至多包含两个不同字符的最长子串
 * 给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t 。
 *
 * 示例 1:
 *
 * 输入: "eceba"
 * 输出: 3
 * 解释: t 是 "ece"，长度为3。
 * 示例 2:
 *
 * 输入: "ccaabbb"
 * 输出: 5
 * 解释: t 是 "aabbb"，长度为5。
 */
public class LengthOfLongestSubstringTwoDistinct {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n < 3) {
            return n;
        }

        int left = 0;
        int right = 0;
        //K-V：K是对应字符，V是最后一次出现的位置。
        HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

        int max_len = 2;

        while (right < n) {
            //符合要求就继续向右扩
            if (hashmap.size()<=2){
                hashmap.put(s.charAt(right), right);
            }
            if (hashmap.size() == 3) {
                int index = Collections.min(hashmap.values());
                hashmap.remove(s.charAt(index));
                left = index + 1;
            }
            max_len = Math.max(max_len, right - left+1);
            right++;
        }
        return max_len;
    }

    public static void main(String[] args) {
        String s="eceba";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }
}
