package com.ftg.learn.doc.controller;

import com.alibaba.fastjson.JSON;
import com.ftg.learn.doc.entity.FrameEnum;
import com.ftg.learn.doc.service.FramerService;
import com.ftg.learn.doc.service.SelectService;
import org.testng.annotations.Test;

public class SaleFramerController{

    FramerService framerService = new FramerService();

    public String selectPage(int page, int pageNum){
        return JSON.toJSONString(framerService.selectLimit(page,pageNum));
    }

    public String insertSale(Integer id,String name, String address, String boss, FrameEnum type){
        return JSON.toJSONString(framerService.insertFramer(id,name,address,boss,type));
    }

    public String updateSale(Integer id, String name, String address, String boss, FrameEnum type){
        return JSON.toJSONString(framerService.updateFramer(id,name,address,boss,type));
    }

    public String deleteSale(Integer id){
        return JSON.toJSONString(framerService.deleteFramer(id));
    }

    public String detail(){
        return JSON.toJSONString(framerService.detail());
    }

    @Test
    public void t(){
        SaleFramerController s = new SaleFramerController();
        s.insertSale(11,"aaaaaaaaaaaaaaaaaaaaaaa","ccc","yyy",FrameEnum.自营);
        SelectService d = new SelectService();
        d.showAll2().forEach(System.out::println);
    }

}
