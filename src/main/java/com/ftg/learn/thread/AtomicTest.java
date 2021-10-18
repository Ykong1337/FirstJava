package com.ftg.learn.thread;

import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    private int num;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @SneakyThrows
    @Test
    public void test(){
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    num++;
                    atomicInteger.incrementAndGet();
                }
                System.out.println("num:" + num);
                System.out.println("atomicNum:" + atomicInteger);

            }).start();
        }

        TimeUnit.SECONDS.sleep(10L);
    }
}
