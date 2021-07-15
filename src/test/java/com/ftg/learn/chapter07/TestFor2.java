package com.ftg.learn.chapter07;

import org.junit.Test;

public class TestFor2 {
    @Test
    public void Test(){
        LearnFor2 l = new LearnFor2();
        l.printStar(7);
    }

    @Test
    public void Test2(){
        For3 t = new For3();
        t.For14();
    }

    @Test
    public void Test3(){
        For3 f = new For3();
        int x = f.jumpFrog(102,3,1);
        System.out.println(x);

        f.Test11();
    }


    @Test
    public void Test4(){
        Test10 t = new Test10();
        t.questLast();
        System.out.println(Math.round(-11.5));
    }
}
