package com.ftg.learn.thread;

import org.testng.annotations.Test;

import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;

public class AdderTest {

    @Test
    public void testLongAdder() {
        LongAdder num = new LongAdder();
        System.out.println("num:" + num);
        num.add(5);
        System.out.println("after + 5:" + num);
        num.increment();
        System.out.println("after + 1:" + num);
        num.decrement();
        System.out.println("after - 1:" + num);
    }

    @Test
    public void testDoubleAdder(){
        DoubleAdder num = new DoubleAdder();
        System.out.println("num:" + num);
        num.add(5);
        System.out.println("after + 5.5:" + num);
    }

}
