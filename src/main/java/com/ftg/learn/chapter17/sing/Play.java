package com.ftg.learn.chapter17.sing;

import org.testng.annotations.Test;

public class Play {


    @Test
    public void play(){
        ISinger iSinger = new CompanyProxy(new Singer("刘德华"));
        iSinger.singSong("笨小孩");
    }
}
