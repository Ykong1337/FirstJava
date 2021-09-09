package com.ftg.learn.chapter22.jdbc.util;

import com.ftg.learn.chapter22.C3P0Util;
import com.ftg.learn.chapter22.jdbc.beans.Dept;
import org.testng.annotations.Test;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public abstract class AbsBaseJdbc<T> implements IJdbc<T> {

    private final String url = "jdbc:mysql://localhost:3306/db1";
    private final String username = "root";
    private final String password = "ykong";

    @Override
    public int insert(T t1) {
        String sql = this.createInsertSql();
        Object[] obj = new Object[0];
        try {
            obj = this.createParameter(t1);
        } catch (IllegalAccessException | IntrospectionException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return this.doDML(sql, obj);
    }

    @Override
    public List<T> selectAll() {
        try {
            String tabName = this.getTableName();
            String sql = "select * from " + tabName;
            return this.query(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<T> selectAll(Supplier<String> or) {
        try {
            String tabName = this.getTableName();
            String sql = "select * from " + tabName + " " + or.get();
            return this.query(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<T> selectAll(Supplier<String> o, Object... obj) {
        try {
            String tabName = this.getTableName();
            List<String> colsname = this.getColsName();
            String str = "";
            for (int i = 0, len = colsname.size(); i < len; i++) {
                str += colsname.get(i) + ",";
            }
            String sql = "select " + str.substring(0, str.length() - 1) + " from " + tabName + " " + o.get();
            return this.query(sql, obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    private String createInsertSql() {
        StringBuilder sb = new StringBuilder("insert into ");
        StringBuilder why = new StringBuilder();
        try {
            List<String> lis = this.getColsName();
            sb.append(this.getTableName()).append(" (");
            for (int i = 0, len = lis.size(); i < len; i++) {
                sb.append(lis.get(i)).append(i == len - 1 ? "" : ",");
                why.append("?").append(i == len - 1 ? "" : ",");
            }
            sb.append(") values (").append(why.toString()).append(")");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 为添加方法创建参数的
     *
     * @param t1 dept一个实例  D
     * @return
     * @throws ClassNotFoundException
     * @throws IntrospectionException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private Object[] createParameter(T t1) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        Class c = t1.getClass();
        Field[] fs = c.getDeclaredFields();
        Object[] obj = new Object[fs.length];
        int index = 0;
        for (Field f : fs) {
            PropertyDescriptor pd = new PropertyDescriptor(f.getName(), c);
            Method method = pd.getReadMethod();
            obj[index++] = method.invoke(t1);
        }
        return obj;
    }

    /**
     * 取到当前类的泛型 ，做为表名来使用
     *
     * @return 表名
     */
    private String getTableName() throws ClassNotFoundException {
        return getParameterTypeClass().getSimpleName();
    }

    /**
     * 泛型的反射
     *
     * @return
     * @throws ClassNotFoundException
     */
    private Class getParameterTypeClass() throws ClassNotFoundException {
        ParameterizedType t2 = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] type = t2.getActualTypeArguments();
        String classPath = type[0].getTypeName();
        return Class.forName(classPath);
    }

    /**
     * 获取泛型当中的全部列
     *
     * @return
     * @throws ClassNotFoundException
     */
    private List<String> getColsName() throws ClassNotFoundException {
        ParameterizedType t2 = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] type = t2.getActualTypeArguments();
        String classPath = type[0].getTypeName();
        Class c = Class.forName(classPath);
        Field[] fs = c.getDeclaredFields();
        List<String> cols = new ArrayList<>(fs.length);
        for (Field f : fs) {
            cols.add(f.getName());
        }
        return cols;
    }

    /**
     * 完成数据库里面的所有dml操作
     *
     * @param sql 语句
     * @param obj 值
     * @return 正整数 | -1 （没有影响）
     */
    public int doDML(String sql, Object... obj) {
        System.out.println(sql);
        try (
                Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            if (obj != null) {
                for (int i = 0, len = obj.length; i < len; i++) {
                    ps.setObject(i + 1, obj[i]);
                }
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 真证完成对数据操作的方法
     *
     * @param sql 执行语句
     * @param obj 参数
     * @return List<T>
     */
    private List<T> query(String sql, Object... obj) {
        System.out.println(sql);
        List<T> list = new ArrayList<>();
        try (
                Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            if (obj != null) {
                for (int i = 0, len = obj.length; i < len; i++) {
                    ps.setObject(i + 1, obj[i]);
                }
            }
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                Object o = this.getParameterTypeClass().newInstance();
                for (int i = 0, len = rsmd.getColumnCount(); i < len; i++) {
                    String colIName = rsmd.getColumnName(i + 1);
                    //colIname这个属性对应的【getter/setter】
                    PropertyDescriptor pd = new PropertyDescriptor(colIName, o.getClass());
                    //setter
                    Method setter = pd.getWriteMethod();
                    //取到this.obj.getClass() - colIName字段的类型
                    String tname = rsmd.getColumnTypeName(i + 1);
                    //newInstance 相当于new
                    switch (tname) {
                        case "TINYINT":
                        case "SMALLINT":
                        case "MEDIUMINT":
                            setter.invoke(o, rs.getInt(i + 1));
                            break;
                        case "FLOAT":
                            setter.invoke(o, rs.getFloat(i + 1));
                            break;
                        case "DOUBLE":
                            setter.invoke(o, rs.getDouble(i + 1));
                            break;
                        case "BIT":
                        case "BOOLEAN":
                            setter.invoke(o, rs.getBoolean(i + 1));
                            break;
                        case "INT":
                        case "BIGINT":
                            setter.invoke(o, rs.getLong(i + 1));
                            break;
                        default:
                            setter.invoke(o, rs.getObject(i + 1));
                    }

                }
                //emp emp emp
                list.add((T) o);
            }

        } catch (SQLException | IntrospectionException | IllegalAccessException | InvocationTargetException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int delete(T t1) throws ClassNotFoundException, IllegalAccessException, IntrospectionException, InvocationTargetException {
        String tabName = this.getTableName();
        String where = this.getWhere();
        String sql = "delete from " + tabName + " " + where;
        return this.doDML(sql,this.updateParameter(t1)[this.updateParameter(t1).length - 1]);
    }


    @Override
    public int delete(Supplier<String> delSupplier, Object... obj) {

        try {
            String where = this.getWhere();
            if (this.selectAll(() -> where).isEmpty()) {
                return -1;
            }
            String tabName = this.getTableName();
            String sql = "delete from " + tabName + " " + delSupplier.get();
            return doDML(sql, obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return -1;
    }

    @Override
    public int update(T t1) {
        try {
            String tabName = this.getTableName();
            String where = this.getWhere();
            String set = this.getSet();
            String sql = "update " + tabName + set + where;
            if (this.selectAll(() -> where).isEmpty()) {
                return -1;
            } else {
                Object[] obj = this.updateParameter(t1);
                return this.doDML(sql, obj);
            }
        } catch (ClassNotFoundException | IntrospectionException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private Object[] updateParameter(T t1) throws IntrospectionException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        Field[] fs = this.getFields();
        Object[] obj = new Object[fs.length];
        int index = 0;
        for (Field f : fs) {
            PropertyDescriptor pd = new PropertyDescriptor(f.getName(), t1.getClass());
            obj[f.isAnnotationPresent(Key.class) ? obj.length - 1 : index++] = pd.getReadMethod().invoke(t1);
        }
        return obj;
    }

    private String getSet() throws ClassNotFoundException {
        String key = " set ";
        Field[] fs = this.getFields();
        for (Field f : fs) {
            if (!f.isAnnotationPresent(Key.class)) {
                key += f.getName() + "= ?,";
            }
        }
        return key.substring(0, key.length() - 1);
    }

    private String getWhere() throws ClassNotFoundException {
        String key = "";
        Field[] fs = this.getFields();
        for (Field f : fs) {
            if (f.isAnnotationPresent(Key.class)) {
                key = f.getName();
                break;
            }
        }
        return "where" + key + " = ?";
    }

    private Field[] getFields() throws ClassNotFoundException {
        Class c = this.getParameterTypeClass();
        Field[] fs = c.getDeclaredFields();
        return fs;
    }

    @Override
    public int update(Supplier<String> updateWhere, Object... obj) {

        try {
            String tabName = this.getTableName();
            String set = this.getSet();
            String sql = "update " + tabName + set + " " + updateWhere.get();
            return doDML(sql, obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return -1;
    }


    @Test
    public void get(){

        try {
            Class c = Class.forName("com.ftg.learn.chapter22.jdbc.beans.Commodity");
            Object o = c.newInstance();
            Field[] fs = c.getDeclaredFields();
            for (Field f : fs){
                System.out.println(f.getName());
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }



}
