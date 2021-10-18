package com.ftg.learn.thread;

import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DeadLockTest implements Runnable{

    private final Object objA = new Object();
    private final Object objB = new Object();

    @SneakyThrows
    @Override
    public void run(){
        if(Thread.currentThread().getName().equals("线程A")){
            synchronized (objA){
                System.out.println("if:objA");
                TimeUnit.SECONDS.sleep(1L);
                synchronized (objB){
                    System.out.println("if:objB");
                }
            }
        } else {
            synchronized (objB){
                System.out.println("else:objB");
                TimeUnit.SECONDS.sleep(1L);
                synchronized (objA){
                    System.out.println("else:objA");
                }
            }
        }
    }

    @SneakyThrows
    @Test
    public void test(){
        Runnable runnable = new DeadLockTest();
        new Thread(runnable,"线程A").start();
        new Thread(runnable,"线程B").start();

        TimeUnit.SECONDS.sleep(10L);
    }
}
