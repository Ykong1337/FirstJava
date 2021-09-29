package com.ftg.learn.chapter23.dao;

import com.ftg.learn.chapter23.entity.Dept;
import com.ftg.learn.chapter23.entity.Emp;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.*;
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

        r.setLocalCacheScope(LocalCacheScope.STATEMENT);

        //开启二级缓存 (开启二级缓存)
        r.setCacheEnabled(true);

        r.setLogImpl(Slf4jImpl.class);
//        r.setLogImpl(StdOutImpl.class);

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

    public List<Emp> test123(){
        return id.showDeptEmp();
    }


    @Test
    public void Tmain() {
        DeptDao deptDao = new DeptDao();
//        Dept d = new Dept();
//        d.setDeptno(10);
//        d.setDname("aaa");
//        d.setLoc("bb");
//        deptDao.showPage(1,10).forEach(System.out::println);

        //把概念 缓存机制 背下来  理解下来
        //自己用mybatis多写几套crud

        List<Emp> list = deptDao.test123();
        for (Emp e : list){
            System.out.println(e.getEname()+"\t"+e.getEno());
//            FetchType.LAZY : 懒加载:当用的时候再查数据，不用不查
            //关联查询时，lazy要手工开启,目标就是为了减少数据查询次数
            //json有问题 ： EAGER json没有办法二次生成(。。。)
//            FetchType.EAGER
//            System.out.println(e.getDept().getDeptno());
//            1：30 -3：00 （mybatis关联 注解 方式 完成 dept - >emp）
        }

    }

    public static void main(String[] args) {
        DeptDao deptDao = new DeptDao();
        List<Emp> list = deptDao.test123();
        for (Emp e : list) {
            System.out.println(e.getEname() + "\t" + e.getEno());
        }

    }
}