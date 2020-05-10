package com.shm.tengxun;

import java.util.Scanner;
import java.util.Stack;
//t4
/**
 * 6
 * add 1
 * add 2
 * add 3
 * peek
 * poll
 * peek
 *
 *
 * 1
 * 2
 */
public class Main_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
//        String[] strs = new String[t];
        Stack2Queue queue = new Stack2Queue();
        for (int i = 0; i < t; i++) {
            String str = sc.nextLine();
            if (str.contains(" ")){
                String[] strings = str.split(" ");
                queue.push(Integer.valueOf(strings[1]));
            }
            if (str.equals("poll")){
                queue.pop();
            }
            if (str.equals("peek")){
                System.out.println(queue.peek());
            }
        }

//        for (int i=0;i<strs.length;i++){
//            if (strs[i].contains(" ")){
//                String[] strings = strs[i].split(" ");
//                queue.push(Integer.valueOf(strings[1]));
//            }
//            if (strs[i].equals("poll")){
//                queue.pop();
//            }
//            if (strs[i].equals("peek")){
//                System.out.println(queue.peek());
//            }
//        }
    }
}

class Stack2Queue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.size() <= 0){
            while(stack1.size()!=0){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek(){
        if(stack2.size() <= 0){
            while(stack1.size()!=0){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
}