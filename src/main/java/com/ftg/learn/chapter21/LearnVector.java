package com.ftg.learn.chapter21;

import org.junit.jupiter.api.Test;

import java.util.Vector;

public class LearnVector {

    Vector<Integer> v = new Vector(5,1);

    public void vT(){
        v.add(0);
        v.add(1);
        v.add(2);
        v.add(3);
        v.add(4);
        v.add(5);
        v.add(6);
        v.add(7);
        v.add(8);
        v.add(9);
        v.add(10);

        System.out.println(v.size());
        System.out.println(v.capacity());
    }

    @Test
    public void test(){
        new LearnVector().vT();
    }

    @Test
    public void M(){
        Myh<Integer> m = new Myh(5,1);

        m.add(1);
        m.add(2);
        m.remove(1);

        System.out.println(m.get(0));
        System.out.println(m.size());
    }
}
