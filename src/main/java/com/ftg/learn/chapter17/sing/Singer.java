package com.ftg.learn.chapter17.sing;

public class Singer implements ISinger{

    private String name;

    public Singer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void singSong(String name) {
        System.out.println("我是" + this.name);
        System.out.println("给大家带来一首" + name);
    }


}
