package com.shm.toOffer;

import java.util.HashMap;

/**
 * 分解让复杂问题简单	复杂链表的复制
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 */
public class CloneRandomListNode {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {

        if (pHead == null){
            return null;
        }
        //作为将要返回的头，记住要new的
        RandomListNode head = new RandomListNode(pHead.label);
        //获取链表头
        RandomListNode temp = pHead;
        //获取链表头
        RandomListNode p = pHead;
        //获取新链表头
        RandomListNode q = head;
        //用map保存旧节点和新节点之间的映射关系
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        //将所有值存入map，每一个结点都要new的
        while (temp != null) {
            map.put(temp,new RandomListNode(temp.label));
            temp = temp.next;
        }
        // head作为新链表的头，由p,q移动来复制链表
        while (p!=null){
            q.next = map.get(p.next);
            q.random = map.get(p.random);
            p = p.next;
            q = q.next;
        }
        return head;
    }

    /**
     *解题思路：
     *1、遍历链表，复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
     *2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
     *3、拆分链表，将链表拆分为原链表和复制后的链表
     */
    public RandomListNode Clone_2(RandomListNode pHead) {
        if (pHead == null){
            return null;
        }
        RandomListNode p = pHead;
        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while (p != null){
            RandomListNode temp = new RandomListNode(p.label);
            RandomListNode next = p.next;
            temp.next = next;
            p.next = temp;
            p = next;
        }

        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        p = pHead;
        while (p != null){
            p.next.random = p.random == null ?null:p.random.next;
            p = p.next.next;
        }

        //3、拆分链表，将链表拆分为原链表和复制后的链表
        p = pHead;
        RandomListNode pClone = p.next;
        while (p!=null){
            RandomListNode cloneN = p.next;
            p.next = cloneN.next;
            cloneN.next = cloneN.next == null ?null :cloneN.next.next;
            p = p.next;
        }
        return pClone;
    }
}
