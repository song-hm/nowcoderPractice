package com.shm.toOffer;

import java.util.Stack;

/**
 * 代码的鲁棒性	反转链表
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法一：头节点插入法
     * 头结点插入法的实质是重新创建了一个新的链表，通过遍历待反转链表，将链表每一个节点插入到创建的链表中，然后的到的这个创建的链表就是反转后的链表。
     * 实现步骤：
     *
     * 创建一个带头节点的链表p
     * 定义一个循环链表变量q，q的初始值为待反转的链表
     * 遍历待反转的链表，遍历条件为 (q !=null)
     * 3.1 定义一个临时链表变量temp保存q.next的值（因为q.next值会改变），用于下一次循环。
     * 3.2 把q当前指向的首节点和p链表的头节点之后的节点拼接起来。
     * 3.3 把3.2步骤中拼接的节点 再拼接到p头节点后。
     * 3.4 p重新赋值为3.1步骤中保存的temp的值。
     * 返回p.next.即反转后的链表。
     * ————————————————
     * 版权声明：本文为CSDN博主「Super-小龙」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/superxiaolong123/article/details/86687733
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        ListNode p = new ListNode(-1);
        ListNode q = head;

        while (q != null){
            ListNode temp = q.next;
            q.next = p.next;
            p.next = q;
            q = temp;
        }
        return p.next;
    }

    /** 就地反转
     * 链接：https://www.nowcoder.com/questionTerminal/75e878df47f24fdc9dc3e400ec6058ca?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 以3个节点为例：
     *
     * 用pre记录当前节点的前一个节点
     *
     * 用next记录当前节点的后一个节点
     *
     * 当前节点a不为空，进入循环，先记录a的下一个节点位置next = b;再让a的指针指向pre
     *
     * 移动pre和head的位置，正因为刚才记录了下一个节点的位置，所以该链表没有断，我们让head走向b的位置。
     *
     * 当前节点为b不为空，先记录下一个节点的位置，让b指向pre的位置即a的位置，同时移动pre和head
     *
     * 当前节点c不为空，记录下一个节点的位置，让c指向b，同时移动pre和head，此时head为空，跳出，返回pre。
     * @param head
     * @return
     */
    public ListNode ReverseList_2(ListNode head) {
//         当前节点的前一个节点
        ListNode pre = null;
//        当前节点的下一个节点
        ListNode next = null;

        while (head != null){
//              记录当前节点的下一个节点位置；
            next = head.next;
            // 让当前节点指向前一个节点位置，完成反转
            head.next = pre;
            // pre 往右走
            pre = head;
            // 当前节点往右继续走
            head = next;
        }
        //当循环结束时,pre所指的就是反转链表的头结点
        return pre;
    }

    /**
     * 反转链表(递归实现)
     * @param head
     * @return
     */
    public ListNode ReverseList_3(ListNode head) {
        //如果链表为空或者链表中只有一个元素
        if (head == null || head.next==null){
            return head;
        }
        //先反转后面的链表，走到链表的末端结点
        ListNode p = ReverseList_3(head.next);

        //再将当前节点设置为后面节点的后续节点
        head.next.next = head;
        head.next = null;

        return p;
    }

    /**
     * 反转链表(栈)
     *
     * @param head
     * @return
     */
    public ListNode ReverseList_4(ListNode head) {
        //如果链表为空或者链表中只有一个元素
        if (head == null || head.next==null){
            return head;
        }
        ListNode p = head;
        Stack<ListNode> s = new Stack<ListNode>();
        while (p.next != null){
            s.push(p);
            p = p.next;
        }

        ListNode q = p;
        while (!s.empty()){
            p.next = s.peek();
            p = p.next;
            s.pop();
        }
        p.next = null;
        return q;
    }

}
