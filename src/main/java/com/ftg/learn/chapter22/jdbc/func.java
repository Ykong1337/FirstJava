package com.ftg.learn.chapter22.jdbc;

import java.util.List;
import java.util.function.Supplier;

public interface func<T> {

    StringBuilder insert(T t1);

    StringBuilder delete(T t1);

    StringBuilder update(T t1);

    List<T> queryAll(T t);

    List<T> queryAllForWhere(T t1, Supplier<String> where,Object...obj);

}
