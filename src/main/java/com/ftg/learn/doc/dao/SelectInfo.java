package com.ftg.learn.doc.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface SelectInfo {

    //统计“风起地”生产的全部商品信息，以及当前农场的产品价格排名
    @Select("SELECT A.* FROM sale A,saleframer B WHERE B.name='风起地' ORDER BY A.price DESC")
    List<Map<String, Object>> showRedStar();

    //统计“953西红柿”所有生产农场的信息，以及价格排名
    @Select("SELECT B.* FROM sale A,saleframer B WHERE A.fid=B.id and A.name='953西红柿' ORDER BY A.price DESC")
    List<Map<String, Object>> show953();

    //列出所有农场的所有商品信息
    @Select("SELECT A.*,B.name Bname FROM sale A,saleframer B WHERE A.fid=B.id")
    List<Map<String, Object>> showAllSale();

    //统计所有“食品类型“的商品信息并按价格升序排列
    @Select("SELECT * FROM sale WHERE type='食品' ORDER BY price ASC")
    List<Map<String, Object>> showTypeOrder();

    //--------------------------------Util----------------------------------

    //SELECT表全部 1
    @Select("SELECT * FROM sale")
    List<Map<String, Object>> showAll();

    //SELECT表全部 2
    @Select("SELECT * FROM saleframer")
    List<Map<String, Object>> showAll2();

    //返回农场的个数
    @Select("SELECT COUNT(*) FROM saleframer")
    int fidTest();

    //返回商店水果的条数
    @Select("SELECT COUNT(*) FROM sale")
    int sidTest();

}
