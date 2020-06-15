package com.shm.toOffer;

import java.util.ArrayList;

/**
 * 二叉搜索树的第k个结点
 * 题目描述
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 *
 */
public class KthNodeOfTree {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        ArrayList<TreeNode> treeNodes = midIterator(pRoot);
        if (k>=1 && treeNodes.size() >= k){
            return treeNodes.get(k-1);
        }
        return null;

    }

    ArrayList<TreeNode> list = new ArrayList();
    // 中序遍历
    ArrayList<TreeNode> midIterator(TreeNode node){
        if (node != null){
            midIterator(node.left);
            list.add(node);
            midIterator(node.right);
        }
        return list;
    }
}
