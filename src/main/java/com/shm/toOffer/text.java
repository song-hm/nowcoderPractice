package com.shm.toOffer;

public class text {
    int count = 9;
    public void a(){
        int count = 10;
        System.out.println("count1="+count);
    }
    public void count(){
        System.out.println("count2="+count);
    }

    public static void main(String[] args) {
//        text t = new text();
//        t.a();
//        t.count();
        byte bb1 = 126;
        byte bb2 = 5;
        bb1 = (byte)(bb1+bb2);
        System.out.println(bb1);

//        ListNode pHead = new ListNode(1);
//        pHead.next.val = 2;
//        pHead.next.next.val = 2;
//        pHead.next.next.next.val = 2;pHead.next.next.next.next.val = 3;


    }
//    public ListNode deleteDuplication(ListNode pHead)
//    {
//        ListNode p = pHead;
//        while(p.next != null){
//            ListNode q = p.next;
//            if(p.val == q.val){
//                while(p.val == q.val){
//                    if (q.next != null)
//                    q = q.next;
//                }
//                p.next = q.next;
//            }
//            p = p.next;
//        }
//        return pHead;
//    }
}
