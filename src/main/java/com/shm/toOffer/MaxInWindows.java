package com.shm.toOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 滑动窗口的最大值
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 */
public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        int len = num.length;
        ArrayList<Integer> res = new ArrayList<>();
        if (size < 1 || len < size){
            return res;
        }
        for (int i = 0; i <= len - size; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = i; j < i+size; j++) {
                list.add(num[j]);
            }
            for (int j = 0; j <list.size()-1; j++) {
                if (list.get(j) >list.get(j+1)){
                    Integer temp = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                }
            }
            res.add(list.get(size-1));
        }
        return res;
    }

    /**
     * ：用一个大顶堆，保存当前滑动窗口中的数据。滑动窗口每次移动一格，就将前面一个数出堆，后面一个数入堆。
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows_2(int [] num, int size) {
        int len = num.length;
        ArrayList<Integer> res = new ArrayList<>();
        if (size < 1 || len < size) {
            return res;
        }
//        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
        //大顶堆
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1,o2) -> o2-o1);
        int count = 0;
        //初始化滑动窗口
        for (; count < size; count++) {
            maxQueue.offer(num[count]);
        }
        //对每次操作，找到最大值（用优先队列的大顶堆），然后向后滑动（出堆一个，入堆一个）
        while (count<len){
            res.add(maxQueue.peek());
            maxQueue.remove(num[count-size]);
            maxQueue.add(num[count]);
            count++;
        }
        //最后一次入堆后没保存结果，这里额外做一次即可
        res.add(maxQueue.peek());
        return res;
    }

    /**
     * 使用双端队列保存数组的下标，便于过期处理
     * 思路：如果当前下标的值大于队列中最右边的值就循环将最右边的值poll掉，保证最左边的值是当前窗口的最大值的下标，
     * 当然还要判断是否过期，过期就将该值弹出
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows_3(int [] num, int size) {
        int len = num.length;
        ArrayList<Integer> res = new ArrayList<>();
        if (size < 1 || len < size) {
            return res;
        }
        LinkedList<Integer> list = new LinkedList();
        for (int i = 0; i < len; i++) {
            while (!list.isEmpty() && num[list.peekLast()]< num[i]){
                list.pollLast();
            }
            list.add(i);
            //判断左边是否失效
            if (list.peekFirst() <= i-size){
                list.pollFirst();
            }
            if (i>=size-1){
                res.add(num[list.peekFirst()]);
            }
        }
        return res;
     }
}
