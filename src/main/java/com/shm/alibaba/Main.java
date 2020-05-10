package com.shm.alibaba;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        HashMap<Character,Integer> shm = new HashMap<>();
        HashMap<Character,Integer> thm = new HashMap<>();
        for (int i=0; i<s.length();i++){
           Character cs = s.charAt(i);
           if (shm.containsKey(cs)){
              Integer svalue = shm.get(cs).intValue() + 1;
              shm.put(cs,svalue);
           }
           shm.put(cs,1);

            Character ct = s.charAt(i);
            if (thm.containsKey(ct)){
                Integer tvalue = thm.get(ct).intValue() + 1;
                thm.put(ct,tvalue);
            }
            thm.put(ct,1);
        }
        if(shm.entrySet().equals(thm.entrySet())){
            int m = 0;
            for (int j = 0; j <s.length(); j++){
                if (t.charAt(j) != s.charAt(j)){
                    m++;
                }
            }
            System.out.println(m);
        }else{
            System.out.println(-1);
        }

    }
}