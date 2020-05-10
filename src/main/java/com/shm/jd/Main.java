package com.shm.jd;

import java.util.Scanner;

/**
 * 题目描述：
 * 一个长方体纸箱由六个面构成。
 *
 * 现在给出六块纸板的长和宽，请你判断能否用这六块纸板构成一个长方体纸箱。
 *
 * 输入
 * 第一行包含一个整数T，表示测试数据组数。
 *
 * 1 <= T <= 10
 *
 * 对于每组测试数据包含六行，每行包含两个整数h, w，表示一块纸板的长和宽。
 *
 * 1 <= h, w <= 104
 *
 * 输出
 * 对于每组测试数据输出一行。如果能构成纸箱则输出POSSIBLE，否则输出IMPOSSIBLE。
 */
public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        int[][] arr = new int[6*t][2];
        for (int i=0;i<6*t;i++){
            int l = in.nextInt();
            int w = in.nextInt();
            arr[i][0] = l;
            arr[i][1] = w;
        }


        for (int i=0;i<t;i++){
            int l = arr[t*i][0];
            int w = arr[t*i][1];
            int count = 0;
            for (int j=t*i;j<t*(i+1);j++){
                if (arr[j][0] != l && arr[j][0] != w){
                    count++;
                }
                if (arr[j][1] != l && arr[j][1] != w){
                    count++;
                }
            }
            if(count == 0){
                if (l==w){
                    int m = 0;
                    for (int j=t*i;j<t*(i+1);j++){
                        if (arr[j][0] != l || arr[j][1] != l){
                            m++;
                            break;
                        }
                    }
                    if (m==0){
                        System.out.println("POSSIBLE");
                    }else {
                        System.out.println("IMPOSSIBLE");
                    }
                }
                else{
                    int n = 0;
                    for (int j=t*i;j<t*(i+1);j++){
                        if (arr[j][0] == l){
                            n++;
                        }
                        if (arr[j][1] == l){
                            n++;
                        }
                    }
                    if (n==4 || n==8){
                        System.out.println("POSSIBLE");
                    }else{
                        System.out.println("IMPOSSIBLE");
                    }
                }
            }else if (count==4){
                System.out.println("POSSIBLE");
            }else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}
