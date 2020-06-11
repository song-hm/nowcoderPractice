package com.shm.sort;/*
 * ð�������һ��
 * ð�������Ӣ����BubbleSort����һ��������Ľ�������
 * ��ð������֮���Խ�ð������������Ϊ���������㷨��ÿ��Ԫ�ؿ�����С����һ�������������С��һ��һ���������һ���ƶ���
 * ����ð�������˼�룬Ҫ������Ԫ�������Ƚϣ�����Ԫ�صĴ�С����λ�á�
 * ԭʼ��ð���������ȶ��������ڸ������㷨��ÿһ�ֶ�Ҫ��������Ԫ�أ���ת�Ĵ�����Ԫ�ظ����൱������ʱ�临�Ӷ���O(N^2)��
 * ����ǳ��򵥣�ʹ��˫ѭ�������������ⲿѭ���������еĻغϣ��ڲ�ѭ������ÿһ�ֵ�ð�ݴ����Ƚ���Ԫ�رȽϣ��ڽ���Ԫ�ؽ�����
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
