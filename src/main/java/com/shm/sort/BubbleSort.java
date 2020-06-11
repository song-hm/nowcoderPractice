package com.shm.sort;/*
 * 冒泡排序第一版
 * 冒泡排序的英文名BubbleSort，是一种最基础的交换排序。
 * 而冒泡排序之所以叫冒泡排序，正是因为这种排序算法的每个元素可以像小气泡一样，根据自身大小，一点一点向数组的一侧移动。
 * 按照冒泡排序的思想，要把相邻元素两两比较，根据元素的大小交换位置。
 * 原始的冒泡排序是稳定排序，由于该排序算法的每一轮都要遍历所有元素，轮转的次数与元素个数相当，所以时间复杂度是O(N^2)。
 * 代码非常简单，使用双循环来进行排序。外部循环控制所有的回合，内部循环代表每一轮的冒泡处理，先进行元素比较，在进行元素交换。
 */



import java.util.Arrays;


public class BubbleSort {
	private static void sort(int array[]){
		int tmp = 0;
		for (int i=0;i<array.length;i++){
			for (int j=0;j<array.length-1-i;j++){
				if (array[j]>array[j+1]){
					tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
				}
			}
		}
	}
	
	public static void main(String[] args){
		int[] array = new int[]{5,8,6,3,9,2,1,7};
		sort(array);
		System.out.println(Arrays.toString(array));
	}

}
