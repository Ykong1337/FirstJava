package com.ftg.learn.chapter22.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JDBC {
    private String usr;
    private String psw;
    private String url;

    public List<Map<String, Object>> queryForList(String sql, Object... o) {

        List<Map<String, Object>> list = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection(url, usr, psw);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            if (o != null) {
                for (int i = 0, len = o.length; i < len; i++) {
                    ps.setObject(i + 1, o[i]);
                }
            }

            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                for (int i = 1, len = rsmd.getColumnCount(); i <= len; i++) {
                    map.put(rsmd.getColumnName(i), rs.getObject(i));
                }
                list.add(map);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        JDBC j = new JDBC("root", "ykong", "jdbc:mysql://127.0.0.1:3306/db1");
        List l = j.queryForList("select e.ename,e.job,e.hirdate,d.dname\n" +
                "from emp e left join dept d on e.deptno = d.deptno\n" +
                "where e.ename like '%S%' and e.sal > 200");
        l.forEach(System.out::println);
    }
}
