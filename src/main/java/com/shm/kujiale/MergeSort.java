package com.shm.kujiale;

import java.util.Arrays;

public class MergeSort {
    int[] aux;
    public void mSort(int[] num){
        aux= new int[num.length];
        mergeSort(num,0,num.length-1);
    }

    public void mergeSort(int[] num,int l,int h){
        if (h<=l){
            return;
        }
        int mid = l+(h-l)/2;
        mergeSort(num,l,mid);
        mergeSort(num,mid+1,h);
        merge(num, l, mid, h);
    }

    public void merge(int[] nums,int l,int mid,int h){
        int i,j,k;
        for (int m = l; m <= h; m++) {
            aux[m] = nums[m];
        }

        for (i = l,j=mid+1; l <= mid&&j<=h; i++) {
            if (aux[l]<aux[j]){
                nums[i] = aux[l++];
            }else{
                nums[i] = aux[j++];
            }
        }

        if (l<=mid){
            for (k = 0; k <= mid-l; k++) {
                nums[i+k] = aux[l+k];
            }
        }

        if (j<=h){
            for (k = 0; k <= h - j; k++) {
                nums[i+k] = aux[j+k];
            }
        }
    }

    public static void main(String[] arg){
        int[] num = new int[]{5, 3, 8, 6, 9, 2, 1, 7};
        MergeSort ms = new MergeSort();
        ms.mSort(num);
        System.out.println(Arrays.toString(num));
    }
}
