package com.ftg.learn.doc.controller;

import com.alibaba.fastjson.JSON;
import com.ftg.learn.doc.service.SelectService;
import org.testng.annotations.Test;

public class SelectController {

    SelectService selectService = new SelectService();

    public String select1(){
        return JSON.toJSONString(selectService.select1());
    }

    public String select2(){
        return JSON.toJSONString(selectService.select2());
    }

    public String select3(){
        return JSON.toJSONString(selectService.select3());
    }

    public String select4(){
        return JSON.toJSONString(selectService.select4());
    }

    @Test
    public void t(){
        SelectController s = new SelectController();
        System.out.println(s.select1());
    }
}
