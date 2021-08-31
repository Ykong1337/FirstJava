package com.ftg.learn.chapter22.jdbc;

import org.testng.annotations.Test;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;

public class FirstJDBC {

    private final String username = "root";

    private final String password = "ykong";

    private final String ip = "127.0.0.1";

    private final int port = 3306;

    private final String database = "db1";

    private final String url = "jdbc:mysql://" + ip + ":" + port + "/" + database;


    public Connection myConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    //-----------------------------------------------

    public List<Emp> queryForPojo(String sql, Object... obj) {
        List<Emp> list = new ArrayList<>();
        try (
                Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            //循环所有rs 把里面的行与列生成list<map>
            if (obj != null) {
                for (int i = 0, len = obj.length; i < len; i++) {
                    stmt.setObject(i + 1, obj[i]);
                }
            }
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ResultSetMetaData rsmd = rs.getMetaData();
                    Emp e = new Emp();
                    for (int i = 0, len = rsmd.getColumnCount(); i < len; i++) {

                        String columnName = rsmd.getColumnName(i + 1).toLowerCase();
                        //PropertyDescriptor找到相应的属性对应的setter / getter
                        PropertyDescriptor pd = new PropertyDescriptor(columnName, e.getClass());
                        Method setmethod = pd.getWriteMethod();

                        setmethod.invoke(e, rs.getObject(i + 1));

                    }
                    list.add(e);
                }
            } catch (SQLException | IntrospectionException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    //--------------------------------------------------------------------------------

    public List<Map<String, Object>> querylist(String sql, Object... obj) {

        List<Map<String, Object>> list = new ArrayList<>();
        try (
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            if (obj != null) {
                for (int i = 0, len = obj.length; i < len; i++) {
                    ps.setObject(i + 1, obj[i]);
                }
            }
            try (
                    ResultSet rs = ps.executeQuery()
            ) {
                while (rs.next()) {
                    ResultSetMetaData rsmd = rs.getMetaData();
                    Map<String, Object> map = new HashMap<>();
                    for (int i = 0, len = rsmd.getColumnCount(); i < len; i++) {
                        map.put(rsmd.getColumnName(i + 1).toLowerCase(), rs.getObject(i + 1));
                    }
                    list.add(map);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    @Test
    public void test() throws SQLException {
        FirstJDBC j = new FirstJDBC();
        List<Emp> l = j.queryForPojo("select eno,ename,job,mgr,date_format(hirdate,'%Y-%m-%d') hirdate,sal,comm,deptno from emp");

        l.forEach(x -> System.out.println(x));

    }

}
