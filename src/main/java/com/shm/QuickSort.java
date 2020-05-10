package com.shm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 快速排序
 */
public class QuickSort <T extends Comparable<T>> extends Sort<T>{
    public static void main(String[] args) {
        Integer[] array = new Integer[]{5, 3, 8, 6, 9, 2, 1, 7};
        QuickSort qs = new QuickSort();
        qs.sort(array);
        System.out.println(Arrays.toString(array));
    }

    @Override
    public void sort(T[] nums){
        shuffle(nums);
        sort(nums,0, nums.length-1);
    }


    private void sort(T[] nums,int l,int h){
        if (h<=l){
            return;
        }
//        int j = partition(nums,l,h);
        int j = partition_2(nums,l,h);

        sort(nums,l,j-1);
        sort(nums,j+1,h);
    }

    private void shuffle(T[] nums){
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }

    private int partition(T[] nums,int l,int h){
        int i = l;
        int j = h+1;
        T v = nums[l];
        while (true){
            while (less(nums[++i],v) && i!=h){};
            while (less(v,nums[--j]) && j!=l){};
            if (i>=j){
                break;
            }
            swap(nums,i,j);
        }
        swap(nums,l,j);
        return j;
    }

    private int partition_2(T[] nums,int low,int high){
        T pivotKey = nums[low];
        while (low < high){
            while (low < high && less(pivotKey,nums[high])){
                high--;
            }
            swap(nums,low,high);
            while (low < high && less(nums[low],pivotKey)){
                low++;
            }
            swap(nums,low,high);
        }
        return low;
    }
}
