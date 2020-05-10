package com.shm.toOffer;

/**
 *  代码的完整性 数值的整次方
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 保证base和exponent不同时为0
 *
 */
public class Power {

    /**
     * 解法 1: 内置函数
     * 第一反应直接调用库函数。
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        return Math.pow(base,exponent);
    }


    /**
     * 解法 2: 暴力法
     * 将数字 base 连续乘 exponent 次即可。
     *
     * 时间复杂度是 O(N),空间复杂度是 O(1)
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power_2(double base, int exponent) {
        if(base == 0.0){
            return 0.0;
        }
        // 前置结果设为1.0，即当exponent=0 的时候，就是这个结果
        double result = 1.0d;
        // 获取指数的绝对值
        int e = exponent>0?exponent:-exponent;
        // 根据指数大小，循环累乘
        for(int i=1;i<=e;i++){
            result=base*result;
        }
        // 根据指数正负，返回结果
        return exponent>0?result:1/result;
    }
}
