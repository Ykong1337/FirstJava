package com.ftg.learn.doc.service;

import com.ftg.learn.doc.mapper.SelectInfo;
import com.ftg.learn.doc.util.AbsService;

import java.util.List;
import java.util.Map;

public class SelectService extends AbsService {


    SelectInfo si = super.getSession().getMapper(SelectInfo.class);

    //------------------------------------Function----------------------------------

    //统计“风起地”生产的全部商品信息，以及当前农场的产品价格排名
    public List<Map<String, Object>> select1() {
        return si.showRedStar();
    }

    //统计“953西红柿”所有生产农场的信息，以及价格排名
    public List<Map<String, Object>> select2() {
        return si.show953();
    }

    //列出所有农场的所有商品信息
    public List<Map<String, Object>> select3() {
        return si.showAllSale();
    }

    //统计所有“食品类型“的商品信息并按价格升序排列
    public List<Map<String, Object>> select4() {
        return si.showTypeOrder();
    }


    //-------------------------------------Util---------------------------------------

    //查所有
    public List<Map<String, Object>> showAll() {
        return si.showAll();
    }

    //查所有2
    public List<Map<String, Object>> showAll2() {
        return si.showAll2();
    }

    //检测农场个数的
    public int fidTest() {
        return si.fidTest();
    }

    //检测sale表数据个数
    public int sidTest() {
        return si.sidTest();
    }
}
