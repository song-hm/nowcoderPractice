package com.shm.toOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称的二叉树
 * 题目描述
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class IsSymmetricalTree {
    boolean isSymmetrical_1(TreeNode pRoot) {
        if (pRoot.left == null && pRoot.right == null) {
            return true;
        } else if (pRoot.left == null || pRoot.right == null) {
            return false;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        if (pRoot.left != null && pRoot.right != null) {

            queue1.add(pRoot.left);
            queue2.add(pRoot.right);

            while (queue1.peek() != null && queue2.peek() != null) {
                TreeNode node1 = queue1.poll();
                TreeNode node2 = queue2.poll();
                if (node1.val != node2.val) {
                    return false;
                } else {
                    if (node1.left != null) {
                        queue1.add(node1.left);
                    }
                    if (node1.right != null) {
                        queue1.add(node1.right);
                    }
                    if (node2.right != null) {
                        queue2.add(node2.right);
                    }
                    if (node2.left != null) {
                        queue2.add(node2.left);
                    }
                }
            }
            return true;
        }
        return false;
    }

    boolean isSymmetrical_2(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(pRoot.left);
        queue2.add(pRoot.right);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1 == null && node2 == null) {
                continue;
            } else if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }

            // 左子树从左往右添加节点
            queue1.add(node1.left);
            queue1.add(node1.right);

            // 右子树从右往左添加节点
            queue2.add(node2.right);
            queue2.add(node2.left);
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/ff05d44dfdb04e1d83bdbdab320efbcb?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 若满足对称二叉树，必须满足：
     *
     * 1. L->val == R->val
     * 2. L->left->val == R->right->val
     * 3. L->right->val == R->left->val
     * 因此可以自顶向下，递归求解即可。
     *
     * 设置一个递归函数isSame(r1, r2),表示如果对称，返回true，否则返回false
     * 递归终止条件：r1==nullptr && r2==nulllptr, 直接返回true，否则，如果只有一个为nullptr，返回false
     * 下一步递归：如果r1->val == r2->val, 则isSame(root1->left, root2->right) && isSame(root1->right, root2->left);
     * @param node1
     * @param node2
     * @return
     */
    boolean jude(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        } else {
            return jude(node1.left, node2.right) && jude(node1.right, node2.left);
        }
    }

    boolean isSymmetrical(TreeNode pRoot) {
        return pRoot == null || jude(pRoot.left, pRoot.right);
    }
}
