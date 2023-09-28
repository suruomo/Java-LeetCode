package greedyalgorithm;

import java.util.Arrays;

/**
 * @Author: suruomo
 * @Date: 2021/8/11 11:27
 * @Description: 621. 任务调度器
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 *
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 *
 * 你需要计算完成所有任务所需要的 最短时间 。
 */
public class LeastInterval {
    /**
     * 先安排出现次数最多的任务，让这个任务两次执行的时间间隔正好为n。
     * 再在这个时间间隔内填充其他的任务。
     * maxTimes为出现次数最多的那个任务出现的次数。
     * maxCount为一共有多少个任务和出现最多的那个任务出现次数一样。
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int[] buckets = new int[26];
        for(int i = 0; i < tasks.length; i++){
            buckets[tasks[i] - 'A']++;
        }
        Arrays.sort(buckets);
        int maxTimes = buckets[25];
        int maxCount = 1;
        for(int i = 25; i >= 1; i--){
            if(buckets[i] == buckets[i - 1]) {
                maxCount++;
            } else {
                break;
            }
        }
        int res = (maxTimes - 1) * (n + 1) + maxCount;
        return Math.max(res, tasks.length);
    }
}
