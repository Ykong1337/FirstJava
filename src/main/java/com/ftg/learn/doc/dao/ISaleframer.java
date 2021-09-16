package com.ftg.learn.doc.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;
import java.util.Map;

public interface ISaleframer {

    //添加功能，完成农场后台添加功能
    @Insert("INSERT INTO saleframer values(0,#{arg0},#{arg1},#{arg2},#{arg3},1)")
    void ins(String name, String address, String boss, FrameEnum type);

    //修改功能，可以对农场信息进行修改。
    //Provider update
    @UpdateProvider(type = ISaleframerProvider.class, method = "updatePro")
    void upd(Integer id, String name, String address, String boss, FrameEnum type);

    //添加删除功能，完成农场删除功能，可考虑使用假删。
    @Update("UPDATE saleframer SET flag=0 WHERE id=#{id}")
    void del(Integer id);

    //农场列表功能，按分页功能显示商品信息功能(商品名称，所在农场，商品地址、单价)，每页显示10条。可选，显示条目数可修改功能。
    @Select("SELECT A.name saleName,B.name saleframerName,B.address,A.price FROM sale A,saleframer B WHERE A.fid=B.id and A.flag=1 and B.flag=1 ORDER BY A.id LIMIT #{arg0},#{arg1}")
    List<Map<String, Object>> showLimit(Integer offset, Integer limit);

    //农场明细列表显示功能，完成当前编写农场的全部信息，并关联出当前农场的所有商品信息
    @Select("SELECT B.id Bid,B.name Bname,B.address Baddress,B.boss,B.type,A.id Aid,A.name Aname,A.address Aaddress,A.fid,A.unit,A.price,A.type,A.scdate,A.ccdate FROM sale A LEFT JOIN saleframer B ON A.fid=B.id and A.flag = 1 and B.flag=1")
    List<Map<String, Object>> showAll();

    //---------------------------------------Util-----------------------------------------

    //删除农场时 将id为fid的商品fid置空
    @Update("UPDATE sale SET fid=0 WHERE fid=#{id}")
    void delFid(Integer id);
}
