package com.shm.kujiale;

public class StaticSingleton {
    private StaticSingleton(){
    }
    private static class StaticSingletonHolder{
        private static StaticSingleton instance = new StaticSingleton();
    }
    public static StaticSingleton getInstance(){
        return StaticSingletonHolder.instance;
    }
}
