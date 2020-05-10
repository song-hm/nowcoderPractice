package com.shm.toOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 知识迁移能力	二叉树的深度
 * 题目描述
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class TreeDepth {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/435fb86331474282a3499955f0a41e8b?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 二叉树：二叉树是每个结点最多有两个子树的树结构。通常子树被称作“左子树”（left subtree）和“右子树”（right subtree）。二叉树常被用于实现二叉查找树和二叉堆。
     * 题目：求二叉树的深度，从根节点到字节点的最长路径。
     */
    /**
     *递归求法：
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);

        return Math.max(left,right)+1;
    }

    /**借助队列，对二叉树进行层次遍历；
     * 非递归：利用队列，count是当前的节点，nextcount是当前深度总的节点。
     * 【总是要遍历到当前深度的最后一个节点，深度才加1】
     * @param root
     * @return
     */
    public int TreeDepth_2(TreeNode root) {
        if (root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int d=0,count = 0,nextCount=queue.size();
        while (queue.size()!=0){
            TreeNode r = queue.poll();
            count++;
            if (r.left != null){
                queue.add(r.left);
            }
            if (r.right != null){
                queue.add(r.right);
            }
            if (count==nextCount){
                d++;
                count=0;
                nextCount= queue.size();
            }
        }
        return d;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}