package com.shm.leetcode;

/**
 * 67. 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * 链接：https://leetcode-cn.com/problems/add-binary
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int len = a.length()>b.length()?a.length():b.length(),carry=0;
        for (int k = 0; k < len; k++) {
            carry+=k<a.length()?(a.charAt(a.length()-1-k)-'0'):0;
            carry+=k<b.length()?(b.charAt(b.length()-1-k)-'0'):0;
            sb.append((char)(carry%2+'0'));
            carry/=2;
        }
        if (carry>0){
            sb.append('1');
        }
        sb.reverse();

        return sb.toString();
    }

    public String addBinary_2(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        //循环相加两个字符串相同长度的低位数部分
        while (i >= 0 && j >= 0) {
            int sum = carry;
            sum += a.charAt(i--) - '0';
            sum += b.charAt(j--) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
        }
        // 如果 a 还没遍历完成（a串比b串长），则继续遍历添加 a 的剩余部分
        while (i >= 0) {
            int sum = carry + a.charAt(i--) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
        }
        // 如果 b 还没遍历完成（b串比a串长），则继续遍历添加 b 的剩余部分
        while (j >= 0) {
            int sum = carry + b.charAt(j--) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
        }
        //如果 carry 不等于0 还有个进位数没加进去，需要补充
        if (carry == 1) {
            builder.append(carry);
        }
        //反转字符串获得正常结果
        return builder.reverse().toString();
    }
}
