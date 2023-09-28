package dynamicplanning;

/**
 * @Author: suruomo
 * @Date: 2021/7/26 9:41
 * @Description: 516. 最长回文子序列
 * 给定一个字符串s，找到其中最长的回文子序列。
 */
public class LongestPalindromeSubseq {
    public  int longestPalindromeSubseq(String s) {
        int len=s.length();
        // dp[i][j]表示区间i~j的最长回文子序列长度
        int[][] dp=new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i]=1;
        }
        for (int i = len-1; i >=0; i--) {
            for (int j = i+1; j < len; j++) {
                if (s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else {
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }
}
