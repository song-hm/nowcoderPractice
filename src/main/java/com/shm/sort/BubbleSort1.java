package com.shm.sort;/*
 * ð������ڶ��棨�Ż���
 * ���������������������Ȼ������������£�����������жϳ������Ѿ����򣬲���������ǣ�ʣ�µļ��־�û��Ҫִ�У���ǰ����������
 * ��һ���������СС�ĸĶ������ò�������isSorted��Ϊ��ǡ�����ڱ��������У�Ԫ���н�������˵�������������û��Ԫ�ؽ�����˵��������Ȼ����ֱ��������ѭ����
 */

import java.util.Arrays;


public class BubbleSort1 {
	private static void sort(int array[]){
		int tmp = 0;
		for(int i=0;i<array.length;i++){
			//�����ǣ�ÿһ�ֵĳ�ֵ��true
			boolean isSorted=true;
			for(int j=0;j<array.length-i-1;j++){
				if(array[j]>array[j+1]){
					tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
					//��Ԫ�ؽ������Բ������򣬱�Ǳ�Ϊfalse
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
