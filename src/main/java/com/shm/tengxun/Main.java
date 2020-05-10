package com.shm.tengxun;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//t1
/**模拟队列操作
 * 2
 * 7
 * PUSH 1
 * PUSH 2
 * TOP
 * POP
 * TOP
 * POP
 * POP
 * 5
 * PUSH 1
 * PUSH 2
 * SIZE
 * POP
 * SIZE
 *
 * 1
 * 2
 * -1
 * 2
 * 1
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
        while (t-- > 0){
            int q = Integer.valueOf(sc.nextLine());
            Queue<Integer> queue = new LinkedList<>();
            while (q-- > 0){
                String str = sc.nextLine();
                String[] s = str.split(" ");
                if (s[0].equals("PUSH")) {
                    queue.offer(Integer.valueOf(s[1]));
                }
                if (s[0].equals("TOP")) {
                    if (queue.isEmpty()){
                        System.out.println(-1);
                    }else {
                        int p = queue.peek();
                        System.out.println(p);
                    }
                }
                if (s[0].equals("POP")) {
                    if (queue.isEmpty()){
                        System.out.println(-1);
                    }else {
                        queue.poll();
                    }
                }
                if (s[0].equals("SIZE")) {
                    int size = queue.size();
                    System.out.println(size);
                }
                if (s[0].equals("CLEAR")) {
                    queue.clear();
                }
            }
        }


//        String[][] strs = new String[t][];
//        ArrayList<ArrayList<String>> list = new ArrayList<>();
//        int q;
//        String str;
//        String[] s;
//        Queue<Integer> queue;
//        for (int i=0;i<t;i++) {
////            int q = sc.nextInt();
//            q = Integer.parseInt(sc.nextLine());
//            queue = new LinkedList<>();
////            ArrayList<String> strings = new ArrayList<>();
//            for (int j = 0; j < q; j++) {
//                str = sc.nextLine();
//                s = str.split(" ");
//                if (s[0].equals("PUSH")) {
//                    queue.offer(Integer.valueOf(s[1]));
//                }
//                if (s[0].equals("TOP")) {
//                    int p = queue.peek();
//                    System.out.println(p);
//                }
//                if (s[0].equals("POP")) {
//                    int p1 = queue.poll();
//                    if (p1 == -1) {
//                        System.out.println(p1);
//                    }
//                }
//                if (s[0].equals("SIZE")) {
//                    int size = queue.size();
//                    System.out.println(size);
//                }
//                if (s[0].equals("CLEAR")) {
//                    queue.clear();
//                }
//            }
//        }

//        for (ArrayList<String> strings : list) {
//            Queue<Integer> queue = new LinkedList<Integer>();
//            for (String string : strings) {
//                String[] s = string.split(" ");
//                if (s[0].equals("PUSH")){
//                    queue.offer(Integer.valueOf(s[1]));
//                }
//                if (s[0].equals("TOP")){
//                    int p = queue.peek();
//                    System.out.println(p);
//                }
//                if (s[0].equals("POP")){
//                    int p1 = queue.poll();
//                    if (p1 == -1){
//                        System.out.println(p1);
//                    }
//                }
//                if (s[0].equals("SIZE")){
//                    int size = queue.size();
//                    System.out.println(size);
//                }
//                if (s[0].equals("CLEAR")){
//                    queue.clear();
//                }
//            }
//        }


//        for (int i=0;i<t;i++){
//            Queue<Integer> queue = new LinkedList<Integer>();
//            for (int j=0;j<strs[i].length;j++){
//                 String[] s = strs[i][j].split(" ");
//                 if (s[0] == "PUSH"){
//                     queue.offer(Integer.valueOf(s[1]));
//                 }
//                 if (s[0] == "TOP"){
//                     int p = queue.peek();
//                     System.out.println(p);
//                 }
//                 if (s[0] == "POP"){
//                     int p1 = queue.poll();
//                     if (p1 == -1){
//                         System.out.println(p1);
//                     }
//                 }
//                 if (s[0] == "SIZE"){
//                     int size = queue.size();
//                     System.out.println(size);
//                 }
//                 if (s[0] == "CLEAR"){
//                     queue.clear();
//                 }
//            }
//        }


    }
}
