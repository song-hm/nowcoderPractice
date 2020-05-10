package com.shm.toOffer;

/**
 * 变态跳台阶
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloorII {

    /**
     * 易知 f(n)=f(n-1)+f(n-2)+……f(1)
     * f(n-1)=f(n-2)+……f(1)
     * 两式相减得f(n)=2f(n-1)
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
//        return (int)Math.pow(2,target-1);
        return 1<<(target-1);
    }
}
