package com.shm.kujiale;

public class BubbleSort {
    void bubbleSort(int[] arr){
        int lastChange = 0;
        int sortBorder = arr.length-1;
        for (int i = 0; i < arr.length; i++) {
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSorted = false;
                    lastChange = j;
                }
            }
            sortBorder = lastChange;
            if (isSorted){
                break;
            }
        }
    }
}
