package com.ftg.learn.chapter11;

import org.junit.Test;

public class LearnManyArrayTest {

    @Test
    public void test1(){
        LearnManyArray l = new LearnManyArray();
        l.notre(new int[]{1,3,1,2,1});
        l.numCount(new int[]{6,5});
    }
}
