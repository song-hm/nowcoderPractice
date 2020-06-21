package com.shm.toOffer;

/**
 * 	二维数组中的查找
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindIn2DArray {

    /**
     * 一、暴力法
     * 1. 分析
     * 挨个遍历数组，如果找到就返回 true
     * 3. 复杂度
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {
        for(int i=0; i<array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                if(array[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/abc3fe2ce8e146608e868a70efebf62e?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 二、从左下找
     * 1. 分析
     * 利用该二维数组的性质：
     *
     * 每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序
     * 改变个说法，即对于左下角的值 m，m 是该行最小的数，是该列最大的数
     * 每次将 m 和目标值 target 比较：
     *
     * 当 m < target，由于 m 已经是该行最大的元素，想要更大只有从列考虑，取值右移一位
     * 当 m > target，由于 m 已经是该列最小的元素，想要更小只有从行考虑，取值上移一位
     * 当 m = target，找到该值，返回 true
     * 用某行最小或某列最大与 target 比较，每次可剔除一整行或一整列
     * 3. 复杂度
     * 时间复杂度：O(行高 + 列宽)
     * 空间复杂度：O(1)
     * @param target
     * @param array
     * @return
     */
    public boolean Find_2(int target, int [][] array) {
        int rows = array.length;
        if (rows == 0){
            return false;
        }
        int cols = array[0].length;
        if (cols == 0){
            return false;
        }
        //左下
        int row = array.length - 1;
        int col = 0;
        while (row >=0 && col < cols){
            if (array[row][col] < target){
                col++;
            }else if (array[row][col] > target){
                row--;
            }else {
                return true;
            }
        }
        return false;
    }

    /**
     * 三、从右上找
     * 1. 分析
     * 和从左下找道理一样，都是因为每次判断都能剔除一整行或一整列
     *2. 代码
     * 3. 复杂度
     * 时间复杂度：O(行高 + 列宽)
     * 空间复杂度：O(1)
     * @param target
     * @param array
     * @return
     */
    public boolean Find_3(int target, int [][] array) {
        int rows = array.length;
        if (rows == 0){
            return false;
        }
        int cols = array[0].length;
        if (cols == 0){
            return false;
        }
        //右上
        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0){
            if (array[row][col] < target){
                row++;
            }else if (array[row][col] > target){
                col--;
            }else{
                return true;
            }
        }
        return false;
    }

}
