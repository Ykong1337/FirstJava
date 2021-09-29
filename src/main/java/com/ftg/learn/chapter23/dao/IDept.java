package com.ftg.learn.chapter23.dao;

import com.ftg.learn.chapter23.entity.Dept;
import com.ftg.learn.chapter23.entity.Dept1;
import com.ftg.learn.chapter23.entity.Emp;
import com.ftg.learn.chapter23.vo.DeptDetail;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

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


    @Select("select * from dept left join emp on dept.deptno = emp.deptno")
    List<DeptDetail> showLeftJoin();

    /**
     * {
     *     code:200
     *     msg:成功
     *     data:showPage()
     *     count:math.ceil(list.size()/10)
     *     total:list.size()
     * }
     * @param offset
     * @param limit
     * @return
     */
    @Select("select * from dept left join emp on dept.deptno = emp.deptno order by emp.eno limit #{arg0},#{arg1}")
    List<DeptDetail> showPage(int offset, int limit);

    /**
     * 可以根据 部门编号 查询 当前部门的信息
     * @param deptno
     * @return
     */
    @Select("select * from dept where deptno = #{deptno}")
    Dept1 showByParameOne(int deptno);

    /**
     * 这是一个方法，这个方法用来查询 emp里面的全部人员信息
     * select eno,ename,job,deptno from emp ： 全部信息  deptno - dept:deptno ==
     *  注解
     *  @ results()定义 当前这个方法返回 值类型
     *
     * @return List<Emp></Emp>  emp - > 人员信息 Dept dept信息
     */
    @Select("select eno,ename,job,deptno from emp")
    //多个人在一个部门  多对一  一对多
    //Emp - emp -deptno - >一个部门
    //deptno 必须是emp表里面真实存在的列 one = @one() 多对一的 @one(我想执行一个查询  "select * from dept where deptno = #{deptno}")
    //@one(-对应的是一个deptMapper-里面的方法)
    //spring
    @Results(
            @Result(property = "dept",column = "deptno",
                    one = @One(fetchType = FetchType.EAGER,select = "com.ftg.learn.chapter23.dao.IDept.showByParameOne"))
    )
    List<Emp> showDeptEmp();

}
