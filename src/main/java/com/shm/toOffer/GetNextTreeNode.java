package com.shm.toOffer;

import java.util.ArrayList;

/**
 * 题目描述
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class GetNextTreeNode {

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/9023a0c988684a53960365b889ceaf5e?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 2. 直接找下一结点
     * 1. 分析
     * 以该二叉树为例，中序遍历为：{D,B,H,E,I,A,F,C,G}
     *
     * 仔细观察，可以把中序下一结点归为几种类型：
     *
     * 有右子树，下一结点是右子树中的最左结点，例如 B，下一结点是 H
     *
     * 无右子树，且结点是该结点父结点的左子树，则下一结点是该结点的父结点，例如 H，下一结点是 E
     *
     * 无右子树，且结点是该结点父结点的右子树，则我们一直沿着父结点追朔，直到找到某个结点是其父结点的左子树，如果存在这样的结点，
     * 那么这个结点的父结点就是我们要找的下一结点。例如 I，下一结点是 A；例如 G，并没有符合情况的结点，所以 G 没有下一结点
     * 3. 复杂度：
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
//        if (pNode != null && pNode.left !=null){
//            return pNode.left;
//        }else if (pNode.next != null){
//            return pNode.next;
//        }else if (pNode.right != null){
//            return pNode.right;
//        }else {
//            return null;
//

        if (pNode.right != null){
            TreeLinkNode pRight = pNode.right;
            while (pRight.left != null){
                pRight = pRight.left;
            }
            return pRight;
        }

        if (pNode.next != null && pNode.next.left == pNode){
            return pNode.next;
        }

        if (pNode.next != null){
            TreeLinkNode pNext = pNode.next;
            while (pNext.next != null && pNext.next.right == pNext){
                pNext = pNext.next;
            }
            return pNext.next;
        }
        return null;
    }

    ArrayList<TreeLinkNode> list = new ArrayList<>();

    /**
     * 1. 还原二叉树
     * 1. 分析
     * 既然给了二叉树的某个结点，且二叉树存储着指向父结点的指针（next），那我们可以先找到根节点，再对树进行中序遍历，
     * 最后根据中序遍历结果找到给定结点的下一结点
     * 3. 复杂度
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext_2(TreeLinkNode pNode)
    {
        TreeLinkNode par = pNode;
        while (par.next != null){
            par = par.next;
        }
        InOrder(par);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == pNode){
                return i==list.size()-1?null:list.get(i+1);
            }
        }
        return null;
    }

    void InOrder(TreeLinkNode par){
        if (par != null){
            InOrder(par.left);
            list.add(par);
            InOrder(par.right);
        }
    }
}
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}