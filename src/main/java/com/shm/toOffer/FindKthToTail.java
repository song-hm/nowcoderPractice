package com.shm.toOffer;

/**
 *  代码的鲁棒性	链表中倒数第k个结点
 *  题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     *
     * 解法 1: 两次循环
     * 因为要求链表倒数第 k 个节点，也就是求正数第length - k个节点。整体过程如下：
     *
     * 链表又是个单链表，并且没有保存长度信息。所以需要循环一次计算length。
     * 第二次循环找到第length - k个节点。
     * 时间复杂度是 O(N)，需要 2 次循环。
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {

        ListNode p = head;
        int size = 0;
        while(p != null){
            size++;
            p = p.next;
        }
        int count = size-k;
        if(count<0){
            return null;
        }
        ListNode q = head;
        for(int i=count;i>0;i--){
            q = q.next;
        }

        return q;
    }


    /**
     * 链接：https://www.nowcoder.com/questionTerminal/529d3ae5a407492994ad2a246518148a?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 解法 2: 快慢(双)指针
     * 准备两个指针：left（慢）和 right（快）。整体过程如下：
     *
     * right 先向右移动 k 位，此时 index(right) - index(left) = k
     * left 和 right 一起向右移动，直到 right 抵达边界
     * 由于index(right) - index(left) = k，所以index(left) = index(right) - k = length - k。也就是 left 指针移动到了倒数第 k 个位置
     * 时间复杂度是 O(N)，但仅需要遍历一次。空间复杂度是 O（1）
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail_2(ListNode head,int k) {
        ListNode fast = head;
        ListNode slow = head;
        for(int i=k;i>0;i--){
            if(fast == null){
                return null;
            }
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}
