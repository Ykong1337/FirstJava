package com.ftg.learn.doc.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;
import java.util.Map;

public interface ISale {

    //添加功能，完成商品后台添加功能
    @Insert("INSERT INTO sale values(0,#{arg0},#{arg1},#{arg2},#{arg3},#{arg4},#{arg5},#{arg6},#{arg7},1)")
    void ins(String name, String address, Integer fid, UnitEnum unit, Double price, TypeEnum type, String scdate, String ccdate);

    //商品修改功能，可以对商品信息进行修改，商品主键不可以修改，如果有条码，条码可以修改。
    //Provider update
    @UpdateProvider(type = ISaleProvider.class, method = "updatePro")
    void upd(Integer id, String name, String address, Integer fid, UnitEnum unit, Double price, TypeEnum type, String scdate, String ccdate);

    //添加删除功能，完成商品表的商品删除功能，可考试使用假删。
    @Update("UPDATE sale SET flag=0 WHERE id=#{id}")
    void del(Integer id);

    //商品明细列表显示功能，完成单条商品的全部信息显示功能。关联列出农场信息
    @Select("SELECT A.id Aid,A.name Aname,A.address Aaddress,A.fid,A.unit,A.price,A.type,A.scdate,A.ccdate,B.id Bid,B.name Bname,B.address Baddress,B.boss,B.type FROM sale A LEFT JOIN saleframer B ON A.fid=B.id and A.flag = 1 and B.flag=1")
    List<Map<String, Object>> show();

    //商品列表功能，按分页功能显示商品信息功能(商品名称，所在农场，商品地址、单价)，每页显示10条。可选，显示条目数可修改功能。
    @Select("SELECT A.name saleName,B.name saleframerName,B.address,A.price FROM sale A,saleframer B WHERE A.fid=B.id and A.flag=1 and B.flag=1 ORDER BY A.id LIMIT #{arg0},#{arg1}")
    List<Map<String, Object>> showLimit(Integer offset, Integer limit);

    //----------------------------Util----------------------------------------------

    //检测Flag为0的framer
    @Select("SELECT flag FROM saleframer WHERE id=#{id}")
    int testFlag(Integer id);

}
