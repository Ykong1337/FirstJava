package com.ftg.learn.thread;

import lombok.Data;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class ProducerConsumerTest {

    /**
     * 生产消费模型中的资源实体Food
     */
    @Data
    private static class Food implements Serializable {
        private String name;
        private String type;
    }

    /**
     * 生产者
     */
    private static class Producer implements Runnable {

        private final Food food;
        private boolean isEnglish;

        Producer(Food food) {
            this.food = food;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    // 这里不能使用this锁
                    synchronized (food) {
                        if (isEnglish) {
                            food.setName("cake");
                            food.setType("mickey");
                        } else {
                            food.setName("蛋糕");
                            food.setType("米旗");
                        }
                        isEnglish = !isEnglish;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    /**
     * 消费者
     */
    private static class Consumer implements Runnable {

        private final Food food;

        Consumer(Food food) {
            this.food = food;
        }

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                try {
                    // 这里不能使用this锁
                    synchronized (food) {
                        TimeUnit.MILLISECONDS.sleep(300L);
                        System.out.println(food);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    /**
     * 测试生产消费者模型
     */
    @SneakyThrows
    @Test
    public void testProducerConsumer() {
        Food food = new Food();
        new Thread(new Producer(food)).start();
        new Thread(new Consumer(food)).start();

        // 阻塞junit线程
        TimeUnit.SECONDS.sleep(10);
    }
}
