package com.ftg.learn.chapter19.q1;

/**
 * 鸟
 */
public class Bird extends Animals{

    private String feather;

    private Wing wing = new Wing();

    public void layEggs(){

    }

    public String getFeather() {
        return feather;
    }

    public void setFeather(String feather) {
        this.feather = feather;
    }
}
