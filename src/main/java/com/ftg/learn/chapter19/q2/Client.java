package com.ftg.learn.chapter19.q2;

import org.junit.jupiter.api.Test;

public class Client {

    @Test
    public void test() {

//        Interface in = new Target();
//        in.study();
//
//        System.out.println("=================");
        Interface in1 = new Proxy(new Target());
        in1.study();
    }

}
