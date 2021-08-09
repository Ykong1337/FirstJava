package com.ftg.learn.chapter18;

import org.testng.annotations.Test;

public class Inner {

    public int add(Study s) {
        return s.good() + s.up();
    }

    @Test
    public void test(){
        Inner i = new Inner();
        System.out.println(i.add(new Study() {
            @Override
            public int good() {
                return 123;
            }

            @Override
            public int up() {
                return 456;
            }
        }));
    }

    @Test
    public void study(){
        Study s1 = new Study() {
            @Override
            public int good() {
                return 123;
            }

            @Override
            public int up() {
                return 456;
            }
        };

        System.out.println(s1.good() + s1.up());
    }

}
