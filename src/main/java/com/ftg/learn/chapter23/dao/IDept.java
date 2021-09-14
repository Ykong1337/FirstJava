package com.ftg.learn.chapter23.dao;

import com.ftg.learn.chapter23.entity.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface IDept {

    //SELECT ALL
    @Select("SELECT * FROM dept")
    List<Map<String, Object>> showAll();

    @Select("SELECT * FROM dept where deptno = #{deptno}")
    List<Map<String, Object>> showAll1(int deptno);

    @Select("SELECT * FROM dept WHERE deptno = #{arg0} and dname = #{arg1} and loc = #{arg2}")
    List<Map<String, Object>> showPara2(int deptno, String dname, String loc);

    @Select("SELECT * FROM dept WHERE deptno = #{deptno} and dname = #{dname} and loc = #{loc}")
    List<Map<String, Object>> showPara3(Dept dept);

    @Select("SELECT * FROM dept WHERE deptno = #{arg0.deptno} and dname = #{arg0.dname} or dname = #{arg1} and loc = #{arg0.loc}")
    List<Map<String, Object>> showPara4(Dept dept, String dname);

    @Select("<script>"
            + "select * from dept "
            +    "<where>"
            +    "  <if test=\"deptno != null\">"
            +    "      deptno = #{deptno}"
            +    "  </if>"
            +    "</where>"
            +"</script>")
    List<Map<String,Object>> showByDyPara1(Integer deptno);

    @SelectProvider(type = IdeptProvider.class,method = "showByDyPara2")
    List<Map<String,Object>> showByDyPara2(Integer deptno);

    //Provider insert
    @SelectProvider(type = IdeptProvider.class,method = "insertPro")
    void insertpro(Integer deptno,String dname,String loc);


    //INSERT
    @Insert("INSERT INTO dept(deptno,dname,loc) values(#{arg0},#{arg1},#{arg2})")
    void insert1(int deptno,String dname,String loc);

    //DELETE
    @Delete("DELETE FROM dept where deptno = #{arg0}")
    void delete1(int deptno);
}
