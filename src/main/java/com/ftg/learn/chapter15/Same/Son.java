package com.ftg.learn.chapter15.Same;

import com.ftg.learn.chapter15.Access.Human1;
import org.junit.jupiter.api.Test;

public class Son extends Human1{

    public void test4(){
        super.publicM();
        super.protectedM();
    }
}
