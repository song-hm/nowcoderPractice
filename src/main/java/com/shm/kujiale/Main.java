package com.shm.kujiale;

import java.util.Scanner;

public class Main {
    public void swap(char [] arr,int front,int end) {
        while(front<end){
            char tmp;
            tmp=arr[front];
            arr[front]=arr[end];
            arr[end]=tmp;
            front++;
            end--;
        }
    }
    public String swapWords(String str) {
        char[] charArry=str.toCharArray();
        int len=charArry.length;
        int begin=0;
        swap(charArry, 0, len-1);
        for(int i = 0;i < len;i++){
            if(charArry[i]==' '){
                swap(charArry, begin, i-1);
                begin=i+1;
            }
        }
        swap(charArry, begin, len-1);
        return new String(charArry);
    }
    public static void main(String[] args) {
        StringBuilder string=new StringBuilder();
        Scanner scanner =new  Scanner(System.in);
        while(scanner.hasNext()){
            string.append(scanner.nextLine());
            System.out.println(new com.shm.Main().swapWords(new String(string))) ;
        }
    }
}
