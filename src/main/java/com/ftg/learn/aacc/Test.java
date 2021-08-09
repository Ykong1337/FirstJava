package com.ftg.learn.aacc;

import java.util.HashSet;

public class Test {

    public void random() {
        HashSet<Integer> sites = new HashSet();
        while (sites.size() < 10) {
            sites.add((int) (Math.random() * 20));
        }
        for (Integer i : sites) {
            System.out.println(i);
        }
    }

    @org.testng.annotations.Test
    public void test() {
        new Test().random();
    }
}
