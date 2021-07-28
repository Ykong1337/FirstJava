package com.ftg.learn.chapter15.Abs;

import org.junit.jupiter.api.Test;

public class C extends A {

    public C(int i) {
        super(i);
    }

    @Override
    public void Abs() {
        System.out.println("C");
    }


}
