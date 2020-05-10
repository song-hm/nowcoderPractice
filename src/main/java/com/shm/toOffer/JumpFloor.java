package com.shm.toOffer;

/**
 * 跳台阶
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class JumpFloor {

    /**
     *链接：https://www.nowcoder.com/questionTerminal/8c82a5b80378478f9484d87d1c5f12a4?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 本质上还是斐波那契数列，所以迭代也可以求
     *
     * 当成 dp 问题来想的话：首先分析问题，它最终解是由前面的解累积起来的解，如何缩小问题的规模？
     *
     * 首先可知，第一阶有只能一步，一种；，第二阶可以两次一步、一次两步两种
     *
     * 若楼梯阶级 n = 3
     * 跳 2 步到 3：剩下的是第一步没跳，起始跳到第一步只有一种
     * 跳 1 步到 3：剩下的是第二步没跳，起始跳到第二步有两种
     * 通过分类讨论，问题规模就减少了:
     *
     * 若楼梯阶级 n = n
     * 跳 2 步到 n：剩下的是第 n - 2 步没跳，起始跳到第 n - 2 步设它为 pre2 种
     * 跳 1 步到 n：剩下的是第 n - 1 步没跳，起始跳到第 n - 1 步设它为 pre1 种
     * 同时可以发现第 n 阶的解法，只要用到 n - 1 和 n - 2 阶是多少，其他的不用考虑，因此用两个变量临时存下来即可
     *
     * dp(i) = dp(i-2) + dp(i-1)
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if(target <= 2){
            return target;
        }
        return JumpFloor(target-1) + JumpFloor(target-2);
    }

    /**
     *
     * @param target
     * @return
     */
    public int JumpFloor_2(int target) {
        if(target <= 2){
            return target;
        }
        int sum = 0;
        int one = 2;
        int two = 1;
        for(int i=3;i<=target;i++){
            sum = one + two;
            two = one;
            one = sum;
        }
        return sum;
    }

    public int JumpFloor_3(int target) {
        if(target <= 2){
            return target;
        }
        int sum = 2;
        int one = 1;
        for(int i=3;i<=target;i++){
            sum = sum + one;
            one = sum - one;
        }
        return sum;
    }

}
