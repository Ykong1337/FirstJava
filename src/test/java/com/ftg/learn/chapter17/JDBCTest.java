package com.ftg.learn.chapter17;

import com.ftg.learn.chapter22.jdbc.beans.Dept;
import com.ftg.learn.chapter22.jdbc.dao.DeptDao;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class JDBCTest {

    DeptDao deptDao;

    @Before
    public void init(){
        deptDao = new DeptDao();
    }

    @Test
    public void test1(){
        Dept dept = new Dept(23,"中国","北京");
        int num = deptDao.insert(dept);
        Assert.assertEquals(num , 1);
    }


    @Test
    public void test2() throws ClassNotFoundException, InvocationTargetException, IntrospectionException, IllegalAccessException {
        List<Dept> list = deptDao.selectAll();
        list.forEach(System.out::println);

        Dept dept = new Dept();
        int num = deptDao.delete(dept);
        Assert.assertEquals(num , 1);
        System.out.println("---------------------------------");
        List<Dept> list1 = deptDao.selectAll();
        list1.forEach(System.out::println);
    }

    @Test
    public void test3(){
        System.out.println("where测试");
        List<Dept> list = deptDao.selectAll(()->"where deptno > 23");
        list.forEach(System.out::println);

        System.out.println("orderby 测试");
        List<Dept> list1 = deptDao.selectAll(()->"order by deptno");
        list1.forEach(System.out::println);
    }


    @Test
    public void test4(){
        List<Dept> list1 = deptDao.selectAll(()->"where dname like concat(?,'%')","S");
        list1.forEach(System.out::println);
    }

}
