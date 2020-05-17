package com.shm.toOffer;

/**
 * 综合	把字符串转换成整数
 * 题目描述
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 示例1
 * 输入
 * 复制
 * +2147483647
 * 1a33
 * 输出
 * 复制
 * 2147483647
 * 0
 */
public class StrToInt {
    /**
     *
     * 正则表达式判断格式 + 结果溢出判断 【效率低，很慢】
     * 不符合规则就返回0；符合规则，得出结果后判断是否溢出。
     * @param str
     * @return
     */
    public int StrToInt(String str) {
        // \d代表[0-9] 但是要写成\\d才行。
        if (!str.matches("[+,-]?\\d+")){
            return 0;
        }
        int len = str.length();
        int i = len-1;
        //long类型，避免溢出。不能用int
        long result = 0;
        while (i>=0&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
            result += Math.pow(10,len-i-1)*(str.charAt(i) - '0');
            i--;
        }
        result = (str.charAt(0) == '-' ? -result:result);
        //溢出就返回0，用long类型的res来比较，
        //如果定义为int res,那再比较就没有意义了，int范围为[-2147483648,2147483647]
        if (result>Integer.MAX_VALUE||result<Integer.MIN_VALUE){
            return 0;
        }
        return (int)result;
    }

    /**
     * 越界的简单解决方案：让符号位参与运算，并合理利用 INT_MAX/10
     * 链接：https://www.nowcoder.com/questionTerminal/1277c681251b4372bdef344468e4f26e?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 二、关于数值越界：合理利用 INT_MAX/10
     * 数值越界，即大于 2147483647，或小于 -2147483648。通过观察程序结构，我们发现，每次循环时 value 的值都会扩大10倍（乘以10），那么，我们是否就可以利用 INT_MAX/10 的值来提前一步判断是否会越界呢？这里我们以正数的越界为例进行解释：
     *
     * 当 value > INT_MAX/10 时，说明本轮扩大10倍后，value 必将越界（超过 INT_MAX）；
     * 当 value == INT_MAX/10 时，说明扩大10倍后，value 可能越界，也可能不越界，需要利用当前的加数 digit 来进行进一步的判断：当 digit > 7 时（以正数为例），越界；
     * 否则，当 value < INT_MAX/10 时，本轮循环必不越界（扩大10倍后也小于 INT_MAX）；
     * @param str
     * @return
     */
    public int StrToInt_2(String str) {
        if (str==null||"".equals(str)){
            return 0;
        }
        char[] chars = str.toCharArray();
        int result = 0;
        int flag = 1;
        int i = 0;
        if (chars[i] == '-'){
            flag = -1;
        }
        if (chars[i] == '-' || chars[i] == '+'){
            i++;
        }
        while (i<chars.length){
            //是数字
            if (chars[i]<='9'&&chars[i]>='0'){
                //溢出
                if (flag==1 && (result > Integer.MAX_VALUE/10 || result==Integer.MAX_VALUE/10 && (chars[i]-'0')>7)){
                    return 0;
                }
                if (flag==-1 && (result > Integer.MAX_VALUE/10 || result==Integer.MAX_VALUE/10 && (chars[i]-'0')>8)){
                    return 0;
                }
                result = result*10 + (chars[i]-'0');
                i++;
            }else {
                //不是数字
                return 0;
            }
        }
        return result*flag;
    }
}
