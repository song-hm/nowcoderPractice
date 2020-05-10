package com.shm.toOffer;

import java.util.Stack;

/**举例让抽象具体化	栈的压入、弹出序列
 * 题目描述
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 *
 */
public class IsPopOrder {

    /**
     * 思路：新建一个栈，将数组A压入栈中，当栈顶元素等于数组B时，就将其出栈，当循环结束时，判断栈是否为空，若为空则返回true.
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {

        if (pushA.length == 0 || popA.length == 0 || popA.length != pushA.length) {
            return false;
        }
        Stack<Integer> s = new Stack<>();
        int j =0;
        for (int i=0;i<pushA.length;i++){
            s.push(pushA[i]);

            while (!s.empty() && s.peek()==popA[j]){
                s.pop();
                j++;
            }
        }
        return s.empty();
    }
}

