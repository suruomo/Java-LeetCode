package dynamicplanning;

/**
 * @Author: suruomo
 * @Date: 2021/8/30 11:27
 * @Description: 583. 两个字符串的删除操作
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 */
public class MinDelete {
    /**
     * 转化为最长公共子序列实现
     * @param s1
     * @param s2
     * @return
     */
    public int minDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    continue;
                }
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return s1.length() + s2.length() - 2 * dp[s1.length()][s2.length()];

    }
}
