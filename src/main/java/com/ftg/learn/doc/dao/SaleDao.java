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


public class SaleDao {

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
        ssf.getConfiguration().addMapper(ISale.class);
        session = ssf.openSession(true);
    }

    public SqlSession getSession() {
        if (session == null) {
            ssf.openSession();
        }
        return session;
    }

    ISale is = this.getSession().getMapper(ISale.class);

    //------------------------------------Function---------------------------------

    //INSERT
    public void insert(String name, String address, Integer fid, UnitEnum unit, Double price, TypeEnum type, String scdate, String ccdate) {
        if (is.testFlag(fid) == 1) {
            is.ins(name, address, fid, unit, price, type, scdate, ccdate);
        } else {
            throw new RuntimeException();
        }

    }

    //update  如果传null则不做修改
    //Integer id, String name, String address, Integer fid, String unit, Double price, String type, String scdate, String ccdate
    public void update(Integer id, String name, String address, Integer fid, UnitEnum unit, Double price, TypeEnum type, String scdate, String ccdate) {
        is.upd(id, name, address, fid, unit, price, type, scdate, ccdate);
    }

    //Delete
    public void delete(Integer id) {
        is.del(id);
    }

    //Select From A and B
    public List<Map<String, Object>> selectAB() {
        return is.show();
    }

    //商品列表功能，按分页功能显示商品信息功能(商品名称，所在农场，商品地址、单价)，每页显示10条。可选，显示条目数可修改功能。
    public List<Map<String, Object>> selectLimit(int pageNum, int limit) {

        SelInfoDao s = new SelInfoDao();
        int maxPage = s.sidTest() / limit;
        if (pageNum > maxPage) {
            if (s.sidTest() % limit != 0) {
                pageNum = maxPage + 1;
            } else {
                pageNum = maxPage;
            }
        }
        int offset = (pageNum > 0 ? pageNum - 1 : 1);
        return is.showLimit(offset * 10, limit);
    }

    //---------------------------------Test------------------------------------------

    @Test
    public void test() {
        SaleDao s = new SaleDao();
        SelInfoDao d = new SelInfoDao();
//        s.update(20,null,null,2,null,10.0,null,null,null);
//        s.selectAB().forEach(System.out::println);
//        s.selectLimit(4, 10).forEach(System.out::println);
//        d.showAll().forEach(System.out::println);
    }
}
