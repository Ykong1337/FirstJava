package com.ftg.learn.chapter10;

public class Test {

    @org.junit.Test
    public void testInit(){
        new ArrayInit().moveValue(new int[]{1,2,3,4,5,6,7,8,9},2,7);
    }

    @org.junit.Test
    public void test2(){
        new ArrayInit().moveVal(new int[]{1,2,3,4,5,6,7,8,9},-10);
    }
}
