package com.shm.toOffer;

import java.util.Stack;

/**
 * 举例让抽象具体化	包含min函数的栈
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 */

/**
 * 链接：https://www.nowcoder.com/questionTerminal/4c776177d2c04c2494f2555c9fcc1e49?answerType=1&f=discussion
 * 来源：牛客网
 *
 * 这里也是使用了两个栈。
 * 一个用来存所有的元素“stackTotal”,另一个用来存加入新的元素后当前stackTotal中对应的最小值。
 * 两个栈中的元素数量始终保持一致，当新的元素小于“stackLittle”栈顶元素时，“stackLittle”像栈顶push新来的元素，否则，“stackLittle”向栈顶加入原栈顶元素。
 * 执行“pop”方法时，两个栈同时弹出各自的栈顶元素。
 */
public class FindMinInStack {

    Stack<Integer> s = new Stack<Integer>();
    Stack<Integer> sMin = new Stack<Integer>();

    public void push(int node) {
        s.push(node);
        if (sMin.empty()){
            sMin.push(node);
        }else{
            if (node<=sMin.peek()){
                sMin.push(node);
            }else{
                sMin.push(sMin.peek());
            }
        }
    }

    public void pop() {
        s.pop();
        sMin.pop();
    }

    public int top() {
        return s.peek();
    }

    public int min() {
        return sMin.peek();
    }


    /**
     * 链接：https://www.nowcoder.com/questionTerminal/4c776177d2c04c2494f2555c9fcc1e49?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 另外一点是这道题目也顺便联系java中Stack的常用的方法empty(); push(); pop();peek()；比较坑爹的时元素需要定义为static的并且要手动初始化，不然list会被初始化为null
     *
     * 我自己的想法是不希望用另外一个栈，那么为了实现这一目的，在栈中需要保留冗余的曾经的最小值，这样能够比较方便到找到当前的此小值，
     *
     */
    public class FindMinInStack_2 {

        Stack<Integer> s = new Stack<Integer>();
        Integer minEle;

        public void push(int node) {
            if (s.empty()){
                s.push(node);
                minEle = node;
            }else{
                if (node<=minEle){
                    //在push更小的值时需要保留在此值之前的最小值
                    s.push(minEle);
                    minEle = node;
                }
                s.push(node);
            }
        }

        public void pop() {
            //增加栈为空时候的检测
            if (s.size()==0){
                return;
            }
            if (minEle == s.peek()){
                if (s.size()>1){
                    s.pop();
                    minEle = s.peek();
                }
            }
            s.pop();
        }

        public int top() {
            return s.peek();
        }

        public int min() {
            return minEle;
        }

    }
}
