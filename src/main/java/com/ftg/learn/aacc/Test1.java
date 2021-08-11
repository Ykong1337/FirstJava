package com.ftg.learn.aacc;

import org.testng.annotations.Test;

import java.util.HashSet;

public class Test1 {

    public void random() {
        HashSet<Integer> sites = new HashSet();
        while (sites.size() < 5) {
            sites.add((int) (Math.random() * 10));
        }
        for (Integer i : sites) {
            System.out.println(i);
        }
    }

    @Test
    public void test() {
        new Test1().random();
    }
}
