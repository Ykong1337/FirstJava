package com.ftg.learn.aacc;

import org.testng.annotations.Test;

public class Sum {

    public int sum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sum(n - 1);
        }
    }

    @Test
    public void test() {
        System.out.println(new Sum().sum(100));
    }
}
