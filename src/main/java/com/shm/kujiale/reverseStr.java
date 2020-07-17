package com.shm.kujiale;

import java.util.Scanner;

public class reverseStr {
    public static void main(String[] args){
        StringBuilder stringBuilder = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            stringBuilder.append(sc.nextLine());
            System.out.println(new reverseStr().swapStr(new String(stringBuilder)));
        }
    }

    public String swapStr(String str){
        char[] chars = str.toCharArray();
        int lens = chars.length;
        swap(chars,0,lens-1);
        int begin = 0;
        for (int i = 0; i < lens; i++) {
            if (chars[i] == ' '){
                swap(chars,begin,i-1);
                begin = i+1;
            }
        }
        swap(chars,begin,lens-1);
        return new String(chars);
    }

    public void swap(char[] cs,int start,int end){
        while (start<end){
            char temp = cs[start];
            cs[start] = cs[end];
            cs[end] = temp;
            start++;
            end--;
        }
    }
}
