package com.shm.tengxun;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

//t1
public class Main_1 {
//    链接：https://www.nowcoder.com/discuss/417959

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        int Q, len, x;
        String str;
        String[] arr;
        Queue<Integer> queue;
        while (T-- > 0) {
            Q = Integer.parseInt(in.nextLine());
            queue = new ArrayDeque<Integer>();
            while (Q-- > 0) {
                str = in.nextLine();
                arr = str.split(" ");
                len = arr.length;
                if (len == 1) {
                    if (arr[0].equals("TOP"))
                        System.out.println(queue.isEmpty() ? -1 : queue.peek());
                    else if (arr[0].equals("POP")) {
                        if (queue.isEmpty())
                            System.out.println(-1);
                        else
                            queue.remove();
                    } else if (arr[0].equals("SIZE"))
                        System.out.println(queue.size());
                    else
                        queue.clear();
                } else {
                    queue.add(Integer.parseInt(arr[1]));
                }
            }
        }
    }
}
