package com.ftg.learn.chapter19.q2;

public class Proxy implements Interface {

    private Interface in;

    public Proxy(Interface in) {
        this.in = in;
    }

    @Override
    public void study() {
        System.out.println("我先玩把游戏");
        in.study();
        System.out.println("完成学习");
    }
}
