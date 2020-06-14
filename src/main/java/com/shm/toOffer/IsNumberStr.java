package com.shm.toOffer;

import java.util.regex.Pattern;

/**
 * 	表示数值的字符串	字符串
 * 	题目描述
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class IsNumberStr {

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/6f8c901d091949a5837e24bb82a731f2?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 思路：首先要想到所有的情况，然后进行分类讨论。-123.45e-67
     *
     * +-号后面必定为数字或后面为.（-.123 = -0.123）
     * +-号只出现在第一位或在eE的后一位
     * .后面必定为数字或为最后一位（233. = 233.0）
     * eE后面必定为数字或+-号
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {

//        链接：https://www.nowcoder.com/questionTerminal/6f8c901d091949a5837e24bb82a731f2?answerType=1&f=discussion

        boolean point = false, exp = false; // 标志小数点和指数

        for (int i = 0; i < str.length; i++) {
            if (str[i] == '+' || str[i] == '-') {
                if (i + 1 == str.length || !(str[i + 1] >= '0' && str[i + 1] <= '9' || str[i + 1] == '.')) { // +-号后面必定为数字 或 后面为.（-.123 = -0.123）
                    return false;
                }
                if (!(i == 0 || str[i-1] == 'e' || str[i-1] == 'E')) { // +-号只出现在第一位或eE的后一位
                    return false;
                }


            } else if (str[i] == '.') {
                if (point || exp || !(i + 1 < str.length && str[i + 1] >= '0' && str[i + 1] <= '9')) { // .后面必定为数字 或为最后一位（233. = 233.0）
                    return false;
                }
                point = true;

            } else if (str[i] == 'e' || str[i] == 'E') {
                if (exp || i + 1 == str.length || !(str[i + 1] >= '0' && str[i + 1] <= '9' || str[i + 1] == '+' || str[i + 1] == '-')) { // eE后面必定为数字或+-号
                    return false;
                }
                exp = true;

            } else if (str[i] >= '0' && str[i] <= '9') {


            } else {
                return false;
            }

        }
        return true;
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/6f8c901d091949a5837e24bb82a731f2?answerType=1&f=discussion
     * 来源：牛客网
     *
     * ^ 和 美元符号框定正则表达式，它指引这个正则表达式对文本中的所有字符都进行匹配。
     * 如果省略这些标识，那么只要一个字符串中包含一个数字这个正则表达式就会进行匹配。
     * 如果仅包含 ^ ，它将匹配以一个数字开头的字符串。如果仅包含$ ，则匹配以一个数字结尾的字符串。
     *
     * [-+]?
     * 正负号后面的 ? 后缀表示这个负号是可选的,表示有0到1个负号或者正号
     *
     * \\d*
     * \d的含义和[0-9]一样。它匹配一个数字。后缀 * 指引它可匹配零个或者多个数字。
     *
     * (?:\\.\\d*)?
     * (?: …)?表示一个可选的非捕获型分组。* 指引这个分组会匹配后面跟随的0个或者多个数字的小数点。
     *
     * (?:[eE][+\\-]?\d+)?
     * 这是另外一个可选的非捕获型分组。它会匹配一个e(或E)、一个可选的正负号以及一个或多个数字。
     * @param str
     * @return
     */
    public boolean isNumeric_2(char[] str) {
//        链接：https://www.nowcoder.com/questionTerminal/6f8c901d091949a5837e24bb82a731f2?answerType=1&f=discussion

        String pattern = "^[-+]?\\d*(?:\\.\\d*)?(?:[eE][+\\-]?\\d+)?$";
        String s = new String(str);
        return Pattern.matches(pattern,s);
    }
}
