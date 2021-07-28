package com.ftg.learn.chapter16;

public abstract class Human {

    private String name;

    public String getName() {
        return name;
    }

    public Human(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void dF();

}
