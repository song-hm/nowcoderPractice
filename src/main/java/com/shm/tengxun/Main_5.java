package com.shm.tengxun;

import java.util.Scanner;

/**
 * 一颗无限深的满二叉树，标号1,2,3,....
 * 求x的祖先(深度必须是k)。
 */
//t5
public class Main_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        long x,y;
        int k,height;
        while (q-- > 0){
            x = sc.nextLong();
            k = sc.nextInt();
            height = 0;
            y = x;
            while (x>0){
                x = x/2;
                height++;
            }
            if (k>=height){
                System.out.println(-1);
            }else {
                while (k<height){
                    y = y/2;
                    height--;
                }
                System.out.println(y);
            }

        }
    }
}
