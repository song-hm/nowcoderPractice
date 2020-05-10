package com.shm.toOffer;

/**时间效率	整数中1出现的次数（从1到n整数中1出现的次数）
 * 题目描述
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class NumberOf1Between1AndN {


    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        while (n>0){
            String str = String.valueOf(n);
            char[] chars = str.toCharArray();
            for (int i=0;i<chars.length;i++){
                if (chars[i] == '1'){
                    count++;
                }
            }
            n--;
        }
        return count;
    }

    /**
     * 对于每一个数求1的个数，然后加起来。对于每一个数来说求个位只需要mod10就好，
     * 然后将原数/10 替换 原数，再mod10求得十位，以此类推，可得各十百千。。。位。 然后循环--即可
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution_2(int n) {
        int count = 0;
        for (int i=n;i>0;i--){
            for (int j=i;j>0;j/=10){
                if (j%10==1){
                    count++;
                }
            }
        }
        return count;
    }
}
