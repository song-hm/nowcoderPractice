package com.shm;

/**
 * 序列和
 * 题目描述
 * 给出一个正整数N和长度L，找出一段长度大于等于L的连续非负整数，他们的和恰好为N。答案可能有多个，我我们需要找出长度最小的那个。
 * 例如 N = 18 L = 2：
 * 5 + 6 + 7 = 18
 * 3 + 4 + 5 + 6 = 18
 * 都是满足要求的，但是我们输出更短的 5 6 7
 * 输入描述:
 * 输入数据包括一行： 两个正整数N(1 ≤ N ≤ 1000000000),L(2 ≤ L ≤ 100)
 * 输出描述:
 * 从小到大输出这段连续非负整数，以空格分隔，行末无空格。如果没有这样的序列或者找出的序列长度大于100，则输出No
 * 示例1
 * 输入
 * 18 2
 * 输出
 * 5 6 7
 */

import java.util.Scanner;

public class SequenceSum {

    public static void main(String[] args) {
        /**
         * 链接：https://www.nowcoder.com/questionTerminal/46eb436eb6564a62b9f972160e1699c9?answerType=1&f=discussion
         * 来源：牛客网
         *
         * 这题就是通过差值为1的等差数列求解，通过等差数列基本公式的推导可以得到等差数列首项a1 = (2N - (L-1)L) / (2 * N)，而L的值是不能大于100的，所以可以直接求解L——100间有没有整数a1解，有的话直接输出就好了，超过100，直接输出No，注意输出的行末不能带有空格
         */

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        for (int i = L; i <= 100; i++) {
            if ((2 * N + i - i * i) % (2 * i) == 0) {
                int a1 = (2 * N + i - i * i) / (2 * i);
                for (int j = 0; j < i - 1; j++) {
                    System.out.print(a1 + j + " ");
                }
                System.out.println(a1 + i - 1);
                return;
            }
        }
        System.out.println("No");
    }
}
