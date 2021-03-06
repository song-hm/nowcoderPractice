package com.shm.toOffer;

import java.util.Arrays;

/**
 * 时间效率	数组中出现次数超过一半的数字
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int ans = 0;
        for (int i=0;i<array.length;i++){
            int count = 0;
            for (int j=0;j<array.length;j++){
                if (array[j] == array[i]){
                    count++;
                }
            }
            if (count> array.length/2){
                ans = array[i];
                break;
            }
        }
        return ans;
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/e8a1b01a2df14cb2b228b30ee6a92163?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 思路：用一般的排序也可以完成这道题目，但是如果那样完成的话就可能太简单了。
     * 用preValue记录上一次访问的值，count表明当前值出现的次数，如果下一个值和当前值相同那么count++；
     * 如果不同count--，减到0的时候就要更换新的preValue值了，因为如果存在超过数组长度一半的值，
     * 那么最后preValue一定会是该值。
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution_2(int [] array) {
        if (array == null || array.length== 0){
            return 0;
        }
        int preValue = array[0];
        int count = 1;
        for (int i=1;i<array.length;i++){
            if (array[i] == preValue){
                count++;
            }else{
                count--;
                if (count == 0){
                    preValue = array[i];
                    count++;
                }
            }
        }
        int num = 0;
        for (int j=0;j<array.length;j++){
            if (array[j] == preValue){
                num++;
            }
        }
        return (2*num>array.length)?preValue:0;
    }

    /** 排序，取中间的数字，设为i 用i过滤数组，如果为i的个数超过半数，则i为所求，否则结果为0
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution_3(int [] array) {
        Arrays.sort(array);
        int ans = array[array.length/2];
        int num = 0;
        for (int j=0;j<array.length;j++){
            if (array[j] == ans){
                num++;
            }
        }
        return (2*num>array.length)?ans:0;
    }

}

