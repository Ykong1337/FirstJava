package com.ftg.learn.doc.service;

import com.ftg.learn.doc.entity.FrameEnum;
import com.ftg.learn.doc.mapper.ISaleframer;
import com.ftg.learn.doc.util.AbsService;
import com.ftg.learn.doc.util.OtherEx;
import com.ftg.learn.doc.vo.SaleListVo;

import java.util.List;
import java.util.Map;

public class FramerService extends AbsService {

    ISaleframer i = super.getSession().getMapper(ISaleframer.class);

    public OtherEx insertFramer(Integer id,String name, String address, String boss, FrameEnum type){
        OtherEx o = new OtherEx();

        if(i.ones(id) != null){
            o.setCode(201);
            o.setMsg("当前数据已存在!!!");
            o.setEffect(0);
        }else{
            int num = i.ins(name,address,boss,type);
            o.setCode(200);
            o.setMsg("成功!!!");
            o.setEffect(num);
        }
        return o;
    }

    public OtherEx updateFramer(Integer id, String name, String address, String boss, FrameEnum type){
        OtherEx o = new OtherEx();

        if(i.ones(id) == null){
            o.setCode(201);
            o.setMsg("当前数据不存在!!!");
            o.setEffect(0);
        }else{
            int num = i.upd(id,name,address,boss,type);
            o.setCode(200);
            o.setMsg("成功!!!");
            o.setEffect(num);
        }
        return o;
    }

    public OtherEx deleteFramer(Integer id){
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
        return i.showAll();
    }

    public List<SaleListVo> selectLimit(int pageNum, int limit) {
        return new SaleService().selectLimit(pageNum, limit);
    }

}
