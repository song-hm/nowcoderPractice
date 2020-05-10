package com.shm.tengxun;

import java.util.ArrayList;
import java.util.Scanner;
//t2
/**平面上有2*n个点，n个点属于A集合，n个点属于B集合，
 各从俩集合中选择一个数，求最近点对。

 平面最近点对，只要记录在哪个集合就ok。

 * 2
 * 4
 * 0 0
 * 0 1
 * 1 0
 * 1 1
 * 2 2
 * 2 3
 * 3 2
 * 3 3
 * 4
 * 0 0
 * 0 0
 * 0 0
 * 0 0
 * 0 0
 * 0 0
 * 0 0
 * 0 0
 *
 * 1.414
 * 0.000
 */
public class Main_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            Node[] a = new Node[n];
            Node[] b = new Node[n];
            for (int j=0;j<n;j++){
                a[j] = new Node();
                a[j].x = sc.nextInt();
                a[j].y = sc.nextInt();
            }

            for (int j=0;j<n;j++){
                b[j] = new Node();
                b[j].x = sc.nextInt();
                b[j].y = sc.nextInt();
            }

            double ans = Double.MAX_VALUE;
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    ans = Math.min(ans,dist(a[i],b[j]));
                }
            }

            System.out.println(String.format("%.3f",ans));
        }
    }
    static double dist(Node a,Node b){
        return Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
    }
}

class Node {
    int x;
    int y;
}