package com.shm.toOffer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 分解让复杂问题简单	字符串的排列
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class Permutation {
    public ArrayList<String> Permutation(String str) {
        StringBuilder sb = new StringBuilder(str);
        ArrayList<String> result = PermutationHelper(sb);
        return result;
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/fe6b651b66ae47d7acce78ffdd9a96c7?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 总体的解决思路是：
     * 假设输入为a、b、c
     * 那么其实排序的总数：
     * fun（a，b，c）=a（fun（b，c））+ a和b交换（fun（a，c））+a和c交换（fun（b，a））
     * fun（b，c） = b+fun（c）+b和c交换（fun（b））
     * fun（c）=1
     * 所以用递归的方法就可以了，并且在这个递归的过程中，并没有做出一些浪费运行时间的事情，每一个递归都会产生新的结果，因此用递归来解决被称为动态规划的此题，是合理的。
     * 另外题目中说明可能存在重复的字符，因此在进行交换的时候需要判断进行交换的字符是否相等，如果相等就没有必要交换了。
     *
     * @param sb
     * @return
     */
    public ArrayList<String> PermutationHelper(StringBuilder sb){
        ArrayList<String> result = new ArrayList<>();
        if (sb.length()==1){
            result.add(sb.toString());
        }else{
            for (int i=0;i<sb.length();i++){
                if (i==0 || sb.charAt(i) != sb.charAt(0)){
                    char temp = sb.charAt(i);
                    sb.setCharAt(i,sb.charAt(0));
                    sb.setCharAt(0,temp);
                    ArrayList<String> newResult = PermutationHelper(new StringBuilder(sb.substring(1)));
                    for (int j=0;j<newResult.size();j++) {
                        result.add(sb.substring(0,1)+newResult.get(j));
                    }
                }
            }
            //需要在做一个排序操作
            Collections.sort(result);
        }
        return result;
    }


    /**
     * 链接：https://www.nowcoder.com/questionTerminal/fe6b651b66ae47d7acce78ffdd9a96c7?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 字典序法
     * 参考https://blog.csdn.net/babynumber/article/details/42706757
     * 在O(n)的时间复杂度下生成当前排列的下一个排列（字典序）。
     * 详细算法去读上面的博客。
     * 简单的讲：
     * 1、从右向左找到第一个正序对（array[i] < array[i+1]，因为没有等号，所以可以完美去掉重复的排列）
     * 2、从i开始向右搜索，找到比array[i]大的字符中最小的那个，记为array[j]
     * 3、交换array[i]和array[j]
     * 4、将i后面的字符反转
     * 这就得到了字典序的下一个排列。
     * 连续使用这个方法则可从字典序最小的排列推出全部排列。
     * 时间复杂度O(n*n!)
     * @param str
     * @return
     */
    public ArrayList<String> Permutation_2(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str.length() == 0){
            return res;
        }
        char[] c = str.toCharArray();
        Arrays.sort(c);
        String s = new String(c);
        res.add(s);
        while (true){
            s = nextString(s);
            if (!s.equals("finish")){
                res.add(s);
            }else {
                break;
            }
        }
        return res;
    }

    public String nextString(String s){
        char[] c = s.toCharArray();
        int length = s.length();
        int i = length-2;
        for (;i>=0 && c[i]>=c[i+1];i--){};
        if (i == -1){
            return "finish";
        }
        int j = length -1;
        for (;j>=0 && c[j]<=c[i];j--){};

        //swap i,j
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;

        for (int a=i+1,b=length-1;a<b;a++,b--){
            char tem = c[a];
            c[a] = c[b];
            c[b] = tem;
        }
        return new String(c);
    }

}
