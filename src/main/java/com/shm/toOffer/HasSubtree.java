package com.shm.toOffer;

/**
 *  代码的鲁棒性	树的子结构
 *  题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }


    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null){
            return false;
        }
        return judgeSubTree(root1,root2) || judgeSubTree(root1.left,root2) || judgeSubTree(root1.right,root2);

    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/6e196c44c7004d15b1610b9afca8bd88?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 子树
     * 一棵大树 A，一棵小树 B，若 B 是 A 的子树，则：
     *
     * B 和 A 的结点值完全相同，它们俩的左子树、右子树所有结点的值也完全相同
     * 或者 B 的左孩子和 A 的结点值完全相同，它们俩的左子树、右子树所有结点的值也完全相同
     * 或者 B 的右孩子和 A 的结点值完全相同，它们俩的左子树、右子树所有结点的值也完全相同
     * 举个形象的例子：
     * 这棵大树的子树有：
     *
     * 4 和 5 对应的两棵子树
     * 3 本身自己完整的一棵树
     * 而里面的小框圈出来的不是 3 这棵大树的子树！
     *
     * 理解后可以写代码了，如果子树先达到 null ，那么一定是其子树
     * @param root1
     * @param root2
     * @return
     */
    public boolean judgeSubTree(TreeNode root1,TreeNode root2){
        if (root2 == null){
            return true;
        }
        if (root1 == null){
            return false;
        }
        if (root1.val != root2.val){
            return false;
        }
        return judgeSubTree(root1.left,root2.left) && judgeSubTree(root1.right,root2.right);
    }

    /**
     * 子结构
     * 还是上面那张图，子结构就是不用那么严格，图中的小框就是整棵树的子结构，图中的黄色大框也是整棵树的子结构，所以只要找到符合树的一部分树结点即可
     *
     * 链接：https://www.nowcoder.com/questionTerminal/6e196c44c7004d15b1610b9afca8bd88?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 可以看到，子结构的判断就是 “没那么严格” 了，和判断子树的写法就是一行代码不同而已，值不想等的时候不直接返回 false，继续往树的右结点和左结点找，找的一个相等值的结点就好，但如果你一旦找到了结点值是相等的，那么久要保证这两个数的结点值要一一对应上了！
     * @param root1
     * @param root2
     * @return
     */
    public boolean judgeSubTree_2(TreeNode root1,TreeNode root2){
        if (root2 == null){
            return true;
        }
        if (root1 == null){
            return false;
        }
        if (root1.val != root2.val){
            return judgeSubTree_2(root1.left,root2) || judgeSubTree_2(root1.right,root2);
        }
        return judgeSubTree_2(root1.left,root2.left) && judgeSubTree_2(root1.right,root2.right);
    }
}
