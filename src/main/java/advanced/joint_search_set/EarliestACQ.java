package advanced.joint_search_set;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: suruomo
 * @Date: 2021/8/3 10:59
 * @Description:  1101 彼此相熟的最早时间
 * 在一个社交圈子当中，有N个人。每个人都有一个从0到N-1唯一的id编号。
 *
 * 我们有一份日志列表logs，其中每条记录都包含一个非负整数的时间戳，以及分属两个人的不同id，logs[i] = [timestamp, id_A, id_B]。
 *
 * 每条日志标识出两个人成为好友的时间，友谊是相互的：如果A和B是好友，那么B和A也是好友。
 *
 * 如果A是B的好友，或者A是B的好友的好友，那么就可以认为A也与B熟识。
 *
 * 返回圈子里所有人之间都熟识的最早时间。如果找不到最早时间，就返回-1。
 *
 * 思路:
 * 经典的并查集算法。
 *
 * 初始时，有多少个人就有多少个朋友圈，每个圈子的领袖初始时都是每个人自己。
 *
 * find 方法：如果 A 所在圈子的领袖不是 A 本身，则继续找 leader[A] 的领袖，直到该圈子的领袖是它自己为止；
 *
 * union 方法：如果两个人所在圈子的领袖不是同一个人，则 leader[leaderA] = leaderB，同时圈子个数减一。
 */
public class EarliestACQ {
    public int earliestAcq(int[][] logs, int N) {
        Arrays.sort(logs, Comparator.comparingInt(a -> a[0]));
        Friend f = new Friend(N);
        for (int[] log : logs) {
            f.union(log[1], log[2]);
            // 最终合并成一个圈子时返回
            if (f.circles == 1) {
                return log[0];
            }
        }
        return -1;
    }

    class Friend {
        int n;
        int circles;
        int[] leader;

        Friend(int N) {
            n = N;
            circles = N;
            leader = new int[n];
            // 初始自己的根节点是自己
            for (int i = 0; i < leader.length; i++) {
                leader[i] = i;
            }
        }

        int find(int A) {
            while (leader[A] != A) {
                A = leader[A];
            }
            return A;
        }

        void union(int A, int B) {
            int leaderA = find(A);
            int leaderB = find(B);
            if (leaderA != leaderB) {
                leader[leaderA] = leaderB;
                circles--;
            }
        }
    }
}
