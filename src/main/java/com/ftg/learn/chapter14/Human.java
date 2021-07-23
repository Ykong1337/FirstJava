package com.ftg.learn.chapter14;

public class Human {

    private String name;

    private int age;

    private char sex;

    @Override
    public String toString() {
        return this.name + this.age + this.sex + this.id.getCardNo();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public IdCard getId() {
        return id;
    }

    public void setId(IdCard id) {
        this.id = id;
    }

    private IdCard id;
}
