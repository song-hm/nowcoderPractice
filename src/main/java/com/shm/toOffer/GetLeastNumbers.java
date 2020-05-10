package com.shm.toOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 时间效率	最小的K个数
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input.length==0 || input.length<k){
            return list;
        }
        Arrays.sort(input);
        for (int i=0;i<k;i++){
            list.add(input[i]);
        }
        return list;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution_1(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input.length == 0 || input.length < k) {
            return list;
        }
        //插入排序
        for (int i=1;i<input.length;i++){
            for (int j=i;j>0 && input[j]<input[j-1];j--){
                int temp = input[j];
                input[j] = input[j-1];
                input[j-1] = temp;
            }
        }
        //选择排序
        for (int i=0;i<input.length-1;i++){
            int min = i;
            for (int j=i+1;j<input.length;j++){
                if (input[j] < input[min]){
                    min = j;
                }
            }
            int temp = input[i];
            input[i] = input[min];
            input[min] = temp;
        }
        //希尔排序
        int len = input.length;
        int h = 1;
        while (h<len/3){
            h = 3*h+1;
        }
        while (h>=1){
            for (int i=h;i<len;i++){
                for (int j=i;j>=h && input[j] < input[j-h];j-=h){
                    int temp = input[j];
                    input[j] = input[j-h];
                    input[j-h] = temp;
                }
            }
            h = h/3;
        }

        //
        for (int i=0;i<k;i++){
            list.add(input[i]);
        }
        return list;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution_2(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input.length == 0 || input.length < k) {
            return list;
        }
        for (int i=1;i<k;i++){
            int cur = input[i];
            int j= i-1;
            while (j>=0 && cur <input[j] ){
                input[j+1] = input[j];
                j--;
            }
            input[j+1] = cur;
        }


        for(int i = k; i < input.length; i++){
            if(input[i] < input[k-1]){
                int newK = input[i];
                int j = k-1;
                while(j >= 0 && input[j] > newK){
                    input[j+1] = input[j];
                    j--;
                }
                input[j+1] = newK;
            }
        }
        for (int i=0;i<k;i++){
            list.add(input[i]);
        }
        return list;
    }


    public ArrayList<Integer> GetLeastNumbers_Solution_3(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k == 0 || input.length < k) {
            return list;
        }

        for (int i=0;i<k;i++){
            list.add(input[i]);
        }

        for (int i=k;i<input.length;i++){
            int j = getMax(list);
            int temp = list.get(j);
            if (input[i] < temp){
                list.set(j,input[i]);
            }
        }
        return list;
    }

    int getMax(ArrayList<Integer> list){
        int max = list.get(0);
        int j = 0;
        for (int i=0;i<list.size();i++){
            if (max < list.get(i)){
                max = list.get(i);
                j = i;
            }
        }
        return j;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution_4(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k == 0 || input.length < k) {
            return list;
        }
        //数组下标0的位置作为哨兵，不存储数据
        int[] arr = new int[k+1];
        //初始化数组
        for (int i=1;i<k+1;i++){
            arr[i] = input[i-1];
        }
        //构造大根堆
        buildMaxHeap(arr,k+1);
        for (int i=k;i<input.length;i++){
            if (input[i] < arr[1]){
                arr[1] = input[i];
                //将改变了根节点的二叉树继续调整为大根堆
                adjustDown(arr,1,k+1);
            }
        }

        for (int i=1;i<arr.length;i++){
            list.add(arr[i]);
        }
        return list;
    }

    /**
     * 构造大根堆
     * @param arr
     * @param length 数组长度 作为是否跳出循环的条件
     */
    public void buildMaxHeap(int[] arr,int length){
        if (arr == null || arr.length==0 || arr.length==1){
            return;
        }
        for (int i=(length-1)/2;i>0;i--){
            adjustDown(arr,i,length);
        }
    }

    /**
     * 堆排序中对一个子二叉树进行堆排序
     * @param arr
     * @param k
     * @param length
     */
    public void adjustDown(int[] arr,int k,int length){
        //哨兵
        arr[0] = arr[k];
        for (int i=2*k;i<length;i*=2){
            //取k较大的子结点的下标
            if (i<length-1 && arr[i]<arr[i+1]){
                i++;
            }
            if (i>length-1 || arr[0]>arr[i]){
                break;
            }else {
                arr[k] = arr[i];
                //向下筛选
                k=i;
            }
        }
        arr[k] = arr[0];

    }
}
