package com.ftg.learn.chapter20;

import org.junit.jupiter.api.Test;

public class LearnThrow {


    public int add(int x, int y) throws MException {
        if (x < 0 || y < 0) {
            throw new MException(EnumEx.e_002);
        } else {
            //在哪里执行等要求由程序员决定

            //throw也可以结束方法

            //throw运行时异常及其子类时无需在方法上加throws
            return x + y;
        }
    }

    @Test
    public void test() throws MException {
        new LearnThrow().add(2,3);
    }
}
