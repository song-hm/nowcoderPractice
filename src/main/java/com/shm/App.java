package com.shm;

import com.shm.toOffer.Multiply;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws Exception
    {

//        Multiply multiply = new Multiply();
//        System.out.println( "Hello World!" );


//        final Object o = new Object();
//        Thread t1 = new Thread() {
//            public void run() {
//                synchronized (o){
//                    try {
//                        o.wait();
//                        System.out.println("Thread 1 wake up");
//                    }catch (InterruptedException e){
//
//                    }
//                }
//            }
//        };
//        t1.start();
//        Thread.sleep(1000);
//        Thread t2 = new Thread(){
//            public void run(){
//                synchronized (o){
//                    o.notifyAll();
//                    System.out.println("Thread 2 sent notify.");
//                }
//            }
//        };
//        t2.start();

        String s1 = "hello";
//        if (s1 == "hello"){
//            System.out.println("s1 = \"hello\" ");
//        }else {
//            System.out.println("s1 !=hello ");
//        }

        String s2 = "hello";
        String c = new String("join us");
        String d = "join us";
        String e = c.intern();
//        System.out.println(String.format("%b %b %b %b %b",s1 == s2,c==d,c.equals(d),c==e,d==e));

        int x=3,y=6,a=0;
        while (x++!=(y-=1)){
            a+=1;
            if (y<x) break;
        }
        System.out.println(""+x+y+a);
//        int[] array = new int[]{5,3,8,6,9,2,1,7};
//        sort(array);
//        System.out.println(Arrays.toString(array));
    }

    static void sort(int[] arr){
        int sortBorder = 0;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean isSort = true;
//            for (int j = arr.length-1; j > i; j--) {
            for (int j = arr.length-1; j > sortBorder; j--) {
                if (arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    isSort = false;
                    index = j;
                }
            }
            sortBorder = index;
            if (isSort){
                break;
            }
        }
    }
}
