package com.ftg.learn.thread;

import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;

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


    @Test
    @SneakyThrows
    public void testAtomicIntegerApi(){
        AtomicInteger num = new AtomicInteger(0);
        System.out.println("num:" + num.get());
        System.out.println("++num:" + num.incrementAndGet());
        System.out.println("--num:" + num.decrementAndGet());
        System.out.println("num+=6:" + num.addAndGet(6));

        System.out.println("accumulate:" + num.accumulateAndGet(5,((left, right) -> {
            System.out.println("left:" + left + "\t");
            System.out.println("right:" + right + "\t");
            return left + right;

        })));
    }

    @Test
    @SneakyThrows
    public void testAtomicApi(){
        AtomicLong num = new AtomicLong(0);
        System.out.println("num:" + num.get());
        System.out.println("++num:" + num.getAndIncrement());
        System.out.println("--num:" + num.getAndDecrement());
        System.out.println("num+=6:" + num.getAndAdd(-6));

        System.out.println("accumulate:" + num.getAndAccumulate(5,((left, right) -> {
            System.out.println("left:" + left + "\t");
            System.out.println("right:" + right + "\t");
            return left + right;

        })));
    }

    @Test
    public void testAtomicBooleanApi(){
        AtomicBoolean flag = new AtomicBoolean(false);
        System.out.println("flag:" + flag.get());
        System.out.println("返回flag，修改flag:" + flag.getAndSet(true));
        System.out.println("flag:" + flag.get());
    }


    @Test
    public void testAtomicIntegerArray() {

        // 创建一个原子的Integer[]实例，初始值为{3, 2}
        AtomicIntegerArray arr = new AtomicIntegerArray(new int[]{3, 2});

        // 获取arr[0]的值
        System.out.println("arr[0]: " + arr.get(0));

        // 对arr[0]加1并返回
        System.out.println("++(arr[0]): " + arr.incrementAndGet(0));

        // 对arr[0]减1并返回
        System.out.println("--(arr[0]): " + arr.decrementAndGet(0));

        // 对arr[0]加6并返回
        System.out.println("(arr[0])+=6: " + arr.addAndGet(0, 6));

        // 自定义计算，p1为Lambda表达式中right的初始值，left的值为当前的num值
        // 先计算，然后再返回
        System.out.println("accumulate: " + arr.accumulateAndGet(0, 5, (left, right) -> {
                    System.out.printf("left: %s right: %s\n", left, right);
                    return left + right;
                }
        ));

        // 查看arr[0]最终的值
        System.out.println("arr[0]: " + arr.get(0));
    }




}
