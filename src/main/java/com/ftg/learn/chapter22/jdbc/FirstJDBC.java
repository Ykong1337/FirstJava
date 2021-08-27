package com.ftg.learn.chapter22.jdbc;

import org.testng.annotations.Test;

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

    public ResultSet query() {

        Connection con = this.myConnection();

        Statement stmt = null;

        ResultSet rs = null;

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from emp");

            while (rs.next()) {
                System.out.println(rs.getObject(1));
                System.out.println(rs.getObject(2));
                System.out.println(rs.getObject(3));
                System.out.println("--------------");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return rs;
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
        j.querylist("select * from emp where sal < ?","3000").forEach(System.out::println);

    }


}
