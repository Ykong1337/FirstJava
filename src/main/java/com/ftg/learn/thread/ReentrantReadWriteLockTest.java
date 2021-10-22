package com.ftg.learn.thread;

import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {

    /**
     * 读写锁实例
     */
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    /**
     * 读写锁中的读锁实例
     */
    private Lock readLock = lock.readLock();

    /**
     * 读写锁中的写锁实例
     */
    private Lock writeLock = lock.writeLock();

    void read() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "正在读...");

            // 模拟读操作耗时5秒
            TimeUnit.SECONDS.sleep(5L);
            System.out.println(Thread.currentThread().getName() + "读完了...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    void write() {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "正在写...");

            // 模拟写操作耗时2秒
            TimeUnit.SECONDS.sleep(2L);
            System.out.println(Thread.currentThread().getName() + "写完了...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    @SneakyThrows
    @Test
    public void testReadWriteLock() {
        ReentrantReadWriteLockTest readWriteLockDemo = new ReentrantReadWriteLockTest();
        new Thread(readWriteLockDemo::read, "读线程A").start();
        new Thread(readWriteLockDemo::read, "读线程B").start();
        new Thread(readWriteLockDemo::write, "写线程A").start();
        new Thread(readWriteLockDemo::write, "写线程B").start();

        // 阻塞junit线程
        TimeUnit.SECONDS.sleep(30);
    }

}
