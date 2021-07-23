package com.ftg.learn.chapter14;

public class Food {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void to(Cat cat){
        System.out.println("给" + cat.getName() + "喂食" + this.name);

    }

    public void to(Me me){
        System.out.println("我的早餐是" + this.name);
    }
}
