package com.ftg.learn.chapter16;

public class Bad extends Human implements Pd{


    public Bad(String name) {
        super(name);
    }

    @Override
    public void dF() {
        System.out.println(this.getName() + "打饭" + Pd());
    }

    @Override
    public String Pd() {
        return "不排队";
    }
}
