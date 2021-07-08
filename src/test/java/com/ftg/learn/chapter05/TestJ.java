package com.ftg.learn.chapter05;

import java.util.Scanner;

public class TestJ {
    @org.junit.Test
    public void TestLearn(){
        Scanner sc = new Scanner(System.in);
        int speed = sc.nextInt();
        Test t = new Test();
        t.notice(speed);
    }
}
