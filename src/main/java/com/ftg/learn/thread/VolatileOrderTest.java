package com.ftg.learn.thread;

import lombok.SneakyThrows;
import org.testng.annotations.Test;

public class VolatileOrderTest {


    private int x = 0, y = 0, a = 0, b = 0;

    @Test
    @SneakyThrows
    public void testOrder() {

        int count = 0;
        while (true) {
            count++;

            Thread thread1 = new Thread(() -> {
                a = 1;
                x = b;
            });

            Thread thread2 = new Thread(() -> {
                b = 1;
                y = a;
            });

            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();

            System.out.printf("第%d次:x = %d,y = %d \n", count, x, y);

            if (x == 0 && y == 0) {
                System.out.println("指令重排序");
                break;
            } else {
                x = 0;
                y = 0;
                a = 0;
                b = 0;
            }
        }
        System.out.println("阻塞进程");
        System.in.read();
    }
}
