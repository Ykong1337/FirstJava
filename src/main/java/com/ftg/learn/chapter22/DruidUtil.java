package com.ftg.learn.chapter22;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class DruidUtil {

    /**
     * 初始化一个当前类使用的数据源
     */
    private DataSource dataSource;

    {
        Properties properties = new Properties();
        InputStream is = DruidUtil.class.getResourceAsStream("/druid.properties");
        try {
            properties.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得数据源
     *
     * @return DataSource
     */
    public DataSource getDataSource() {
        return this.dataSource;
    }

    /**
     * 获得数据库连接
     *
     * @return Connection
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        return this.getDataSource().getConnection();
    }

    /**
     * 使用druid连接池完成数据源获取
     *
     * @param sql 语句
     * @param obj 参数
     * @return List
     */
    public List<Map<String, Object>> query(String sql, Object... obj) {
        List<Map<String, Object>> list = new ArrayList<>();
        try (
                //使用连接池以后，close不是把连接关闭，而是把连接还给池
                Connection conn = this.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            if (obj != null) {
                for (int i = 0, len = obj.length; i < len; i++) {
                    ps.setObject(i + 1, obj[i]);
                }
            }
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                for (int i = 0, len = rsmd.getColumnCount(); i < len; i++) {
                    map.put(rsmd.getColumnName(i + 1).toUpperCase(), rs.getObject(i + 1));
                }
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Test
    public void test(){
        DruidUtil du = new DruidUtil();
        du.query("select * from dept").forEach(System.out::println);
    }

}
