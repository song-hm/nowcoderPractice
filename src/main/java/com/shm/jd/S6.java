package com.shm.jd;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class S6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        in.nextLine();
        HashMap<Node, Integer> map = new HashMap<>();
        int k=0;
        for (int i = 0; i < (n * 6)-1; i++) {
            String[] split = in.nextLine().split(" ");
            int r1 = Integer.parseInt(split[0]);
            int r2 = Integer.parseInt(split[1]);
            if (r1 > r2) {
                int temp = r1;
                r1 = r2;
                r2 = temp;
            }
            Node node = new Node();
            node.h = r1;
            node.w = r2;
            if (map.get(node) != null) {
                map.put(node, 2);
            }else {
                map.put(node, 1);
            }
            if(k==5) {
                k=0;
                Iterator<Entry<Node, Integer>> it = map.entrySet().iterator();
                int count=0;
                while(it.hasNext()){
                    Entry<Node, Integer> next = it.next();
                    Integer value = next.getValue();
                    if(value==2) {
                        count++;
                    }
                }
//                if (count == 1 || count == 2 || count == 3) System.out.println("POSSIBLE");
                if(count==3) {
                    System.out.println("POSSIBLE");
                }else {
                    System.out.println("IMPOSSIBLE");
                }
                map.clear();
            }
            k++;
        }
    }
}

class Node {
    int h;
    int w;
    int count = 0;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + h;
        result = prime * result + w;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Node other = (Node) obj;
        if (h != other.h) {
            return false;
        }
        if (w != other.w) {
            return false;
        }
        return true;
    }
}