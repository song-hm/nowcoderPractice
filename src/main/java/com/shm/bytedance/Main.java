package com.shm.bytedance;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            String[] ss = str.split(",");
            int i=0,j=ss.length-1;
            int lens = ss.length;
            while (i<j && i<lens-1){
                if (Integer.valueOf(ss[i])==Integer.valueOf(ss[j])){
                    lens--;
                    i++;
                    j--;
                }else if (Integer.valueOf(ss[i])<Integer.valueOf(ss[j])){
                    i++;
                }else {
                    String tmp = ss[i];
                    ss[i] = ss[j];
                    ss[j] = tmp;
                    i++;
                }
            }

            int k;
            for ( k= 0; k < lens-1; k++) {
                if (ss[k].equals(ss[k+1])){
                    k++;
                }
                if (Integer.valueOf(ss[k])>Integer.valueOf(ss[k+1])){
                    String tmp = ss[k];
                    ss[k] = ss[k+1];
                    ss[k+1] = tmp;
                }
                if (k<lens-1) {
                    System.out.print(ss[k] + ",");
                }
            }
            if (k<lens) {
                System.out.println(ss[lens - 1]);
            }
        }
    }
}
