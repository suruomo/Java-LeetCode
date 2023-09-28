package advanced.sequence;

/**
 * @Author: suruomo
 * @Date: 2021/7/29 9:56
 * @Description: 516. 最长回文子序列
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 *
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 */
public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        int len=s.length();
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
