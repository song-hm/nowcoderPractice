package com.shm.sort;/*
 * ð����������棨�Ż���
 * ��������ұ����Ԫ���Ѿ�����ÿһ�ֻ��ǻ�װױȽϺö�Ρ�
 * �������Ĺؼ��������أ��ؼ��������������Ľ綨��
 * ���������߼����������ĳ������������������ȵġ�ʵ�����������������������ܻ����������ȣ���˺�������Ԫ�رȽ���û������ġ�
 * ��α�����������أ����ǿ�����ÿһ���������󣬼�¼��Ԫ�ؽ�����λ�ã��Ǹ�λ��Ҳ�����������еı߽磬�������������ȥ�ˡ�
 * ��һ������У�sortBorder�����������еı߽硣ÿһ����������У�sortBorder�����Ԫ�ؾ���ȫû��Ҫ�Ƚ��ˣ��϶�������ġ�
 */

import java.util.Arrays;


public class BubbleSort2 {
	private static void sort(int array[]){
		int tmp = 0;
		//��¼���һ�ν�����λ��
		int lastExchangeIndex=0;
		//�������еı߽磬ÿ�αȽ�ֻҪ����Ϊֹ
		int sortBorder=array.length-1;
		for(int i=0;i<array.length;i++){
			//�����ǣ�ÿһ�ֵĳ�ֵ��true
			boolean isSorted=true;
			for(int j=0;j<sortBorder;j++){
				if(array[j]>array[j+1]){
					tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
					//��Ԫ�ؽ������Բ������򣬱��Ϊfalse
					isSorted=false;
					//���������еı߽����Ϊ���һ�ν���Ԫ�ص�λ��
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
