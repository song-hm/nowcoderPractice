package com.shm.toOffer;


/**
 * 知识迁移能力	左旋转字符串
 * 题目描述
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        char[] c = str.toCharArray();
        char[] newC = new char[c.length];
        for (int i = 0; i < c.length; i++) {
            int j = i-n;
            if (j<0){
                newC[c.length-1+j] = c[i];
            }else {
                newC[j] = c[i];
            }
        }
//        String newStr = "";
        StringBuilder sb = new StringBuilder();
        for (char c1 : newC) {
//            newStr = newStr + "" +c1;
            sb.append(c1);
        }
        String newStr = sb.toString();
        return newStr;
    }

    /**
     * 左旋字符串（循环左移字符串）：左移串长length位后和原来一样，所以正真需要左移的是n % str.length()位
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString_2(String str,int n) {
        int len = str.length();
        //空串和单字符串左移无意义
        if (len<=1){
            return str;
        }
        n = n%len;
        if (n==0){
            return str;
        }
        return str.substring(n)+str.substring(0,n);

    }
}
