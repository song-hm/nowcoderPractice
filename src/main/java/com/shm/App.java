package com.shm;

import com.shm.toOffer.Multiply;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
//        Multiply multiply = new Multiply();
//        System.out.println( "Hello World!" );
        final Object o = new Object();
        Thread t1 = new Thread() {
            public void run() {
                synchronized (o){
                    try {
                        o.wait();
                        System.out.println("Thread 1 wake up");
                    }catch (InterruptedException e){

                    }
                }
            }
        };
        t1.start();
        Thread.sleep(1000);
        Thread t2 = new Thread(){
            public void run(){
                synchronized (o){
                    o.notifyAll();
                    System.out.println("Thread 2 sent notify.");
                }
            }
        };
        t2.start();
    }
}
