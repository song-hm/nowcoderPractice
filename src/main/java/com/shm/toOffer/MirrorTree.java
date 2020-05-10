package com.shm.toOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  面试思路	二叉树的镜像
 *  题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */
public class MirrorTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 思路很简单，交换左右子树的节点，然后递归调用该方法。
     * @param root
     */
    public void Mirror(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            Mirror(root.left);
            Mirror(root.right);
        }
    }

    /**
     * 队列
     * 思路：镜像就是将“根”节点的左右两个“子”节点互换，类似于数组的元素交换（运用临时节点temp）
     * 利用二叉树的广度优先搜索即可
     * @param root
     */
//    链接：https://www.nowcoder.com/questionTerminal/564f4c26aa584921bc75623e48ca3011?answerType=1&f=discussion
//    来源：牛客网
    public void Mirror_2(TreeNode root) {
        if(root == null){
            return;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode curr, temp;
        nodes.offer(root);
        while(!nodes.isEmpty()){
            int len = nodes.size();
            for(int i = 0; i < len; i++){
                curr = nodes.poll();
                temp = curr.left;
                curr.left = curr.right;
                curr.right = temp;
                if(curr.left != null) {
                    nodes.offer(curr.left);
                }
                if(curr.right != null) {
                    nodes.offer(curr.right);
                }
            }
        }
    }
}
