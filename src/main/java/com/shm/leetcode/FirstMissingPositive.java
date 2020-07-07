package com.shm.leetcode;
/**
 * 41. 缺失的第一个正数
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *  
 *
 * 提示：
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 *
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 */

import java.util.Arrays;
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int k=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){
                k = i;
                break;
            }
        }
        int i=1;
        for (int j=k; i <= nums.length-k; i++,j++) {
            if (nums[j]!=i){
                return i;
            }
        }
        return i;
    }

    public int firstMissingPositive_2(int[] nums) {
        int[] num = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){
                num[num[i]] = 1;
            }
        }
        int j = 1;
        for (; j < num.length; j++) {
            if (num[j]<1){
                return j;
            }
        }
        return j;
    }


    /**
     * 实际上，对于一个长度为 NN 的数组，其中没有出现的最小正整数只能在 [1, N+1][1,N+1] 中。这是因为如果 [1, N][1,N] 都出现了，那么答案是 N+1N+1，否则答案是 [1, N][1,N] 中没有出现的最小正整数。这样一来，我们将所有在 [1, N][1,N] 范围内的数放入哈希表，也可以得到最终的答案。而给定的数组恰好长度为 NN，这让我们有了一种将数组设计成哈希表的思路：
     *
     * 我们对数组进行遍历，对于遍历到的数 xx，如果它在 [1, N][1,N] 的范围内，那么就将数组中的第 x-1x−1 个位置（注意：数组下标从 00 开始）打上「标记」。在遍历结束之后，如果所有的位置都被打上了标记，那么答案是 N+1N+1，否则答案是最小的没有打上标记的位置加 11。
     *
     * 那么如何设计这个「标记」呢？由于数组中的数没有任何限制，因此这并不是一件容易的事情。但我们可以继续利用上面的提到的性质：由于我们只在意 [1, N][1,N] 中的数，因此我们可以先对数组进行遍历，把不在 [1, N][1,N] 范围内的数修改成任意一个大于 NN 的数（例如 N+1N+1）。这样一来，数组中的所有数就都是正数了，因此我们就可以将「标记」表示为「负号」。算法的流程如下：
     *
     * 我们将数组中所有小于等于 00 的数修改为 N+1N+1；
     *
     * 我们遍历数组中的每一个数 xx，它可能已经被打了标记，因此原本对应的数为 |x|∣x∣，其中 |\,|∣∣ 为绝对值符号。如果 |x| \in [1, N]∣x∣∈[1,N]，那么我们给数组中的第 |x| - 1∣x∣−1 个位置的数添加一个负号。注意如果它已经有负号，不需要重复添加；
     *
     * 在遍历完成之后，如果数组中的每一个数都是负数，那么答案是 N+1N+1，否则答案是第一个正数的位置加 11。
     *
     * 链接：https://leetcode-cn.com/problems/first-missing-positive/solution/que-shi-de-di-yi-ge-zheng-shu-by-leetcode-solution/
     * @param nums
     * @return
     */
    public int firstMissingPositive_3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<1){
                nums[i] = nums.length+1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num<=nums.length){
                nums[num-1] = -Math.abs(nums[num-1]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){
                return i+1;
            }
        }
        return nums.length+1;
    }
}
