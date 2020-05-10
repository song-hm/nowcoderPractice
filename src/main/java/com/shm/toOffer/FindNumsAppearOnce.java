package com.shm.toOffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 *  知识迁移能力	数组中只出现一次的数字
 *  题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<array.length;i++){
            if (map.containsKey(array[i])){
                map.put(array[i],2);
            }else {
                map.put(array[i],1);
            }
        }

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i])==1){
                if (count==0) {
                    num1[0] = array[i];
                    count++;
                }else {
                    num2[0] = array[i];
                }

            }
        }
    }


    /**1、Arrays.sort 数组排序
     2、使用栈进行从小到大入栈，一样的则弹出，不一样则入栈
     3、取栈中剩余的元素
     *
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce_2(int [] array,int num1[] , int num2[]) {
        Arrays.sort(array);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            if (stack.isEmpty() || array[i] != stack.peek()){
                stack.push(array[i]);
            }else {
                stack.pop();
            }
        }

        num1[0] = stack.pop();
        num2[0] = stack.pop();

    }
}
