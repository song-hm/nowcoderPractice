package com.shm.toOffer;

/**
 *  时间空间效率的平衡	第一个只出现一次的字符位置
 *  题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 */
public class FirstNotRepeatingChar {
    /**
     * 按照hash的思想来做的，先统计出现的次数，然后在返回相应的index
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0){
            return -1;
        }
        //用一个类似hash的东西来存储字符出现的次数，很方便
        int[] count = new int[256];
        for (int i=0;i<str.length();i++){
            count[str.charAt(i)]++;
        }
        //只要在遍历一遍字符串并访问hash记录就可以了
        for (int i=0;i<str.length();i++){
            if (count[str.charAt(i)] == 1){
                return i;
            }
        }
        return -1;
    }
}
