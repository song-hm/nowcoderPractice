package com.shm.toOffer;

/**
 * 【剑指offer】从尾到头打印链表 -- Java实现
 * 题目描述
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */

import java.util.ArrayList;

/**
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 */
public class PrintListFromTailToHead {
    public class ListNode {
         int val;
         ListNode next = null;

         ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/d0267f7f55b3412ba93bd35cfa8e8035?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 1. 分析
     * listNode 是链表，只能从头遍历到尾，但是输出却要求从尾到头，这是典型的"先进后出"，我们可以想到栈！
     * ArrayList 中有个方法是 add(index,value)，可以指定 index 位置插入 value 值
     * 所以我们在遍历 listNode 的同时将每个遇到的值插入到 list 的 0 位置，最后输出 listNode 即可得到逆序链表
     *
     * 2. 代码
     * 3. 复杂度
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while(listNode != null){
            list.add(0,listNode.val);
            listNode = listNode.next;
        }
        return list;
    }


    /**
     * 二、递归
     * 1. 分析
     * 既然非递归都实现了，那么我们也可以利用递归，借助系统的"栈"帮忙打印
     *
     * 2. 代码
     * 3. 复杂度
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead_2(ListNode listNode) {
        if(listNode != null){
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}
