package com.shm.netease;

import javafx.util.Pair;

import java.util.*;

public class Main_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int T = in.nextInt();
            int[] da = new int[T];

            for (int n = 0; n < T; n++) {
                int M = in.nextInt();
                double L = in.nextInt();
                int[][] arr = new int[M][M];
                for (int i = 0; i < M; i++) {
                    for (int j = 0; j < M; j++) {
                        int a = in.nextInt();
                        arr[i][j] = a;
                    }
                }
                int x = in.nextInt();
                int y = in.nextInt();

                HashMap<Double,Integer> map = new HashMap<>();

                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr.length; j++) {
                        if (arr[i][j] != 0) {
                            double len = Math.sqrt(Math.pow(x - i, 2) + Math.pow(y - j, 2));
                            map.put(len,arr[i][j]);
                        }
                    }
                }
                Double[] l = null;
                map.keySet().toArray(l);
                Arrays.sort(l);
                for (int i=0;i<l.length;i++){
                    if (l[i]<=L){
                        L+=map.get(l[i]);
                    }
                }
                System.out.println(L);

            }
        }
    }
}
