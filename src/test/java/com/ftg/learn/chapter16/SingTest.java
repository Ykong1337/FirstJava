package com.ftg.learn.chapter16;

import org.junit.Test;

public class SingTest {

    @Test
    public void test1(){
        Singleton s1 = Singleton.getInstance();

        System.out.println(s1.getInstance());

        Singleton s2 = Singleton.getInstance();
        System.out.println(s2.getInstance());

        System.out.println(Singleton.getInstance());
        System.out.println(s1 == s2);
    }
}
