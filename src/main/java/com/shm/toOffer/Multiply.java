package com.shm.toOffer;

/**
 *  数组	构建乘积数组
 *  题目描述
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * commit：1
 * pass:100%
 *
 */
public class Multiply {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            B[i] = 1;
            for (int j = 0; j < A.length; j++) {
                if (j!=i){
                    B[i] *=A[j];
                }
            }
        }
        return B;
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/94a4d381a68b47b7a8bed86f2975db46?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 实现思路
     * 既然不能用乘法，分析题目，我们可以将乘积拆为两项。即:
     *
     * C[i] = A[0] * A[1] *...*A[i-1]
     * D[i] = A[i + 1] *...* A[n-1]
     * B[i] = C[i] * D[i]
     * 我们先来计算C[i]，使用数学归纳法：
     *
     * C[0] = 1
     * C[1] = A[0]
     * C[2] = A[0] * A[1]
     * C[3] = A[0] * A[1] * A[2]
     * ...
     * 我们可以得出规律：C[i] = C[i-1] * A[i -1](i >=1)
     * 我们继续用数学归纳法计算D[i]:
     *
     * D[n - 1] = 1
     * D[n - 2] = A[n -1]
     * D[n - 3] = A[n - 1] * A[n - 2]
     * 我们可以得出规律：D[i] = D[i + 1]* A[i + 1](i <= n-2)
     * @param A
     * @return
     */
    public int[] multiply_2(int[] A) {
        int[] B = new int[A.length];
        //初始化第一个
        B[0] = 1;
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i-1]*A[i-1];
        }

        //初始化最后一个
        int temp = 1;
        for (int i = A.length-1; i >= 0; i--) {
            B[i] = temp*B[i];
            temp = A[i]*temp;
        }
        return B;
    }
}
