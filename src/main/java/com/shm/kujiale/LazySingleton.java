package com.shm.kujiale;

public class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton(){
    }
    public static LazySingleton getInstance(){
        if (instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }

    public static synchronized LazySingleton getInstance_1(){
        if (instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }

    public static LazySingleton getInstance_2(){
        if (instance == null){
            synchronized (LazySingleton.class){
                if (instance == null){
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
