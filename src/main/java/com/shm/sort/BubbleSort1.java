package com.shm.sort;/*
 * 冒泡排序第二版（优化）
 * 如果经过几轮排序，数列已然有序，这种情况下，如果我们能判断出数列已经有序，并且做出标记，剩下的几轮就没必要执行，提前结束工作。
 * 这一版代码做了小小的改动，利用布尔变量isSorted作为标记。如果在本轮排序中，元素有交换，则说明数列无序；如果没有元素交换，说明数列已然有序，直接跳出大循环。
 */

import java.util.Arrays;


public class BubbleSort1 {
	private static void sort(int array[]){
		int tmp = 0;
		for(int i=0;i<array.length;i++){
			//有序标记，每一轮的初值是true
			boolean isSorted=true;
			for(int j=0;j<array.length-i-1;j++){
				if(array[j]>array[j+1]){
					tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
					//有元素交换所以不是有序，标记变为false
					isSorted=false;
				}
			}
			if(isSorted){
				break;
			}
		}
		
	}
	
	public static void main(String[] args){
		int[] array = new int[]{5,3,8,6,9,2,1,7};
		sort(array);
		System.out.println(Arrays.toString(array));
	}

}
