package com.shm.toOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化二叉树
 * 题目描述
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，
 * 序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 *
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 *
 * 例如，我们可以把一个只有根节点为1的二叉树序列化为"1,"，然后通过自己的函数来解析回这个二叉树
 *
 */
public class SerializeTree {
    String Serialize(TreeNode root) {
        if (root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node == null){
                sb.append("#!");
                continue;
            }else {
                sb.append(node.val).append("!");
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        return sb.toString();
    }
    TreeNode Deserialize(String str) {
        if (str.equals("")){
            return null;
        }
        String[] strings = str.split("!");
        Queue<TreeNode> queue = new LinkedList<>();
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(strings[i]));
        queue.add(root);
        i++;
        while (!queue.isEmpty() && i<strings.length){
            TreeNode node = queue.poll();
            if (strings[i].equals("#")){
               i++;
            }else {
                node.left = new TreeNode(Integer.parseInt(strings[i]));
                queue.add(node.left);
                i++;
            }
            if (strings[i].equals("#")){
                i++;
            }else {
                node.right = new TreeNode(Integer.parseInt(strings[i]));
                queue.add(node.right);
                i++;
            }
        }
        return root;
    }


    /**
     * 链接：https://www.nowcoder.com/questionTerminal/cf7e25aa97c04cc1a68c8f040e71fb84?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 题目要求很明确：
     *
     * 使用!来分割值value,使用#来代替null值
     *
     * 根据题意：（采用的是前序遍历，中左右）
     *
     * 1
     * 2 3
     * 4 5 6 7
     * 序列化之后的结果为：1!2!4!#!#!5!#!#!3!6!#!#!7!#!#!
     *
     * 序列化很简单，只需要在遇到null的时候添加#!号，遇到数值添加!即可
     *
     * 反序列化的时候，由于采用的是先序遍历，此时如果遇到了#号，我们知道左边结束了,要开启右边，
     * 如果再次遇到#,表示当前整个部分的左边结束了要开始右子树。。依次类推。
     * @param root
     * @return
     */
    String Serialize_pre(TreeNode root) {
        if (root == null){
            return "";
        }
        return preSerialize(root,new StringBuilder()).toString();
    }
    StringBuilder preSerialize(TreeNode node,StringBuilder sb){
        if (node == null){
            return sb;
        }
        sb.append(node.val).append("!");
        if (node.left != null){
            preSerialize(node.left,sb);
        }else {
            sb.append("#!");
        }
        if (node.right != null){
            preSerialize(node.right,sb);
        }else {
            sb.append("#!");
        }
        return sb;
    }
    // 设置全局主要是遇到了#号的时候需要直接前进并返回null
    int index = 0;
    TreeNode Deserialize_pre(String str) {
        if (str == null || str.length() == 0){
            return null;
        }
        String[] strings = str.split("!");
        return preDeserialize(strings);
    }
    TreeNode preDeserialize(String[] strings){
        if (strings[index].equals("#")){
            // 数据前进
            index++;
            return null;
        }
        // 当前值作为节点已经被用
        TreeNode root = new TreeNode(Integer.parseInt(strings[index]));
        // index++到达下一个需要反序列化的值
        index++;
        root.left = preDeserialize(strings);
        root.right = preDeserialize(strings);
        return root;
    }
}
