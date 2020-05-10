package com.shm.toOffer;

/**知识迁移能力	平衡二叉树
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 *
 */
public class IsBalancedTree {
    /**
     * 之前是因为自己对平衡二叉树对定义不是很清楚：平衡二叉树的左右子树也是平衡二叉树，那么所谓平衡就是左右子树的高度差不超过1.
     * @param root
     * @return
     */
    int TreeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = TreeDepth(root.left);
        //如果发现子树不平衡之后就没有必要进行下面的高度的求解了
        if (left == -1){
            return -1;
        }
        int right = TreeDepth(root.right);
        //如果发现子树不平衡之后就没有必要进行下面的高度的求解了
        if (right == -1){
            return -1;
        }
        if ((left-right)<-1 || (left-right)>1){
            return -1;
        }else {
            return Math.max(left,right)+1;
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return TreeDepth(root) != -1;
    }
}
