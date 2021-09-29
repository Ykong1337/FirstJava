package com.ftg.learn.doc.controller;

import com.alibaba.fastjson.JSON;
import com.ftg.learn.doc.entity.TypeEnum;
import com.ftg.learn.doc.entity.UnitEnum;
import com.ftg.learn.doc.service.SaleService;
import com.ftg.learn.doc.service.SelectService;
import org.testng.annotations.Test;

public class SaleController {

    SaleService saleService = new SaleService();

    public String insertSale(Integer id, String name, String address, Integer fid, UnitEnum unit, Double price, TypeEnum type, String scdate, String ccdate){
        return JSON.toJSONString(saleService.insertSale(id,name,address,fid,unit,price,type,scdate,ccdate));
    }

    public String updateSale(Integer id, String name, String address, Integer fid, UnitEnum unit, Double price, TypeEnum type, String scdate, String ccdate){
        return JSON.toJSONString(saleService.updateSale(id,name,address,fid,unit,price,type,scdate,ccdate));
    }

    public String deleteSale(Integer id){
        return JSON.toJSONString(saleService.deleteSale(id));
    }

    public String detail(){
        return JSON.toJSONString(saleService.detail());
    }

    public String selectPage(int page, int pageNum){
        return JSON.toJSONString(saleService.selectLimit(page,pageNum));
    }

    @Test
    public void test(){
        SaleController s = new SaleController();
//        s.insertSale(23,"aaaaaaaaaaaaaaaaaaaa","aaa",1,UnitEnum.瓶,20.1,TypeEnum.水果,"2021-12-21","2022-11-11");
//        s.deleteSale(24);

        SelectService d = new SelectService();
        d.showAll().forEach(System.out::println);
    }

}
