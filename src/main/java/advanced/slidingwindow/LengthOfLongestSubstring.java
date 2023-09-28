package advanced.slidingwindow;

import java.util.HashMap;

/**
 * @Author: suruomo
 * @Date: 2021/8/6 10:05
 * @Description: 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        // //K-V：K是对应字符，V是最后一次出现的位置。
        HashMap<Character,Integer> hashMap=new HashMap<>();
        int start=0,end=0;
        int ans=0;
        int len=s.length();
        while (end<len){
            if (hashMap.containsKey(s.charAt(end))){
                start=Math.max(start,hashMap.get(s.charAt(end))+1);
            }
            ans=Math.max(ans,end-start+1);
            hashMap.put(s.charAt(end),end);
            end++;
        }
        return ans;
    }
}
