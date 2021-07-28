package com.ftg.learn.chapter16.cett;

public class Cat implements Do {

    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String play() {
        return "玩耍";
    }

    @Override
    public String hate() {
        return "大哭";
    }


}
