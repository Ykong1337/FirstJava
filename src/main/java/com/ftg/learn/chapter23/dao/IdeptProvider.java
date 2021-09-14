package com.ftg.learn.chapter23.dao;

import com.ftg.learn.chapter23.entity.Dept;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class IdeptProvider {
    public String showByDyPara2(Integer deptno){
        SQL sql = new SQL()
                .SELECT("deptno,dname,loc")
                .FROM("dept");
        if(deptno != null){
            sql.WHERE("deptno = #{deptno}");
        }
        return sql.toString();
    }

    //---------------------------------------------------------------------

    public String insertPro(Integer deptno,String dname,String loc){

        SQL sql = new SQL().INSERT_INTO("dept");

        if(deptno != null){
            sql.VALUES("deptno","#{arg0}");
        }
        if(dname != null){
            sql.VALUES("dname","#{arg1}");
        }
        if(loc != null){
            sql.VALUES("loc","#{arg2}");
        }

        return sql.toString();
    }
}
