package com.shm;

import java.util.Arrays;

/**
 * 三向切分
 * 对于有大量重复元素的数组，可以将数组切分为三部分，分别对应小于、等于和大于切分元素。
 * 三向切分快速排序对于有大量重复元素的随机数组可以在线性时间内完成排序。
 *
 * Java 的排序算法实现
 * Java 主要排序方法为 java.util.Arrays.sort()，对于原始数据类型使用三向切分的快速排序，对于引用类型使用归并排
 * 序。
 * @param <T>
 */
public class ThreeWayQuickSort<T extends Comparable<T>> extends QuickSort<T> {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{5, 3, 8, 6, 9, 2, 1, 7};
        ThreeWayQuickSort qs = new ThreeWayQuickSort();
        qs.sort(array);
        System.out.println(Arrays.toString(array));
    }

    public void sort(T[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int lt = l, i = l + 1, gt = h;
        T v = nums[l];
        while (i <= gt) {
            int cmp = nums[i].compareTo(v);
            if (cmp < 0) {
                swap(nums, lt++, i++);
            } else if (cmp > 0) {
                swap(nums, i, gt--);
            } else {
                i++;
            }
        }
        sort(nums, l, lt - 1);
        sort(nums, gt + 1, h);
    }
}