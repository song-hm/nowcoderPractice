package com.shm.meituan;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 1\不能超过
 *题目描述：
 * 给出一个序列包含n个正整数的序列A，你可以从中删除若干个数，使得剩下的数字中的最大值和最小值之差不超过x，请问最少删除多少个数字。
 *
 * 输入
 * 输入第一行仅包含两个正整数n和x，表示给出的序列的长度和给定的正整数。(1<=n<=1000,1<=x<=10000)
 *
 * 接下来一行有n个正整数，即这个序列，中间用空格隔开。(1<=a_i<=10000)
 *
 * 输出
 * 输出仅包含一个正整数，表示最少删除的数字的数量。
 * 样例输入
 * 5 2
 * 2 1 3 2 5
 * 样例输出
 * 1
 *
 * 2\空间回廊
 * 题目描述：
 * 有一款叫做空间回廊的游戏，游戏中有着n个房间依次相连，如图，1号房间可以走到2号房间，以此类推，n号房间可以走到1号房间。
 *
 *
 *
 * 这个游戏的最终目的是为了在这些房间中留下尽可能多的烙印，在每个房间里留下烙印所花费的法力值是不相同的，已知他共有m点法力值，这些法力是不可恢复的。
 *
 * 小明刚接触这款游戏，所以只会耿直的玩，所以他的每一个行动都是可以预料的：
 *
 * 1. 一开始小明位于1号房间。
 *
 * 2. 如果他剩余的法力能在当前的房间中留下一个烙印，那么他就会毫不犹豫的花费法力值。
 *
 * 3. 无论是否留下了烙印，下一个时刻他都会进入下一个房间，如果当前位于i房间，则会进入i+1房间，如果在n号房间则会进入1号房间。
 *
 * 4. 当重复经过某一个房间时，可以再次留下烙印。
 *
 * 很显然，这个游戏是会终止的，即剩余的法力值不能在任何房间留下烙印的时候，游戏终止。请问他共能留下多少个烙印。
 *
 * 输入
 * 输入第一行有两个正整数n和m，分别代表房间数量和小明拥有的法力值。(1<=n<=100000,1<=m<=10^18)
 *
 * 输入第二行有n个正整数，分别代表1~n号房间留下烙印的法力值花费。(1<=a_i<=10^9)
 *
 * 输出
 * 输出仅包含一个整数，即最多能留下的烙印。
 *
 *
 * 样例输入
 * 4 21
 * 2 1 4 3
 * 样例输出
 * 9
 *
 * 3\小仓的射击练习4
 * 题目描述：
 * 小仓酷爱射击运动。今天的小仓想挑战自我。小仓有N颗子弹，接下来小仓每次会自由选择K颗子弹进行连续射击，全中靶心的概率为p[k]。如果成功小仓将获得a[k]的得分，并且可以使用余下子弹继续射击，否则今天的挑战结束。小仓想知道在最佳策略下，自己能得到的最高期望分数是多少。
 *
 * 输入
 * 第一行一个数N，代表子弹数量。
 *
 * 第二行N个数p[]，第 i 个数代表p[i]。
 *
 * 第三行N个数a[]，第 i 个数代表a[i]。
 *
 * 1<=N<=5000   0<=p[i]<=1   0<=a[i]<=1000
 *
 * 输出
 * 一个数表示最高期望得分，保留两位小数。
 *
 *
 * 样例输入
 * 2
 * 0.80 0.50
 * 1 2
 * 样例输出
 * 1.44
 *
 * 4\拆分
 * 题目描述：
 * 给定长度为n的串S，仅包含小写字母。定义
 *
 *
 *
 * 公式中，|A|代表字符串A的长度
 *
 * 也就是说如果子串是一个ABA型的字符串，且满足长度限制，则f(l,r)=1，否则等于0。（注意：形如“ababab”也可视为ABA型）
 *
 *
 *
 * 例如当n=2时，原式为f(1,1)+f(1,2)+f(2,2)。
 *
 * 输入
 * 第一行一个字符串S
 *
 * 第二行一个数字k
 *
 * 输出
 * 输出题目描述中式子的值
 *
 *
 * 样例输入
 * abcabcabc
 * 2
 * 样例输出
 * 8
 *
 * 提示
 * 1<=n<=2000 , S[i]为小写字母
 *
 * 样例解释：
 * 在这个字符串中，有f(1,5),f(1,8),f(1,9),f(2,6),f(2,9),f(3,7),f(4,8),f(5,9)的值为1，其他为0，故和为8。以f(1,5)为例，选择的子串是abcab，令A=“ab”，B=“c”,则|A|>=k且|B|>=1,因此f(1,5)等于1，以此类推。
 *
 * 5\max xor min
 * 题目描述：
 *  给你一个长度为n的序列a，请你求出对每一个1<=l<r<=n的区间中最大值和最小值的异或和的异或和。
 *
 * 例如序列为{1,3,5},不同的a(1,2)=1^3,a(1,3)=1^5,a(2,3)=(3^5),a(1,2)^a(1,3)^a(2,3)=0，所以最后的答案是0。
 *
 * 输入
 * 输入第一行仅包含一个正整数n，表示序列的长度。(1<=n<=10^5)
 *
 * 接下来一行有n个正整数a_i，表示序列a。(1<=a_i<=10^9)
 *
 * 输出
 * 输出仅包含一个整数表示所求的答案。
 *
 *
 * 样例输入
 * 3
 * 1 3 5
 * 样例输出
 * 0
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        int n = 0;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        Integer[] array = new Integer[N];
        Integer[] array2 = new Integer[N];
        Integer[] array3 = new Integer[N];
        int[] arr = new int[N];

        for (int i=0;i<N;i++){
            int m = sc.nextInt();
            list.add(m);
            arr[i] = m;
        }
        list.toArray(array);

        //3
        for (int j=0;j<N;j++){
            int l = sc.nextInt();
            list2.add(l);
        }
        list2.toArray(array2);

        int p = 0;
        for (int k=0;k<N;k++){
            p = p + (array[0])^k*array2[0];
        }



        //1
