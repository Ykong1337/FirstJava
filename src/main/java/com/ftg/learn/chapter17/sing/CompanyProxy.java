package com.ftg.learn.chapter17.sing;

public class CompanyProxy implements ISinger{

    private ISinger iSinger;

    public CompanyProxy(ISinger iSinger){
        this.iSinger = iSinger;
    }

    @Override
    public void singSong(String name) {
        System.out.println("谈钱");
        System.out.println("推广");
        System.out.println("开演唱会");
        iSinger.singSong(name);
        System.out.println("感谢");
    }
}
