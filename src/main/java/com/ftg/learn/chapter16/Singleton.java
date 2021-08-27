package com.ftg.learn.chapter16;

public class Singleton {

    private static Singleton instance = new Singleton();
    private Singleton (){}
    public static Singleton getInstance() {
        return instance;
    }

}
