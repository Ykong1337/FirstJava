package com.ftg.learn.thread;

import lombok.SneakyThrows;
import org.openjdk.jol.info.ClassLayout;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LockUpgradeTest {


    @SneakyThrows
    @Test
    public void biasedLock() {
        Object obj = new Object();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        TimeUnit.SECONDS.sleep(5L);

        obj = new Object();

        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        synchronized (obj) {
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        }
    }

    @Test
    public void testSelfRotatingLock() {

        // 在偏向锁未启动状态下，创建锁实例，就是一个普通实例
        Object obj = new Object();

        // 00001001(001): 普通无锁实例后三位001，前几位记录了一些其他实例相关的信息(00001)
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        // 对普通无锁实例添加synchronized锁会使其升级到自旋锁
        synchronized (obj) {
            // 10111000(00): 自旋锁实例后两位00，其他位记录的是当前线程的LR
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        }
    }


    @SneakyThrows
    @Test
    public void test() {
        Object obj = new Object();

        System.out.println("主线程:" + ClassLayout.parseInstance(obj).toPrintable());

        Thread thread1 = new Thread(() -> {

            synchronized (obj) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {

            synchronized (obj) {
                try {

                    TimeUnit.SECONDS.sleep(1L);

                    obj.notify();

                    System.out.println("子线程2:" + ClassLayout.parseInstance(obj).toPrintable());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("主线程结束");

    }


}
