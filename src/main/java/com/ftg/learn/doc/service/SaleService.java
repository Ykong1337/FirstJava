package com.ftg.learn.doc.service;

import com.ftg.learn.doc.mapper.ISale;
import com.ftg.learn.doc.entity.TypeEnum;
import com.ftg.learn.doc.entity.UnitEnum;
import com.ftg.learn.doc.util.AbsService;
import com.ftg.learn.doc.util.OtherEx;
import com.ftg.learn.doc.vo.SaleListVo;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class SaleService extends AbsService {

    ISale i = super.getSession().getMapper(ISale.class);

    public OtherEx insertSale(Integer id,String name, String address, Integer fid, UnitEnum unit, Double price, TypeEnum type, String scdate, String ccdate){
        OtherEx o = new OtherEx();

        if(i.ones(id) != null){
            o.setCode(201);
            o.setMsg("当前数据已存在!!!");
            o.setEffect(0);
        }else{
            int num = i.ins(name,address,fid,unit,price,type,scdate,ccdate);
            o.setCode(200);
            o.setMsg("成功!!!");
            o.setEffect(num);
        }
        return o;
    }

    public OtherEx updateSale(Integer id, String name, String address, Integer fid, UnitEnum unit, Double price, TypeEnum type, String scdate, String ccdate){
        OtherEx o = new OtherEx();

        if(i.ones(id) == null){
            o.setCode(201);
            o.setMsg("当前数据不存在!!!");
            o.setEffect(0);
        }else{
            int num = i.upd(id,name,address,fid,unit,price,type,scdate,ccdate);
            o.setCode(200);
            o.setMsg("成功!!!");
            o.setEffect(num);
        }
        return o;
    }

    public OtherEx deleteSale(Integer id){
        OtherEx o = new OtherEx();

        if(i.ones(id) == null){
            o.setCode(201);
            o.setMsg("当前数据不存在!!!");
            o.setEffect(0);
        }else{
            int num = i.del(id);
            o.setCode(200);
            o.setMsg("成功!!!");
            o.setEffect(num);
        }
        return o;
    }

    public List<Map<String, Object>> detail(){
        return i.show();
    }

    public List<SaleListVo> selectLimit(int pageNum, int limit) {

        SelectService s = new SelectService();
        int maxPage = s.sidTest() / limit;
        if (pageNum > maxPage) {
            if (s.sidTest() % limit != 0) {
                pageNum = maxPage + 1;
            } else {
                pageNum = maxPage;
            }
        }
        int offset = (pageNum > 0 ? pageNum - 1 : 1);
        return i.showLimit(offset * 10, limit);
    }

    @Test
    public void t(){
        SaleService s = new SaleService();
        s.selectLimit(1, 10).forEach(System.out::println);
    }

}
