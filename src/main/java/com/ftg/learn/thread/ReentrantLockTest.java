package com.ftg.learn.thread;


import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    /**
     * 可重入锁测试：添加重入锁/释放锁
     */
    private static class LockDemo implements Runnable {

        /**
         * 创建一个可重入锁实例
         */
        private Lock lock = new ReentrantLock();

        /**
         * 线程体
         */
        @Override
        public void run() {
            lock.lock();
            try {

                // 打印5遍当前线程
                for (int i = 0; i < 5; i++) {
                    TimeUnit.SECONDS.sleep(1L);
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }

                // 调用method()方法，测试ReentrantLock是否可重入
                method();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        /**
         * 方法内使用lock进行上锁和解锁
         */
        private void method() {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + ": 执行完毕");
            } finally {
                // 释放锁的代码必须写在finally块中
                lock.unlock();
            }
        }
    }

    /**
     * 可重入锁测试：尝试获取锁
     */
    private static class TryLockDemo {

        /**
         * 创建一个可重入锁实例
         */
        private Lock lock = new ReentrantLock();

        /**
         * 每隔1s打印1次当前线程，共打印五次
         */
        private void methodA() {
            lock.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    TimeUnit.SECONDS.sleep(1L);
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        /**
         * 尝试在3秒内获取锁
         */
        private void methodB() {
            // 记录是否获取到了锁
            boolean locked = false;
            try {
                // 3秒内不断尝试获取锁，该过程不阻塞线程
                locked = lock.tryLock(3, TimeUnit.SECONDS);
                System.out.println(locked ?
                        Thread.currentThread().getName() + ": 获取到了锁..." :
                        Thread.currentThread().getName() + ": 没有获取到锁..." );
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (locked) {
                    lock.unlock();
                }
            }
        }
    }

    @Test
    @SneakyThrows
    public void testLock() {
        LockDemo lockDemo = new LockDemo();
        new Thread(lockDemo).start();
        new Thread(lockDemo).start();

        // 阻塞junit线程
        TimeUnit.SECONDS.sleep(20);
    }

    @Test
    @SneakyThrows
    public void testTryLock() {
        TryLockDemo trylockDemo = new TryLockDemo();

        // 启动一个线程，执行trylockDemo实例中的methodA()
        new Thread(trylockDemo::methodA).start();

        TimeUnit.SECONDS.sleep(1L);

        // 启动一个线程，执行trylockDemo实例中的methodB()
        new Thread(trylockDemo::methodB).start();

        // 阻塞junit线程
        TimeUnit.SECONDS.sleep(20);
    }

}
