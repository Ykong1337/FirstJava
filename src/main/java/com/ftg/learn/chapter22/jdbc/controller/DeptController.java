package com.ftg.learn.chapter22.jdbc.controller;

import com.ftg.learn.chapter22.jdbc.beans.Dept;
import com.ftg.learn.chapter22.jdbc.dao.DeptDao;
import com.ftg.learn.chapter22.jdbc.util.controller.AbsBaseController;
import org.testng.annotations.Test;

public class DeptController extends AbsBaseController<Dept> {
    DeptDao deptDao = new DeptDao();

    public String queryAll(){
        return super.OK(deptDao.selectAll());
    }

    public String queryAll1(String dname){
        return super.OK(deptDao.selectAll(()-> "where dname like ?",dname));
    }


    @Test
    public void test(){
        DeptController d = new DeptController();
        System.out.println(d.queryAll());
    }
}
