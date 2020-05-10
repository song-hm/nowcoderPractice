package com.shm.toOffer;

import java.util.ArrayList;

/**
 * 分解让复杂问题简单	二叉搜索树与双向链表
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class ConvertTree2LinkList {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 思路是这样，中序遍历二叉树，然后用一个ArrayList类保存遍历的结果，
     * 这样在ArratList中节点就按顺序保存了，然后再来修改指针，
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        Convert(pRootOfTree,list);
        return Convert(list);
    }

    //中序遍历，在list中按遍历顺序保存
    public ArrayList<TreeNode> Convert(TreeNode root,ArrayList<TreeNode> list){
        if (root.left != null){
            Convert(root.left,list);
        }
        list.add(root);
        if (root.right != null){
            Convert(root.right,list);
        }
        return list;
    }

    //遍历list，修改指针
    public TreeNode Convert(ArrayList<TreeNode> list){
        for (int i=0;i<list.size()-1;i++){
            list.get(i).right = list.get(i+1);
            list.get(i+1).left = list.get(i);
        }
        return list.get(0);
    }

    /**
     * 我们知道二叉排序树中序遍历的结果是排好序的，然后再想到线索化二叉树的过程，
     * 很容易联想到用线索化二叉树的方法去做，用一个全局变量去保存前一个节点，
     * 然后再去创建节点之间的关系（这里区别与线索化二叉树的是，
     * 线索化二叉树创建节点之间的关系是在节点的左右孩子为空的时候采取创建，
     * 这样二叉树还是二叉树。但是这里就不是，只要pre不空，就创建关系，创建后就是链表了，二叉树被破坏了）。
     */
    TreeNode pre = null;
    TreeNode root = null;
    public TreeNode Convert_2(TreeNode pRootOfTree) {
        if (pRootOfTree == null){
            return null;
        }
        Convert_2(pRootOfTree.left);
        if (root == null){
            root = pRootOfTree;
        }
        if (pre != null){
            pRootOfTree.left = pre;
            pre.right = pRootOfTree;
        }
        pre = pRootOfTree;
        Convert_2(pRootOfTree.right);
        return root;
    }

    /**
     * 我们受到惯性思维的约束，每次都是想着中序遍历先遍历左子树，再遍历根节点，再遍历右子树。
     * 那既然第二种方法得到的二叉树是降序的，那我
     * 先遍历右子树，再遍历根节点，再遍历左子树
     */
//    TreeNode pre = null;
    public TreeNode Convert_3(TreeNode pRootOfTree) {
        if (pRootOfTree == null){
            return null;
        }
        Convert_3(pRootOfTree.right);
        if (pre != null){
            pRootOfTree.right = pre;
            pre.left = pRootOfTree;
        }
        pre = pRootOfTree;
        Convert_3(pRootOfTree.left);
        return pre;
    }

}
