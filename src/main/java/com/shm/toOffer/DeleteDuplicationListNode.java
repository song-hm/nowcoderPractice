package com.shm.toOffer;

import java.util.HashSet;

/**	删除链表中重复的结点	链表
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 */
public class DeleteDuplicationListNode {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/fc533c45b73a41b0b44ccba763f866ef?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 2. 遍历的同时删除
     * 1. 分析
     * 借助辅助头结点，可避免单独讨论头结点的情况。设置两个结点 pre 和 cur，当 cur 和 cur.next 值相等，cur 一直向前走，
     * 直到不等退出循环，这时候 cur 指的值还是重复值，调整 cur 和 pre 的指针再次判断
     * 3. 复杂度
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null || pHead.next == null){
            return pHead;
        }
        // 自己构建辅助头结点
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode p = head;
        ListNode q = head.next;

        while (q !=null){
            if (q.next != null && q.next.val == q.val){
                // 相同结点一直前进
                while (q.next != null && q.next.val == q.val){
                    q = q.next;
                }

                // 退出循环时，q 指向重复值，也需要删除，而 q.next 指向第一个不重复的值
                // q 继续前进
                q = q.next;
                // p 连接新结点
                p.next = q;
            }else {
                p = q;
                q = q.next;
            }
        }
        return head.next;
    }

    /**
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication_2(ListNode pHead) {
        if (pHead == null || pHead.next == null){
            return pHead;
        }
        HashSet<Integer> set = new HashSet<>();
        ListNode pre = pHead;
        ListNode cur = pHead.next;
        while (cur != null){
            if (pre.val == cur.val){
                set.add(pre.val);
            }
            pre = pre.next;
            cur = cur.next;
        }

        while (pHead != null && set.contains(pHead.val)){
            pHead = pHead.next;
        }
        if (pHead == null){
            return null;
        }

        pre = pHead;
        cur = pHead.next;
        while (cur != null){
            if (set.contains(cur.val)){
                pre.next = cur.next;
                cur = cur.next;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return pHead;
    }

}
