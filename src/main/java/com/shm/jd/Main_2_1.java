package com.shm.jd;

//        链接：https://www.nowcoder.com/discuss/411686?type=1

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//查看同一时刻重复区间最多有多少，这个值就是结果。
public class Main_2_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()){
            int t = in.nextInt();
            int[] start = new int[t];
            Set<Integer> set = new HashSet<>();
            int[] end = new int[t];
            for(int i=0;i<t;i++){
                start[i] = in.nextInt();
                //set.add(in.nextInt());
                end[i] = in.nextInt();
            }
            int count = 0;
            for(int i=0;i<t;i++){
                int temp = 0;
                for (int j=0;j<t;j++){
                    if(i==j){
                        continue;
                    }else {
                        if((start[j] >= start[i] && start[j] <= end[i]) || (end[j]>=start[i]&&end[j]<end[i])){
                            temp++;
                        }
                    }
                    count = Math.max(count,temp);
                }
            }
            System.out.println(count+1);
        }
    }
}
//解析链接：https://www.jianshu.com/p/3948fda91d3d