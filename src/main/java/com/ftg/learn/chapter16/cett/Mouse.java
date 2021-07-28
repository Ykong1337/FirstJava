package com.ftg.learn.chapter16.cett;

public class Mouse implements Do {

    private String name;

    public Mouse(String name) {
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
        return "打";
    }

}
