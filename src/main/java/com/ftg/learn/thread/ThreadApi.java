package com.ftg.learn.thread;

import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class ThreadApi {


    @Test
    @SneakyThrows
    public void api(){
        Thread thread = new Thread(()->{
            System.out.println("线程体:" + Thread.currentThread());
        },"thread-a");

        thread.setName("thread-b");

        thread.setPriority(10);

        System.out.println("优先级:" + thread.getPriority());

        System.out.println("线程名:" + thread.getName());

        System.out.println(thread.isAlive());

        thread.start();

        System.out.println(thread.isAlive());

        System.out.println("主线程人为阻塞中,请手动停掉主线程..");
        System.in.read();
    }

    @SneakyThrows
    @Test
    public void sleep(){
        System.out.println("主线程开始睡眠");
        Thread.sleep(2000);
        System.out.println("主线程睡眠结束");

        System.out.println("主线程开始睡眠");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("主线程睡眠结束");
    }

    @SneakyThrows
    @Test
    public void join(){
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread());
            }
        };

        Thread t1 = new Thread(runnable,"thread-1");
        Thread t2 = new Thread(runnable,"thread-2");

        t1.start();

        t1.join();

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread());
        }

        System.out.println("主线程人为阻塞中");
        System.in.read();
    }


    @SneakyThrows
    @Test
    public void yield(){

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                Thread.yield();
                System.out.println(Thread.currentThread());
            }
        },"子线程").start();

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread());

        }
        System.out.println("人为阻塞中");

        System.in.read();
    }
}
