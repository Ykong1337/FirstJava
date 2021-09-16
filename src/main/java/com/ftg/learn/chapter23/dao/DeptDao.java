package com.ftg.learn.chapter23.dao;

import com.ftg.learn.chapter23.entity.Dept;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class DeptDao {

    private final SqlSession session;
    private final SqlSessionFactory ssf;

    {
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        Configuration r = new Configuration();
        MysqlDataSource s = new MysqlDataSource();
        s.setUser("root");
        s.setPassword("ykong");
        s.setURL("jdbc:mysql://localhost:3306/db1");
        Environment e = new Environment("ykong", new JdbcTransactionFactory(), s);
        r.setEnvironment(e);

        ssf = ssfb.build(r);
        ssf.getConfiguration().addMapper(IDept.class);
        session = ssf.openSession(true);
    }

    public SqlSession getSession() {
        if (session == null) {
            ssf.openSession();
        }
        return session;
    }

    IDept id = this.getSession().getMapper(IDept.class);


//---------------------------------------------------------------------------------
    public List<Map<String, Object>> showaa() {
        return id.showAll();
    }

    public List<Map<String, Object>> showByDynamicParame2(Integer deptno) {
        return id.showByDyPara2(deptno);
    }

    //Provider
    public void insertpro(Integer deptno,String dname,String loc){
        id.insertpro(deptno,dname,loc);
    }


    //nomoral Insert
    public void insert(int deptno, String dname, String loc) {
        id.insert1(deptno, dname, loc);
    }

    public void delete(int deptno) {
        id.delete1(deptno);
    }





    //test---------------------------------------------------------------------

    //Provider
    @Test
    public void insTest1() {
        DeptDao deptDao = new DeptDao();
        deptDao.insertpro(90, "null", "null");
        deptDao.showaa().forEach(System.out::println);
    }

    @Test
    public void insTest() {
        DeptDao deptDao = new DeptDao();
        deptDao.insert(90, "aaa", "bbb");
        deptDao.showaa().forEach(System.out::println);
    }

    //delete where deptno = ?
    @Test
    public void delTest() {
        DeptDao deptDao = new DeptDao();
        deptDao.delete(90);
        deptDao.showaa().forEach(System.out::println);
    }

    @Test
    public void testShowAll() {
        DeptDao deptDao = new DeptDao();
        deptDao.showaa().forEach(System.out::println);

    }

    @Test
    public void testSQLShow() {
        DeptDao deptDao = new DeptDao();
        Dept d = new Dept();
        d.setDeptno(10);
        d.setDname("aaa");
        d.setLoc("bbb");
        deptDao.showByDynamicParame2(null).forEach(System.out::println);

    }

}