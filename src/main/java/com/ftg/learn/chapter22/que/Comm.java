package com.ftg.learn.chapter22.que;

import org.testng.annotations.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class Comm<T> {

    public void input(){
        ParameterizedType pz = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type type = pz.getActualTypeArguments()[0];
        System.out.println(type.getTypeName());
    }

    @Test
    public void test(){
        DzProductDao d = new DzProductDao();
        d.input();
    }
}
