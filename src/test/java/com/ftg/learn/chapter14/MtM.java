package com.ftg.learn.chapter14;

import com.ftg.learn.chapter14.MtoM.Midclass;
import com.ftg.learn.chapter14.MtoM.Subject;
import org.junit.Test;

public class MtM {

    @Test
    public void test3(){
        Student1 s1 = new Student1("张三");
        Student1 s2 = new Student1("李四");
        Student1 s3 = new Student1("王也");

        Subject subject1 = new Subject("Chinese");
        Subject subject2 = new Subject("Math");
        Subject subject3 = new Subject("English");

        Midclass[] midclasses = new Midclass[1000];

        midclasses[0] = new Midclass(1,s1,subject2);


    }
}
