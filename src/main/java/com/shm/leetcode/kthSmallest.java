package com.shm.leetcode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 378. 有序矩阵中第K小的元素
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 * 示例：
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 * 提示：
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
 *
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 */
public class kthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length,cols = matrix[0].length;
        int[] sorts = new int[rows*cols];
        int m = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sorts[m++] = matrix[i][j];
            }
        }
        Arrays.sort(sorts);
        return sorts[k-1];
    }

    public int kthSmallest_2(int[][] matrix, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{matrix[i][0],i,0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = queue.poll();
            if (now[2] != n-1){
                queue.offer(new int[]{matrix[now[1]][now[2]+1],now[1],now[2]+1});
            }
        }
        return queue.poll()[0];
    }
}
