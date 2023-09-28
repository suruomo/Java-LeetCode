package slidingwindow;

import java.util.Arrays;

/**
 * @Author: suruomo
 * @Date: 2021/8/4 11:53
 * @Description: 567. 字符串的排列
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        // 存储每个字符出现种类和次数
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        for (int i = n; i < m; ++i) {
            // 窗口每滑动一次，就多统计一次进入窗口的字符，少统计一次离开窗口的字符
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }
}
