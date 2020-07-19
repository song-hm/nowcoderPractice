package com.shm.kujiale;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SingletonReg {
    private static final Map<String, Object> singletonObjects = new ConcurrentHashMap<>();
    static {
        SingletonReg singletonReg = new SingletonReg();
        singletonObjects.put(singletonReg.getClass().getName(),singletonReg);
    }

    private SingletonReg(){

    }

    public static SingletonReg getInstance(String className){
        if (className == null){
            return null;
        }
        if (singletonObjects.get(className) == null){
            try {
            singletonObjects.put(className,Class.forName(className).newInstance());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return (SingletonReg)singletonObjects.get(className);
    }
}
