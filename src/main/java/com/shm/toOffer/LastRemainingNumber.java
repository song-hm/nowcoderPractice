package com.shm.toOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**抽象建模能力	孩子们的游戏(圆圈中最后剩下的数)
 * 题目描述
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,
 * 继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 *
 * 如果没有小朋友，请返回-1
 *
 * commit:
 * Pass:
 */
public class LastRemainingNumber {
    public static void main(String[] args) {
        LastRemainingNumber l=new LastRemainingNumber();
        System.out.println(l.LastRemaining_Solution(5, 3));
    }

    public int LastRemaining_Solution(int n, int m) {
        if(n<1 || m<1)
            return -1;
        LinkedList<Integer> l=new LinkedList<>();
        for (int i=0;i<n;i++){
            l.add(i);
        }
        int temp=0;
        while (l.size()>1){
            temp = (m - 1 + temp) % l.size();
            l.remove(temp);
        }
        return l.get(0);
    }

    /**java中直接使用一个list来模拟，并使用一个索引cur类指向删除的位置，当cur的值为list的size，就让cur到头位置。
     *
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution_2(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int cur = -1;
        while (list.size() > 1) {
            for (int i = 0; i < m; i++) {
                cur++;
                if (cur == list.size()) {
                    cur = 0;
                }
            }
            list.remove(cur);
            //cur--的原因，因为新的list中cur指向了下一个元素，为了保证移动m个准确性，所以cur向前移动一位。
            cur--;
        }
        return list.get(0);
    }

    /**
     * 一种方法是用环形链表模拟圆圈的经典解法；
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution_3(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        ListNode listNode = new ListNode(0);
        ListNode head = listNode;
        for (int i = 1; i < n; i++) {
            head.next = new ListNode(i);
            head = head.next;
        }
        head.next = listNode;

        int k = 0;
        while (head.next != head){
            if (++k==m){
                head.next = head.next.next;
                k = 0;
            }else {
                head = head.next;
            }
        }
        return head.val;
    }
}

//class ListNode{
//    int val;
//    ListNode next = null;
//    ListNode(int val){
//        this.val = val;
//    }
//}