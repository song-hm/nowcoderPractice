package com.shm.toOffer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 数组	数组中重复的数字
 * 题目描述
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * commit:1,2
 * pass:83.33%,100%
 *
 */
public class Duplicate {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (length<1){
            return false;
        }

        for (int i = 0; i <length-1; i++) {
           for (int j=i+1;j<length;j++){
               if (numbers[i] == numbers[j]){
                   duplication[0] = numbers[i];
                   return true;
               }
           }
        }
        return false;
    }

    /**
     * 一、排序
     * 1. 分析
     * 将输入数组排序，再判断相邻位置是否存在相同数字，如果存在，对 duplication 赋值返回，否则继续比较
     * 3. 复杂度
     * 时间复杂度：0(nlogn)
     * 空间复杂度：0(1)
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate_2(int numbers[],int length,int [] duplication) {
        if (length < 1) {
            return false;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < length-1; i++) {
            if (numbers[i] == numbers[i+1]){
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/623a5ac0ea5b4e5f95552655361ae0a8?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 二、哈希表
     * 1. 分析
     * 利用 HashSet 解决，从头到尾扫描数组，每次扫描到一个数，判断当前数是否存在 HashSet 中，
     * 如果存在，则重复，对 duplication 赋值返回，否则将该数加入到 HashSet 中
     * 3. 复杂度
     * 时间复杂度：0(n)
     * 空间复杂度：0(n)
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate_3(int numbers[],int length,int [] duplication) {
        if (length < 1) {
            return false;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int number : numbers) {
            if (hashSet.contains(number)){
                duplication[0] = number;
                return true;
            }
            hashSet.add(number);
        }
        return false;
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/623a5ac0ea5b4e5f95552655361ae0a8?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 三、利用特性
     * 1. 分析
     * 数组的长度为 n 且所有数字都在 0 到 n-1 的范围内，我们可以将每次遇到的数进行"归位"，当某个数发现自己的"位置"被相同的数占了，则出现重复。
     * 扫描整个数组，当扫描到下标为 i 的数字时，首先比较该数字（m）是否等于 i，如果是，则接着扫描下一个数字；如果不是，则拿 m 与第 m 个数比较。如果 m 与第 m 个数相等，则说明出现重复了；如果 m 与第 m 个数不相等，则将 m 与第 m 个数交换，将 m "归位"，再重复比较交换的过程，直到发现重复的数
     *
     * 举个栗子：
     * 以数组 {2,3,1,0,2,5,3} 为例
     * 当 i = 0 时，nums[i] = 2 != i，判断 nums[i] 不等于 nums[nums[i]]，交换 nums[i] 和 nums[nums[i]]，交换后数组为：{1,3,2,0,2,5,3}
     * 此时 i = 0，nums[i] = 1 != i，判断 nums[i] 不等于 nums[nums[i]]，交换 nums[i] 和 nums[nums[i]]，交换后数组为：{3,1,2,0,2,5,3}
     * 此时 i = 0，nums[i] = 3 != i，判断 nums[i] 不等于 nums[nums[i]]，交换 nums[i] 和 nums[nums[i]]，交换后数组为：{0,1,2,3,2,5,3}
     * 此时 i = 0，nums[i] = 0 = i，继续下一组
     * 当 i = 1，nums[i] = 1 = i，继续下一组
     * 当 i = 2，nums[i] = 2 = i，继续下一组
     * 当 i = 3，nums[i] = 3 = i，继续下一组
     * 当 i = 4，nums[i] = 2 != i，判断 nums[i] 等于 nums[nums[i]]，出现重复，赋值返回
     * 3. 复杂度
     * 时间复杂度：0(n)
     * 空间复杂度：0(1)
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate_4(int numbers[],int length,int [] duplication) {
        if (length < 1) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i){
                if (numbers[i]==numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }
                //swap 易错点
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }
}
