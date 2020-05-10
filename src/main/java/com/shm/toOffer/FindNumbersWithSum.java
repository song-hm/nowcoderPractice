package com.shm.toOffer;

import java.util.ArrayList;

/**
 * 知识迁移能力	和为S的两个数字
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class FindNumbersWithSum {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < array.length-1; i++) {
            for (int j=i+1;j<array.length;j++){
                if (array[i] + array[j] == sum){
                    list.add(array[i]);
                    list.add(array[j]);
                    count++;
                }
            }
            if (count>0){
                break;
            }
        }
        return list;
    }


//    链接：https://www.nowcoder.com/questionTerminal/390da4f7a00f44bea7c2f3d19491311b?answerType=1&f=discussion

    public ArrayList<Integer> FindNumbersWithSum_2(int [] array,int sum) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        //边界条件
        if(array==null||array.length<=1){
            return result;
        }
        int smallIndex=0;
        int bigIndex=array.length-1;
        while(smallIndex<bigIndex){
            //如果相等就放进去
            if((array[smallIndex]+array[bigIndex])==sum){
                result.add(array[smallIndex]);
                result.add(array[bigIndex]);
                //最外层的乘积最小，别被题目误导
                break;
            }else if((array[smallIndex]+array[bigIndex])<sum){
                smallIndex++;
            }else{
                bigIndex--;
            }
        }
        return result;
    }
}
