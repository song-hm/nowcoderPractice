package com.shm.tengxun;

import java.util.Scanner;
//t3
/**
 * 作者：qin_peng
 * 链接：https://www.nowcoder.com/discuss/417957?type=1
 * 来源：牛客网
 *
 * 有n张卡牌， 正面时 ai ,反面时 bi ,每次可以任意选择相邻俩张卡牌，交换位置，
 * 然后并且翻转，并且使得 a不减 ，求最小操作次数。
 * 状压dp , 不过要预处理下 ，将偶数下标的 a_i, b_i ,swap 。
 */
public class Main_3 {

    static Noded[] nodeds;
    static int len;
//    static boolean isOk;
    static int ans;

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nodeds = new Noded[n];
        len = n;

        for (int i=0;i<n;i++){
            nodeds[i] = new Noded();
        }
        for (int i=0;i<n;i++){
            nodeds[i].a = sc.nextInt();
        }
        for (int i=0;i<n;i++){
            nodeds[i].b = sc.nextInt();
        }
//        isOk = false;
        ans = Integer.MAX_VALUE;
        dfs(0);
        System.out.println(ans);

    }

    static boolean check(){
        boolean flag = true;
        for (int i=1;i<len;i++){
            if (nodeds[i-1].a > nodeds[i].a){
                flag = false;
                break;
            }
        }
        return flag;
    }

    static void dfs(int cnt){
        if (check()){
            ans = Math.min(ans,cnt);
            return;
        }
        for (int i=1;i<len;i++){
            if (nodeds[i-1].a > nodeds[i].a){
                swap(i-1,i);
                dfs(cnt+1);
            }
        }
    }

    static void swap(int i,int j){
        int tmp = nodeds[i].a;
        nodeds[i].a = nodeds[i].b;
        nodeds[i].b = tmp;
        tmp = nodeds[j].a;
        nodeds[j].a = nodeds[j].b;
        nodeds[j].b = tmp;
        tmp = nodeds[i].a;
        nodeds[i].a = nodeds[j].a;
        nodeds[j].a = tmp;
        tmp = nodeds[i].b;
        nodeds[i].b = nodeds[j].b;
        nodeds[j].b = tmp;
    }
}

class Noded{
    int a,b;
}