package interview;

/**
 * @Author: suruomo
 * @Date: 2021/8/11 19:02
 * @Description:  剑指 Offer 19. 正则表达式匹配
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Match {
    /**
     * 如果说当前的子问题是 s[i,…n] 和 p[j…m]:
     *
     * s[i] == p[j]，子问题成立与否取决于子问题 s[i+1,…n] 和 p[j+1,…m]
     *
     * p[j] == ‘.’，子问题成立与否取决于子问题 s[i+1,…n] 和 p[j+1,…m]
     *
     * p[j+1] == ‘*’，s[i] != p[j]，子问题成立与否取决于子问题 s[i,…n] 和 p[j+2,…m]
     *
     * p[j+1] == ‘*’，s[i] == p[j]，子问题成立与否取决于子问题 s[i+1,…n] 和 p[j,…m]
     * @param str
     * @param pattern
     * @return
     */
    public boolean match (String str, String pattern) {
        if (str.equals(pattern)) {
            return true;
        }

        boolean isFirstMatch = false;
        // 第一个字符是否匹配上
        if (!str.isEmpty() && !pattern.isEmpty() && (str.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.')) {
            isFirstMatch = true;
        }

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            // 看 s[i,...n] 和 p[j+2,...m] 或者是 s[i+1,...n] 和 p[j,...m]
            return match(str, pattern.substring(2))
                    || (isFirstMatch && match(str.substring(1), pattern));
        }

        // 看 s[i+1,...n] 和 p[j+1,...m]
        return isFirstMatch && match(str.substring(1), pattern.substring(1));
    }
}
