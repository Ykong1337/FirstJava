package com.ftg.learn.doc.dao;

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

public class SaleframerDao {

    private final SqlSession session;
    private final SqlSessionFactory ssf;

    {
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        Configuration r = new Configuration();
        MysqlDataSource s = new MysqlDataSource();
        s.setUser("root");
        s.setPassword("ykong");
        s.setURL("jdbc:mysql://localhost:3306/db2");
        Environment e = new Environment("ykong", new JdbcTransactionFactory(), s);
        r.setEnvironment(e);

        ssf = ssfb.build(r);
        ssf.getConfiguration().addMapper(ISaleframer.class);
        session = ssf.openSession(true);
    }

    public SqlSession getSession() {
        if (session == null) {
            ssf.openSession();
        }
        return session;
    }

    ISaleframer is = this.getSession().getMapper(ISaleframer.class);


    //-----------------------Function--------------------------------

    //insertFrame
    public void insertFrame(String name, String address, String boss, FrameEnum type) {
        is.ins(name, address, boss, type);
    }

    //updateFrame
    public void updateFrame(Integer id, String name, String address, String boss, FrameEnum type) {
        is.upd(id, name, address, boss, type);
    }

    //deleteFrame
    public void deleteFrame(Integer id) {
        is.del(id);
        //删除后 商品表相应外键属性置空
        is.delFid(id);
    }

    //农场列表功能，按分页功能显示商品信息功能(商品名称，所在农场，商品地址、单价)，每页显示10条。可选，显示条目数可修改功能。
    public List<Map<String, Object>> selectLimit(int pageNum, int limit) {
        return new SaleDao().selectLimit(pageNum, limit);
    }

    //农场明细列表显示功能，完成当前编写农场的全部信息，并关联出当前农场的所有商品信息
    public List<Map<String, Object>> selectAB() {
        return is.showAll();
    }


    //-----------------------------------Test------------------------------------

    @Test
    public void test() {
        SaleframerDao s = new SaleframerDao();
        SaleDao d = new SaleDao();
        SelInfoDao i = new SelInfoDao();
//        i.showAll2().forEach(System.out::println);
//        s.selectLimit(1,5).forEach(System.out::println);
//        s.insertFrame("aaa","bbb","ccc",FrameEnum.国有);
//        d.insert("ccc", "adf", 3, UnitEnum.瓶, 90.0, TypeEnum.水果, "2020-05-21", "2020-3-1");
//        i.showAll().forEach(System.out::println);
//        s.deleteFrame(8);
//        i.showAll().forEach(System.out::println);
    }

}
