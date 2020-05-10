package com.shm.toOffer;

/**
 * 斐波那契数列
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class Fibonacci {
    /**
     * 1. 递归法
     * 1. 分析
     * 斐波那契数列的标准公式为：F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)（n>=3，n∈N*）
     * 根据公式可以直接写出：
     * 3. 复杂度
     * 时间复杂度：O(2^n)
     * 空间复杂度：O(1)
     * @param n
     * @return
     *
     */
    public int fibonacci(int n) {
//        if(n==0) {
//            return 0;
//        }
//        if(n==1) {
//            return 1;
//        }
        if (n<=1){
            return n;
        }
        return (fibonacci(n-1) + fibonacci(n-2));
    }

    /**
     * 2. 优化递归
     * 1. 分析
     * 递归会重复计算大量相同数据，我们用个数组把结果存起来8！
     * 3. 复杂度：
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        int[] ans = new int[40];
        ans[0] = 0;
        ans[1] = 1;
        for(int i=2; i<=n; i++){
            ans[i] = ans[i-1] + ans[i-2];
        }
        return ans[n];
    }

    /**
     *3. 优化存储
     * 1. 分析
     * 其实我们可以发现每次就用到了最近的两个数，所以我们可以只存储最近的两个数
     *
     * sum 存储第 n 项的值
     * one 存储第 n-1 项的值
     * two 存储第 n-2 项的值
     * 3. 复杂度：
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param n
     * @return
     */
    public int Fibonacci_2(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int sum = 0;
        int one = 1;
        int two = 0;
        for(int i=2;i<=n;i++){
            sum = one + two;
            two = one;
            one = sum;
        }
        return sum;
    }


    /**
     * 链接：https://www.nowcoder.com/questionTerminal/c6c7742f5ba7442aada113136ddea0c3?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 4. 持续优化
     * 1. 分析
     * 观察上一版发现，sum 只在每次计算第 n 项的时候用一下，其实还可以利用 sum 存储第 n-1 项，例如当计算完 f(5) 时 sum 存储的是 f(5) 的值，当需要计算 f(6) 时，f(6) = f(5) + f(4)，sum 存储的 f(5)，f(4) 存储在 one 中，由 f(5)-f(3) 得到
     * 如图：
     * 3. 复杂度
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param n
     * @return
     */
    public int Fibonacci_3(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int sum = 1;
        int one = 0;
        for(int i=2;i<=n;i++){
            sum = sum + one;
            one = sum - one;
        }
        return sum;
    }
}
