package slidingwindow;

/**
 * @Author: suruomo
 * @Date: 2021/8/6 11:18
 * @Description: 最小覆盖子串
 * 给出两个字符串 S 和 T，要求在O(n)的时间复杂度内在 S 中找出最短的包含 T 中所有字符的子串。
 * 例如：
 *
 * S ="XDOYEZODEYXNZ"S="XDOYEZODEYXNZ"
 * T ="XYZ"T="XYZ"
 * 找出的最短子串为"YXNZ""YXNZ".
 *
 * 注意：
 * 如果 S 中没有包含 T 中所有字符的子串，返回空字符串 “”；
 * 满足条件的子串可能有很多，但是题目保证满足条件的最短的子串唯一。
 */
public class MinWindow {
    public String minWindow (String s, String t) {
        if (s==null||s.length()==0||t==null||t.length()==0||s.length()<t.length()){
            return "";
        }
        //用来统计t中每个字符出现次数
        int[] needs = new int[128];
        //用来统计滑动窗口中每个字符出现次数
        int[] window = new int[128];
        // 记录t中各字符数量
        for (int i = 0; i < t.length(); i++) {
            needs[t.charAt(i)]++;
        }

        int left=0,right=0;
        String ans="";
        // 记录窗口中当前出现结果字符数量
        int count=0;
        int minLength=0;

        while (right<s.length()){
            char cur=s.charAt(right);
            window[cur]++;
            if (needs[cur]>=window[cur]){
                count++;
            }
            // 当前窗口内已包含t的全部字符
            while (count==t.length()){
                char c=s.charAt(left);
                if (needs[c]>=window[c]){
                    count--;
                }
                // 更新结果
                if (right-left+1<minLength){
                    minLength=right-left+1;
                    ans=s.substring(left,right+1);
                }
                window[c]--;
                left++;
            }
            right++;
        }
        return ans;
    }
}
