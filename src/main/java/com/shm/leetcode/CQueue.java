package com.shm.leetcode;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.Stack;

public class CQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public CQueue() {
        s1 = new Stack();
        s2 = new Stack();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (!s2.isEmpty()) {
            return s2.pop();
        }else if(!s1.isEmpty()) {
            while (!s1.isEmpty()) {
                Integer p = s1.pop();
                s2.push(p);
            }
            return s2.pop();
        }else {
            return -1;
        }
    }
}
