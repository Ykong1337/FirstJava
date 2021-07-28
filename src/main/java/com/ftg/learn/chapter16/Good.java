package com.ftg.learn.chapter16;

public class Good extends Human implements Pd{


    public Good(String name) {
        super(name);
    }

    @Override
    public String Pd() {
        return "排队了";
    }

    @Override
    public void dF() {
        System.out.println(this.getName() + "打饭" + Pd());
    }
}
