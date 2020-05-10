package com.shm.toOffer;

/**
 *  代码的鲁棒性	合并两个排序的链表
 *  题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeListNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 1.遍历两个链表，按大小顺序拼接。
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode p = list1;
        ListNode q = list2;
        ListNode result = new ListNode(-1);
        ListNode r = result;
        while (p != null && q != null){
            if (p.val<=q.val){
                r.next = p;
                p = p.next;
            }else{
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }
        if (p == null) {
            r.next = q;
        }
        if (q == null){
            r.next = p;
        }

        return result.next;
    }


    /**
     * //递归
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }else{
            if(list1.val<list2.val){
                list1.next=Merge1(list1.next, list2);
                return list1;
            }else {
                list2.next=Merge1(list1, list2.next);
                return list2;
            }
        }
    }
}
