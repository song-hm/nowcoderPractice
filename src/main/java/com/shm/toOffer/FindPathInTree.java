package com.shm.toOffer;

import java.util.ArrayList;

/**
 * 举例让抽象具体化	二叉树中和为某一值的路径
 * 题目描述
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPathInTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    /**
     *
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null){
            return result;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left==null && root.right==null){
            result.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);
        return result;
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/b736e784e3e34731af99065031301bca?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 这道题的思路无非是树的深度优先遍历
     *
     * 我的思路是递归：递归方法是返回当前路径下匹配目标值的路径。
     * 目标值 = 目标值 - 当前节点值
     * 共有几种情况：
     * 0，当节点为空，return
     * 1，当目标值小于0，return
     * 2，当目标值为0 并且 节点下无其他节点
     * 节点下无其他节点说明是叶子节点，并且路径值的和满足了目标值，添加到结果中  并且return
     * 3，当目标值大于0，继续递归
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath_2(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        if (root==null){
            return paths;
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        this.find(root,target,paths,path);
        return paths;
    }

    public void find(TreeNode root,int target,ArrayList<ArrayList<Integer>> paths,ArrayList<Integer> path){
        // 0，当节点为空，return
        if (root == null){
            return;
        }
        target -= root.val;
        path.add(root.val);
        // 1，当目标值小于0，return
        if (target < 0){
            return;
        }
        // 2，当目标值为0 并且 节点下无其他节点, 保存并返回
        if (target == 0 && root.left==null && root.right==null){
            paths.add(path);
            return;
        }

        // 继续遍历左右节点
        // 这里new path是因为左右都会在下次递归path.add(root.val);
        find(root.left,target,paths,new ArrayList<Integer>(path));
        find(root.right,target,paths,new ArrayList<Integer>(path));
    }
}
