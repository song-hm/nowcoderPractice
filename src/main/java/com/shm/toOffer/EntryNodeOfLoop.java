package com.shm.toOffer;

import java.util.HashMap;

/**链表中环的入口结点	链表
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {

        ListNode p = pHead;
        HashMap<ListNode,Integer> map = new HashMap<>();
        map.put(p,1);
        while (p.next != null){
            p = p.next;
            if (!map.containsKey(p)){
                map.put(p,1);
            }else {
                return p;
            }
        }
        return null;
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/253d2c59ec3e4bc68da16833f79a38e4?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 这题我们可以采用双指针解法，一快一慢指针。快指针每次跑两个element，慢指针每次跑一个。如果存在一个圈，总有一天，快指针是能追上慢指针的。
     * 如下图所示，我们先找到快慢指针相遇的点，p。我们再假设，环的入口在点q，从头节点到点q距离为A，q p两点间距离为B，p q两点间距离为C。
     * 因为快指针是慢指针的两倍速，且他们在p点相遇，则我们可以得到等式 2(A+B) = A+B+C+B. （感谢评论区大佬们的改正，此处应为：如果环前面的链表很长，而环短，那么快指针进入环以后可能转了好几圈(假设为n圈)才和慢指针相遇。但无论如何，慢指针在进入环的第一圈的时候就会和快的相遇。等式应更正为 2(A+B)= A+ nB + (n-1)C）
     * 由3的等式，我们可得，C = A。
     * 这时，因为我们的slow指针已经在p，我们可以新建一个另外的指针，slow2，让他从头节点开始走，每次只走下一个，原slow指针继续保持原来的走法，和slow2同样，每次只走下一个。
     * 我们期待着slow2和原slow指针的相遇，因为我们知道A=C，所以当他们相遇的点，一定是q了。
     * 我们返回slow2或者slow任意一个节点即可，因为此刻他们指向的是同一个节点，即环的起始点，q。
     *
     * 整体思路：
     *
     * 检测有没有环，使用快慢指针slow和fast（一次走两步）；
     * 找位置，当找到环之后，slow从head出发，fast从相遇点出发，一次都走一步，再次相遇为环的入口点
     * 证明为何第二步的方法能够找到入口点：
     * 令： m 表示从head到入口的距离， d表示入口到相遇点的距离, r表示环的长度，ls表示slow走的长度，lf表示fast走的长度
     * 有： ls = m + d, lf = m + d + n * r (n为正整数)， lf = 2 * ls
     * 则： m + d + n * r = 2 * (m + d)
     * 则： m = n * r - d， n >= 1
     *
     * 当n=1时，m = r - d, 即”head到入口的距离（m）“等于”相遇点到入口的距离(r - d)“， 使用第二步方法能找到入口点；
     * 当n=2时，m = 2 * r - d, 等价于： m = (r - d) + r, 即”head到入口的距离（m）“等于”相遇点到入口的距离（r - d）加环长度“， 使用第二步方法会让fast指针多走一个环的长度，然后slow和fast还会相遇在环入口
     * 当n>2时，同理。
     *
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle-lcci/solution/java-kuai-man-zhi-zhen-zhao-ru-kou-jie-dian-you-sh/
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop_2(ListNode pHead)
    {
        ListNode fast = pHead;
        ListNode slow = pHead;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                ListNode slow2 = pHead;
                while (slow2 != slow){
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow2;
            }
        }
        return null;
    }
}
