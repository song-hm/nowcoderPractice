package com.shm.toOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 按之字形顺序打印二叉树
 * 题目描述
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintTree {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (pRoot == null){
            return arrayLists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right !=null) {
                queue.add(node.right);
            }
        }
        int k = (int)Math.sqrt(list.size()+1) -1;

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(list.get(0));
        arrayLists.add(list1);
        for (int i = 1; i <= k; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            if (i%2 == 0){
                for (int j = (int)Math.pow(2,i-1); j <=Math.pow(2 ,i+1)-2;j++){
                    arrayList.add(list.get(j));
                }

            }else {
                for (int j = (int)Math.pow(2 ,i+1)-2; j > Math.pow(2,i-1); j--) {
                    arrayList.add(list.get(j));
                }
            }
            arrayLists.add(arrayList);
        }
        return arrayLists;
    }


    /**
     * 链接：https://www.nowcoder.com/questionTerminal/91b69814117f4e8097390d107d2efbe0?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 主要的方法与BFS写法没什么区别
     * BFS里是每次只取一个，而我们这里先得到队列长度size，这个size就是这一层的节点个数，然后通过for循环去poll出这size个节点，这里和按行取值二叉树返回ArrayList<ArrayList<Integer>>这种题型的解法一样，之字形取值的核心思路就是通过两个方法：
     * list.add(T): 按照索引顺序从小到大依次添加
     * list.add(index, T): 将元素插入index位置，index索引后的元素依次后移,这就完成了每一行元素的倒序，或者使用Collection.reverse()方法倒序也可以
     * 链接：https://www.nowcoder.com/questionTerminal/91b69814117f4e8097390d107d2efbe0?answerType=1&f=discussion
     * 来源：牛客网
     *
     * //解题思路：其实就是二叉树的层级遍历，不过是在遍历的时候，需要将偶数层的节点逆序。
     *     //关键点：每次只处理上次在queue中剩余的节点，这是上一层的所有节点。
     *     //       处理完后刚好将下一层的所有节点（包含null）又全部放了进去。
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print_1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean rev = true;
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null){
                    continue;
                }
                if (rev){
                    list.add(node.val);
                }else {
                    //每次加到0的位置，就自动逆序了
                    list.add(0,node.val);
                }
                queue.add(node.left);
                queue.add(node.right);
            }
            if (list.size() != 0){
                arrayLists.add(list);
            }
            rev = !rev;
        }
        return arrayLists;
    }
}
