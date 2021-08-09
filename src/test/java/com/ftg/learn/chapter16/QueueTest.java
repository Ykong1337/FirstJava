package com.ftg.learn.chapter16;

import com.ftg.learn.chapter21.queue.Queue;
import org.junit.Test;

public class QueueTest {

    @Test
    public void test(){
        Queue<Integer> queue = new Queue<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }
}
