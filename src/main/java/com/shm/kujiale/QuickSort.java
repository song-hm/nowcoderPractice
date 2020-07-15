package com.shm.kujiale;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] agr){
        int[] num = {5, 3, 8, 6, 9, 2, 1, 7};
        QuickSort qs = new QuickSort();
        qs.quickSort(num);
        System.out.println(Arrays.toString(num));
    }

    public void quickSort(int[] num){
        quickSort(num, 0, num.length-1);
    }

    public void quickSort(int[] num,int low,int high){
        int key;
        if (low<high){
            key = partition(num, low, high);
            quickSort(num, low,key-1);
            quickSort(num, key+1,high);
        }
    }

    public int partition(int[] num,int low,int high){
        int key;
        key = num[low];
        while (low<high){
            while (low<high&&num[high]>=key){
                high--;
            }
            int temp = num[low];
            num[low] = num[high];
            num[high] = temp;
            while (low<high&&num[low]<=key){
                low++;
            }
            temp = num[low];
            num[low] = num[high];
            num[high] = temp;
        }
        return low;
    }
}
