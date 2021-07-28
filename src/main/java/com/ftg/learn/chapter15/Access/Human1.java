package com.ftg.learn.chapter15.Access;

public class Human1 {

    private String name = "张三";

    char sex = '男';

    protected int age = 18;

    public String address = "中国";


    private void privateM(){
        System.out.println(name);
    }

    void defaultM(){
        System.out.println(sex);
    }

    protected void protectedM(){
        System.out.println(age);
    }

    public void publicM(){
        System.out.println(address);
    }


    public void test1(){
        privateM();
        defaultM();
        protectedM();
        publicM();
    }

}
