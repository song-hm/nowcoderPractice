package com.shm.toOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 * 题目描述
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class GetMedianMidNum {

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/9be0172896bd43948f8a32fb954e1be1?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 方法一：暴力方法
     * 对于一组数据，我们可以用vector<int> arr来存取。如果对vector排好序，则很容易求出中位数。如果vector的大小为sz。
     *
     * 如果sz为奇数，假如为3，即[0 1 2]，则中位数就是中间的那个数arr[1]。
     * 如果sz为偶数，假如为4，即[0 1 2 3], 则中位数就是中间两个数的加权平均数。即 (arr[1] + arr[2]) / 2
     * 时间复杂度：Insert()为O(1), GetMedian()为O(nlogn)
     * 空间复杂度：O(n)
     */
    ArrayList<Integer> list = new ArrayList<>();
    public void Insert(Integer num) {
        list.add(num);
    }
    public Double GetMedian() {
        Collections.sort(list);
        int len = list.size();
        if(len == 0){
            return null;
        }
        if (len%2 == 0){
            return (double) (list.get(len/2-1) + list.get(len/2 )) /2;
        }else {
            return new Double(list.get(len/2));
        }
    }


    /**
     * 链接：https://www.nowcoder.com/questionTerminal/9be0172896bd43948f8a32fb954e1be1?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 首先按照我们的尝试，中位数奇数正好前后对半，取出来即可。偶数呢，前后难以对半，只能折中，取靠近中间的两个数之和求均值。
     *
     * 没错，这一题也是如此。但是如何动态的求均值呢。如何在任意时刻都能够直接拿到我们想要的均值而不去计算下标取值呢？百思不得其解。
     *
     * 参考他人的想法，使用优先队列PriorityQueue，然后问题就变得很简单了。
     *
     * 这一题主要的思想是利用优先队列，优先队列分为大顶堆和小顶堆，默认维护的是小顶堆的优先队列。
     *
     * 思路：
     *
     * 需要求的是中位数，如果我将 1 2 3 4 5 6 7 8定为最终的数据流
     * 此时的中位数是4+5求均值。为什么是4，为什么是5
     * 利用队列我们就可以看得很清楚，4是前半部分最大的值，肯定是维系在大顶堆
     * 而5是后半部分的最小值，肯定是维系在小顶堆。
     * 问题就好理解了：
     * 使用小顶堆存大数据，使用大顶堆存小数据。这样堆顶一取出就是中位数了。
     * 代码中奇数时刻大顶堆存值，所以遇到奇数时刻，大顶堆直接弹出就是中位数
     */
    private int cnt = 0;
    //小顶堆，用该堆记录位于中位数后面的部分
    private PriorityQueue<Integer> minHeap = new PriorityQueue();

    //大顶堆，用该堆记录位于中位数前面的部分
    private PriorityQueue<Integer> maxHeap = new PriorityQueue(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    public void Insert_2(Integer num) {
        cnt++;
        if (cnt%2==0){
            maxHeap.offer(num);
            int max = maxHeap.poll();
            minHeap.offer(max);
        }else {
            minHeap.offer(num);
            int min = minHeap.poll();
            maxHeap.offer(min);
        }
    }
    public Double GetMedian_2() {
        if (cnt%2 == 0){
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }else {
            return (double)maxHeap.peek();
        }
    }
}