//        sort(array);
//        int n = 0;
//        for (int j=array.length-1;j>0;j--){
//            if(array[j] <= array[0] + X){
//                n = array.length-j-1;
//                break;
//            }
//        }
//        System.out.println(n);

        //2
        for (int j=0;X>0;j++){
            for (int s=0;s<N;s++){
                if (s<N-1){
                    if(j%N == s){
                        X = X - array[s];
                        n++;
//                        if(X- array[s+1] < 0) {
//                        break;
//                        }
                    }
                }
                if (s == N-1){
                    if(j%N == s){
                        X = X - array[s];
                        n++;
//                        if(X- array[0] < 0) {
//                            break;
//                        }
                    }
                }
            }
//            if (j%4 == 1 ){
//                X = X - array[0];
//                n++;
//                if(X- array[1] < 0) {
//                    break;
//                }
//            }
//            if (j%4 == 2){
//                X = X- array[1];
//                n++;
//                if(X- array[2] < 0) {
//                    break;
//                }
//            }
//            if (j%4 == 3){
//                X = X- array[2];
//                n++;
//                if(X- array[3] < 0) {
//                    break;
//                }
//            }
//            if (j%4 == 4){
//                X = X- array[3];
//                n++;
//                if(X- array[0] < 0) {
//                    break;
//                }
//            }
        }
        System.out.println(n);



    }
    private static void sort(Integer array[]){
        int tmp = 0;
        int lastExchangeIndex=0;
        int sortBorder=array.length-1;
        for(int i=0;i<array.length;i++){
            boolean isSorted=true;
            for(int j=0;j<sortBorder;j++){
                if(array[j]>array[j+1]){
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    isSorted=false;
                    lastExchangeIndex=j;
                }
            }
            sortBorder=lastExchangeIndex;
            if(isSorted){
                break;
            }
        }
    }
}
