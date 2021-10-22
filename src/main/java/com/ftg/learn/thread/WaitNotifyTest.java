package com.ftg.learn.thread;

import lombok.Data;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class WaitNotifyTest {


    @Data
    private static class Food implements Serializable {
        private String name;
        private String type;
        private boolean exist;
    }

    public static class AsyncProducer implements Runnable{

        private final Food food;
        private boolean isEnglish;

        public AsyncProducer(Food food) {
            this.food = food;
        }

        @Override
        public void run(){

            while(true){
                if (isEnglish){
                    food.setName("cake");
                    food.setType("mickey");
                } else {
                    food.setName("蛋糕");
                    food.setType("米奇");
                }
                isEnglish = !isEnglish;
            }

        }

    }

    private static class AsyncConsumer implements Runnable {

        private final Food food;

        AsyncConsumer(Food food) {
            this.food = food;
        }

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(300L);
                System.out.println(food);
            }
        }
    }


    private Food food = new Food();

    /**
     * 测试异步的生产消费者模型
     */
    @SneakyThrows
    @Test
    public void testAsyncVersion() {

        // 开启并启动一个生产者线程
        new Thread(new AsyncProducer(food)).start();

        // 开启并启动一个消费者线程
        new Thread(new AsyncConsumer(food)).start();

        // 阻止主线程结束
        System.out.println("主线程人为阻塞中，请手动停掉主线程...");
        System.out.println(System.in.read());
    }


}
