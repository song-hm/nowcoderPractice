package com.shm.toOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 举例让抽象具体化	从上往下打印二叉树
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintFromTopToBottom {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }


    /**
     * 链接：https://www.nowcoder.com/questionTerminal/7fe2212963db4790b57431d9ed259701?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 在Java中Queue是和List、Map同等级别的接口，LinkedList中也实现了Queue接口，该接口中的主要函数有：
     *
     * 容量不够或队列为空时不会抛异常：offer（添加队尾元素）、peek（访问队头元素）、poll（访问队头元素并移除）
     * 容量不够或队列为空时抛异常：add、element（访问队列元素）、remove（访问队头元素并移除）
     * 链接：https://www.nowcoder.com/questionTerminal/7fe2212963db4790b57431d9ed259701?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 每一次打印一个节点的时候，如果该节点有子节点，则把该节点的子节点放到一个队列的尾部。
     * 接下来到对队列的头部取出最早进入队列的节点放到ArrayList 中，重复前面的操作，直至队列中所有的节点都存到ArrayList中。
     * //思路：此题实际为二叉树的广度遍历，广度遍历必须借助其他的数据结构才能进行，比如最常见的Queue
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //list用来保存输出的节点
        ArrayList<Integer> list = new ArrayList<>();
        //queue用来保存当前遍历到了哪个节点，一次性把一个节点的左右子都入队
        Queue<TreeNode> queue = new LinkedList<>();
        //注意：空树返回一个默认构造的空LinkedList，而不是一个空指针null
        if (root == null){
            return list;
        }
        queue.offer(root);
        TreeNode curr = root;
        //只要队列中还有节点就说明还没遍历完，继续。
        //每次从队列出队，然后将这个节点左右子入队列（FIFO，故能完成广度/层级遍历），再将这个节点记录在list中即可。
        while (!queue.isEmpty()){
            curr = queue.poll();
            list.add(curr.val);
            //有左子则入队
            if (curr.left != null){
                queue.offer(curr.left);
            }
            if (curr.right != null){
                queue.offer(curr.right);
            }
        }
        return list;
    }
}
