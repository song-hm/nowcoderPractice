package com.shm.sort;/*
 * 冒泡排序第三版（优化）
 * 如果数列右边许多元素已经有序，每一轮还是会白白比较好多次。
 * 这个问题的关键点在哪呢？关键在数列有序区的界定。
 * 按照现在逻辑，有序区的长度与排序的轮数是相等的。实际上数列真正的有序区可能会大于这个长度，因此后面许多次元素比较是没有意义的。
 * 如何避免这种情况呢？我们可以在每一轮排序的最后，记录下元素交换的位置，那个位置也就是无序数列的边界，再往后就是有序去了。
 * 这一版代码中，sortBorder就是无序数列的边界。每一轮排序过程中，sortBorder后面的元素就完全没必要比较了，肯定是有序的。
 */

import java.util.Arrays;


public class BubbleSort2 {
	private static void sort(int array[]){
		int tmp = 0;
		//记录最后一次交换的位置
		int lastExchangeIndex=0;
		//无序数列的边界，每次比较只要到这为止
		int sortBorder=array.length-1;
		for(int i=0;i<array.length;i++){
			//有序标记，每一轮的初值是true
			boolean isSorted=true;
			for(int j=0;j<sortBorder;j++){
				if(array[j]>array[j+1]){
					tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
					//有元素交换所以不是有序，标记为false
					isSorted=false;
					//把无序数列的边界更新为最后一次交换元素的位置
					lastExchangeIndex=j;
				}
			}
			sortBorder=lastExchangeIndex;
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
