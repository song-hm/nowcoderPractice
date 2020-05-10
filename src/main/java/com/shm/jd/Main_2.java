package com.shm.jd;

/**
 * 题目描述：
 * 有n位乘客乘坐一列列车，列车一共会依次经过105个站点，从1到105编号。
 *
 * 我们已知每一位乘客的上车站点和下车站点，但是不知道这些乘客的订票顺序。
 *
 * 当一位乘客订票时，他会在当前还空余的座位中选择一个他喜欢的位置，但是我们不知道乘客的喜好，所有他具体订哪个位置我们是不知道的。
 *
 * 现在你需要计算列车最少需要安排多少座位，可以使得无论乘客的订票情况和顺序是怎么样的，所有乘客都有座位可以坐。
 *
 * 举个例子，有三位乘客：
 *
 * A：1→2
 *
 * B：2→3
 *
 * C：1→3
 *
 * 若订票顺序是A, C, B，那么只需要两个座位就一定能满足。当A订票时，他会选择一个座位，当C订票时，可用座位只剩下一个，他会订这个剩余的座位，当B订票时，可用座位也只有一个，他会订这个座位(即最开始A的那个座位)；
 *
 * 若订票顺序是A, B, C，那么有可能会需要三个座位，A订了一个座位，B订了与A不同的座位，此时C来订票时他只能订第三个座位。
 *
 * 所以对于这组例子，答案是3。
 *
 * 输入
 * 第一行包含一个整数n，表示乘客的数量。
 *
 * 1 <= n <= 1000
 *
 * 接下来n行每行包含两个整数si，ti，表示第i位乘客的上车站点和下车站点。
 *
 * 1 <= si < ti <= 105
 *
 * 输出
 * 输出对应的答案。
 * 样例输入
 * 10
 * 84 302
 * 275 327
 * 364 538
 * 26 364
 * 29 386
 * 545 955
 * 715 965
 * 404 415
 * 903 942
 * 150 402
 * 样例输出
 * 6
 */
//        链接：https://www.nowcoder.com/discuss/411698

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
// t2
public class Main_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for (int i = 0, a, b; i < n; i++) {
            a = in.nextInt();
            b = in.nextInt();
            if (!map.containsKey(a)) {
                map.put(a, new HashSet<Integer>());
            }
            map.get(a).add(i);
            if (!map.containsKey(b)) {
                map.put(b, new HashSet<Integer>());
            }
            map.get(b).add(i);
        }
        int siz = map.size(), idx = 0;
        int[] arr = new int[siz];
        for (int key : map.keySet()) {
            arr[idx++] = key;
        }
        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));
        Map<Integer, Boolean> vis = new HashMap<Integer, Boolean>();
        int ans = 0, cnt = 0;
        Set<Integer> set;
        for (int i = 0; i < idx; i++) {
            set = map.get(arr[i]);
            // 从已经上车的人来遍历
            if (vis.size() > 0) {
                for (int key : vis.keySet()) {
                    if (set.contains(key)) {
                        // 删除掉已经出现的
                        set.remove(key);
                        // 空余个数加1
                        cnt++;
                    }
                }
            }
            // 剩下就是刚上车的
            if (set.size() > 0) {
                for (int val : set) {
                    vis.put(val, true);
                    if (cnt > 0) {
                        cnt--;
                    }
                    else {
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans + 1);
    }
}
