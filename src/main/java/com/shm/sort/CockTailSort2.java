package com.shm.sort;

import java.util.Arrays;

/**
 * 对于单向的冒泡排序，我们需要设置一个边界值，对于双向的鸡尾酒排序，我们需要设置两个边界值。
 * 代码中使用了左右两个边界值，rightSortBorder 代表右边界，leftSortBorder代表左边界。
 * 在比较和交换元素时，奇数轮从 leftSortBorder 遍历到 rightSortBorder 位置，
 * 偶数轮从 rightSortBorder 遍历到 leftSortBorder 位置。
 */
public class CockTailSort2 {
    private static void sort(int array[]) {
        int tmp  = 0;
        //记录右侧最后一次交换的位置
        int lastRightExchangeIndex = 0;

        //记录左侧最后一次交换的位置
        int lastLeftExchangeIndex = 0;

        //无序数列的右边界，每次比较只需要比到这里为止
        int rightSortBorder = array.length - 1;

        //无序数列的左边界，每次比较只需要比到这里为止
        int leftSortBorder = 0;

        for (int i= 0; i<array.length/2; i++){
            //有序标记，每一轮的初始是true
            boolean isSorted = true;

            //奇数轮，从左向右比较和交换
            for (int j=i; j<rightSortBorder; j++) {
                if (array[j] > array[j+1]) {
                    tmp = array[j];
                    array[j] = array[j+1];

                    array[j+1] = tmp;

                    //有元素交换，所以不是有序，标记变为false
                    isSorted = false;
                    lastRightExchangeIndex = j;
                }
            }

            rightSortBorder = lastRightExchangeIndex;
            if (isSorted){
                break;
            }

            //偶数轮之前，重新标记为true
            isSorted = true;

            //偶数轮，从右向左比较和交换
            for (int j=array.length-i-1; j>leftSortBorder; j--) {
                if (array[j] < array[j-1]) {

                    tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;

                    //有元素交换，所以不是有序，标记变为false
                    isSorted = false;
                    lastLeftExchangeIndex = j;
                }
            }

            leftSortBorder = lastLeftExchangeIndex;
            if (isSorted){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{ 2, 3, 4, 5, 6, 7, 8, 1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
