package com.ftg.learn.chapter18;


import org.testng.annotations.Test;

public class LearnInterface {

    public void testMember(){
        class abc{

            public static final int a = 14;

            public int test(int a,int b){
                return a + b;
            }
        }
        abc a = new abc();
        a.test(23,45);
    }

    @Test
    public void test(){
        new LearnInterface().testMember();
    }
}
