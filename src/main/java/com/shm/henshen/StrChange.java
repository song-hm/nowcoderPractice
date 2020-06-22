package com.shm.henshen;

/**
 * 将包含数字与大写字母的字符串转换为只包含大写字母的字符串，且能根据转换后的字符串还原出原字符串
 */
public class StrChange {
    public static void main(String[] args) {
        String str = "S5GSG457SGS4G474";
        String s = changeStr(str);
        System.out.println(s);
        String s1 = reduction(s);
        System.out.println(s1);
    }
    public static String changeStr(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)>='A' && str.charAt(i)<='Z'){
                sb.append('A').append(str.charAt(i));
            }else {
                char c = (char)(str.charAt(i)-'0'+'A');
                sb.append('B').append(c);
            }
        }
        return sb.toString();
    }

    public static String reduction(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0,j=1; i <str.length()-1&&j<str.length(); i=i+2,j=j+2) {
            if (str.charAt(i)=='A'){
                sb.append(str.charAt(j));
            }else {
                char c = (char)(str.charAt(j)-'A'+'0');
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
