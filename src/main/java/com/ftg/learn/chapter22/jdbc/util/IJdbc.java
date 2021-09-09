package com.ftg.learn.chapter22.jdbc.util;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.function.Supplier;

public interface IJdbc<T> {
    /**
     * 添加方法
     * @param t1  表名，列名，值 ?
     * @return
     */
    int insert(T t1);

    int delete(T t1) throws ClassNotFoundException, IllegalAccessException, IntrospectionException, InvocationTargetException;

    int delete(Supplier<String> delSupplier, Object...obj);

    int update(T t1);

    int update(Supplier<String> updateWhere, Object...obj);

    /**
     * 查询T表当中的全部数据
     * @return
     */
    List<T> selectAll();

    /**
     * 可以完成排序等操作
     * 用处理静态sql
     * @param or
     * @return
     */
    List<T> selectAll(Supplier<String> or);


    /**
     * 用处理静态sql带条件的
     * @param o
     * @return
     */
    List<T> selectAll(Supplier<String> o,Object...obj);
}
