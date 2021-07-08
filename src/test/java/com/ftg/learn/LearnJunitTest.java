package com.ftg.learn;

import com.ftg.learn.chapter03.LearnJunit;
import org.junit.Assert;
import org.junit.Test;

/**
 * 这是一个测试类，用于测试learnjunit里添加方法
 *
 */
public class LearnJunitTest {

    @Test
    public void testAdd(){
        int x = 13;
        int y = 14;
        int sum = LearnJunit.add(x,y);
        Assert.assertEquals(27,sum);
    }

    @Test
    public void testAdd3(){
        int x = 13;
        int y = 14;
        int z = 15;
        int sum = LearnJunit.add(x,y,z);
        Assert.assertEquals(42,sum);
    }

    @Test
    public void testDivide(){
        int x = 15;
        int y = 7;
        int Divide = LearnJunit.divide(x,y);
        Assert.assertEquals(2,Divide);
    }
}
