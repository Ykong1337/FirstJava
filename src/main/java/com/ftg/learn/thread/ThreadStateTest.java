package com.ftg.learn.thread;

import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ThreadStateTest {


    @SneakyThrows
    @Test
    public void test(){

        Thread thread = new Thread(()->{
            System.out.println("子线程" + Thread.currentThread() + "执行完毕");
        });


        System.out.println("当前生命周期状态：" + thread.getState());

        thread.start();

        System.out.println("当前生命周期状态：" + thread.getState());

        TimeUnit.SECONDS.sleep(9);

        System.out.println("当前生命周期状态：" + thread.getState());
    }


}
