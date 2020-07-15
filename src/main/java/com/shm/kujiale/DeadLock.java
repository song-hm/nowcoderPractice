package com.shm.kujiale;

public class DeadLock {
    private static Object o1 = new Object();
    private static Object o2 = new Object();

    public static void main(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o1){
                    System.out.println(Thread.currentThread()+"get o1");
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread()+"wait o2");
                    synchronized (o2){
                        System.out.println(Thread.currentThread()+"get o2");
                    }
                }
            }
        },"t1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o2){
                    System.out.println(Thread.currentThread()+"get o2");
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread()+"wait o1");
                    synchronized (o1){
                        System.out.println(Thread.currentThread()+"get o1");
                    }
                }
            }
        }, "t2").start();
    }
}
