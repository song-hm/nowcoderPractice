package com.shm.toOffer;

/**
 * 代码的完整性	调整数组顺序使奇数位于偶数前面
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {

    /**
     * 思路： 开辟新数组保存法
     * @param array
     */
    public void reOrderArray(int [] array) {
        int[] re = new int[array.length];
        int j = 0;
        for(int i=0;i<array.length;i++){
            if(array[i]%2 == 1){
                re[j] = array[i];
                j++;
            }
        }
        int n = array.length-1;
        for (int m=array.length-1;m>=0;m--){
            if (array[m]%2 == 0){
                re[n] = array[m];
                n--;
            }
        }

        for (int i=0;i<re.length;i++){
            array[i] = re[i];
        }

    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/beb5aa231adc45b2a5dcc5b62c93f593?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 思路：参考快速排序
     *
     * i++往前走碰到偶数停下来，j = i+1
     * 若 a[j]为偶数，j++前进，直到碰到奇数
     * a[j]对应的奇数插到a[i]位置，j经过的j-i个偶数依次后移
     * 如果j==len-1时还没碰到奇数，证明i和j之间都为偶数了，完成整个移动
     * @param array
     */
    public void reOrderArray_2(int [] array) {
        int len = array.length;
        if (len <= 1){ // 数组空或长度为1
            return;
        }

        int i = 0;
        while (i<len) {
            int j = i + 1;
            if (array[i] % 2 == 0) {// a[i]为偶数，j前进，直到替换

                while (array[j] % 2 == 0) {// j为偶数，前进
                    if (j == len-1) {// i为偶数，j也为偶数，一直后移到了末尾，证明后面都是偶数
                        return;
                    }
                    j++;
                }
                // 此时j为奇数
                int count = j-i;
                int temp = array[i];
                array[i] = array[j];
                while (count>1){
                    array[i+count] = array[i+count-1];//数组后移
                    count--;
                }
                array[i+1] = temp;
            }
            i++;
        }
    }


}
