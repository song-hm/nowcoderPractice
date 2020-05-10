package com.shm.toOffer;

import java.util.Arrays;

/**知识迁移能力	数字在排序数组中出现的次数
 * 题目描述
 * 统计一个数字在排序数组中出现的次数。
 *
 */
public class GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
        for (int i=0;i<array.length;i++){
            if (array[i] == k){
                count++;
            }
        }
        return count;
    }

    /**
     * 这道题目思路挺简单的，就是先二叉搜索（二分查找）找一下这个元素的位置，然后再开始遍历搜索一下。
     * 本来想自己写一个二叉搜索函数的，但是转念一下java中有排序，还是用一下吧，这样代码就简洁很多。
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK_2(int [] array , int k) {
        int index = Arrays.binarySearch(array,k);
        if (index<0){
            return 0;
        }
        int cnt = 1;
        for (int i=index+1;i<array.length&&array[i]==k;i++){
            cnt++;
        }
        for (int i=index-1;i>=0 && array[i]==k;i--){
            cnt++;
        }
        return cnt;
    }
}
