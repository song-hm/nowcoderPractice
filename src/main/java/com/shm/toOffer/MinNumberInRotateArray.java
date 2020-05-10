package com.shm.toOffer;

/**
 *题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 链接：https://www.nowcoder.com/questionTerminal/9f3231a991af4f55b95579b44b7a01ba?answerType=1&f=discussion
 * 来源：牛客网
 *
 * 分析：二分查找变种，没有具体的值用来比较。那么用中间值和高低位进行比较，看处于递增还是递减序列，进行操作缩小范围。
 *
 * 处于递增：low上移
 *
 * 处于递减：high下移（如果是high-1，则可能会错过最小值，因为找的就是最小值）
 *
 * 其余情况：low++缩小范围
 *
 * 1.offer书上的写法，坑点很多。
 *
 * 3 4 5 1 2 （一般情况）
 * 1 2 3 4 5 / 2 2 2 2 2（容易想到的点）
 * 1 0 1 1 1 / 1 1 1 0 1（扑街）
 */
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if(array == null) {
            return 0;
        }
        int low = 0;
        int high = array.length - 1;
        int mid = 0;
        while(low < high){

            if(array[low] < array[high]) {
                return array[low];
            }
            mid = low + (high - low)/2;
            if(array[low] < array[mid]) {
                low = mid + 1;
            }
            else if(array[mid] < array[high]) {
                high = mid;// 如果是mid-1，则可能会错过最小值，因为找的就是最小值
            }
            else {
                low++;// 巧妙避免了offer书上说的坑点（1 0 1 1 1）
            }
        }
        return array[low];

    }
}
