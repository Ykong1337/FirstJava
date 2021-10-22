package com.ftg.learn.thread;

import lombok.Data;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class StopThreadTest {

    /**
     * 测试使用标识变量的方式停止运行中的线程
     */
    @Data
    private static class NormalThreadDemo implements Runnable {

        /**
         * 标识当前线程体中的while循环是否可以结束
         */
        private boolean isStop;

        @SneakyThrows
        @Override
        public synchronized void run() {
            while (!isStop) {
                TimeUnit.SECONDS.sleep(1L);
                System.out.println("子线程运行...");
            }
            System.out.println("子线程结束...");
        }
    }

    /**
     * 测试强行停止挂起中的线程
     */
    @Data
    private static class SuspendedThreadDemo implements Runnable {

        /**
         * 标识当前线程体中的while循环是否可以结束
         */
        private boolean isStop;

        @SneakyThrows
        @Override
        public synchronized void run() {
            while (!isStop) {
                try {
                    // 让子线程挂起
                    System.out.println("子线程挂起...");
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("子线程被interrupt打断...");
                    isStop = true;
                }
            }
            System.out.println("子线程结束...");
        }
    }

    /**
     * 测试：停止一个正常运行的线程
     */
    @SneakyThrows
    @Test
    public void testStopNormalThread() {
        NormalThreadDemo normalThreadDemo = new NormalThreadDemo();
        new Thread(normalThreadDemo).start();

        // 主线程在5s后手动更改线程实例中的isStop标识变量
        TimeUnit.SECONDS.sleep(5L);
        normalThreadDemo.setStop(true);

        // 阻塞junit线程
        TimeUnit.SECONDS.sleep(10);
    }

    @SneakyThrows
    @Test
    public void testStopSuspendedThread() {
        Thread thread = new Thread(new SuspendedThreadDemo());
        thread.start();

        // 主线程在5s后强行打断该线程，会爆发InterruptedException异常
        TimeUnit.SECONDS.sleep(5L);
        thread.interrupt();

        // 阻塞junit线程
        TimeUnit.SECONDS.sleep(10);
    }

}
