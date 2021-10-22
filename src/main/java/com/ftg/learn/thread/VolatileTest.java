package com.ftg.learn.thread;


import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VolatileTest {

    private static class VolatileDemo implements Runnable{

        private volatile boolean flag;

        @Override
        @SneakyThrows
        public void run() {
            while (!flag){
                System.out.println("子线程重复中");
                TimeUnit.MILLISECONDS.sleep(200);
            }

            System.out.println("子线程执行完毕");
        }


    }

    @SneakyThrows
    @Test
    public void test(){
        VolatileDemo volatileDemo = new VolatileDemo();
        new Thread(volatileDemo).start();

        TimeUnit.SECONDS.sleep(2);

        volatileDemo.flag = true;
        System.out.println("主线程改变flag为true");
        System.out.println("主线程执行完毕");

        System.out.println("主线程人为阻塞");
        System.in.read();
    }
}

