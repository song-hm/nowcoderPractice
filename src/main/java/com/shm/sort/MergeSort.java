package com.shm.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    static int[] aux;
//    static int count = 0;

    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 8, 6, 9, 2, 1, 7};
//        Up2DownMergeSort(array);
        Down2UpMergeSort(array);
        System.out.println(Arrays.toString(array));
//        System.out.println(count);
    }

//    public static int InversePairs_2(int [] array) {
//        if (array == null || array.length == 0){
//            return 0;
//        }
//        Up2DownMergeSort(array);
//        return count%1000000007;
//    }

    //递归(自顶向下)
    public static void Up2DownMergeSort(int[] nums) {
        aux = new int[nums.length];
        MSort(nums, 0, nums.length - 1);
    }

    public static void MSort(int[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int mid = l + (h - l) / 2;
        MSort(nums, l, mid);
        MSort(nums, mid + 1, h);
        merge(nums, l, mid, h);

    }

    //非递归（自底向上）
    public static void Down2UpMergeSort(int[] nums){
        aux = new int[nums.length];
        for (int s = 1;s<nums.length;s+=s){
            for (int l = 0;l<nums.length-s;l+=s+s){
                merge(nums,l,l+s-1,Math.min(l+s+s-1,nums.length-1));
            }
        }
    }

    public static void merge(int[] nums, int i, int m, int n) {
        int j, k, l;

        // 将数据复制到辅助数组
        for (int p = i; p <= n; p++) {
            aux[p] = nums[p];
        }

        //将aux中的记录由小到大归并入nums
        for (k = i, j = m + 1; i <= m && j <= n; k++) {
            if (aux[i] < aux[j]) {
                nums[k] = aux[i++];
            } else {
                nums[k] = aux[j++];
//                count += (m-i+1);
            }
        }
        if (i <= m) {
            //将剩余的aux[i..m]复制到nums
            for (l = 0; l <= m - i; l++) {
                nums[k + l] = aux[i + l];
            }
        }
        if (j <= n) {
            //将剩余的aux[j..n]复制到nums
            for (l = 0; l <= n - j; l++) {
                nums[k + l] = aux[j + l];
            }
        }

    }

}
