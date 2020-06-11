package com.shm.toOffer;

/** 发散思维能力	求1+2+3+...+n
 * 题目描述
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 */
public class Sum {
    /**
     * 短路原理
     * 以使用“短路求值原理”来做为递归的结束条件
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (sum>0) && ((sum += Sum_Solution(n-1))>0);
        return sum;
    }
}
