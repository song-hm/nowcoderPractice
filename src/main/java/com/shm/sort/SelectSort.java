package com.shm.sort;

import java.util.Arrays;

/**
 *
 */
public class SelectSort {
    public static void main(String[] args) {
        int arr[] = {6,9,2,1,7,4,3,8,0,5,7};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j]<arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}
