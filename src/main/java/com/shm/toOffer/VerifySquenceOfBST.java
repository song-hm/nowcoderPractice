package com.shm.toOffer;

/**
 *  举例让抽象具体化	二叉搜索树的后序遍历序列
 *  题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {

    /**
     * java中数组可以为null，也可以为[]，这个和c、c++语言空即null是不同的，需要额外注意一下
     * 链接：https://www.nowcoder.com/questionTerminal/a861533d45854474ac791d90e447bafd?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 一棵 BST ：左孩子 < 根结点 < 右孩子
     *
     * 一棵 BST 的左子树或者右子树都是 BST
     *
     * 后序遍历是，左右根：[3, 4, 9, 5, 12, 11, 10]，结合图再从左往右分析后序序列，分析子树，可以发现：
     *
     * [3, 4, 9, 5] 10 [12, 11]
     * [3, 4] 5 [9]
     * [3] 4
     * [12] 11
     * 发现对于每一棵子树，它的根结点总是对应该子树的后序序列的最后一个数
     *
     * 那么，只需要不断地确定出左子树区间和右子树区间，并且判断：左子树区间的所有结点值 < 根结点值 < 右子树区间所有结点值，这个条件是否满足即可
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0){
            return false;
        }
        return IsBST(sequence,0,sequence.length-1);
    }

    public boolean IsBST(int[] arr,int start,int root){
        if (start >= root){
            return true;
        }
        int key = arr[root];
        int right = start;
        //找到左右子数的分界点
        for (;right<root;right++){
            if (arr[right] > key){
                break;
            }
        }
        //在右子树中判断是否含有小于root的值，如果有返回false
        for (int j=right;j<root;j++){
            if (arr[j]<key){
                return false;
            }
        }
        return IsBST(arr,start,right-1) && IsBST(arr,right,root-1);
    }
}
