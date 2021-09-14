package com.ftg.learn.aacc;

import org.testng.annotations.Test;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Cc {
    private static volatile int s = 0;
    private static final ThreadPoolExecutor async = new ThreadPoolExecutor(
            0,Integer.MAX_VALUE,
            60L, TimeUnit.SECONDS,new SynchronousQueue<>()
    );


    @Test
    public void test1() throws InterruptedException{
        for (int i = 0;i < 10000;i++){
            async.execute(()->s++);
        }
        Thread.sleep(5000L);
        System.out.println(s);
    }
}
