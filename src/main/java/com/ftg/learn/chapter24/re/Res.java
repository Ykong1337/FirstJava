package com.ftg.learn.chapter24.re;

import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Res {

    public int add(int x, int y) {
        try {
            Class c = Option.class;
            Method method = c.getMethod("add", int.class, int.class);
            return (int) method.invoke(c.newInstance(), 4, 5);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public String add(int x, String y) {
        try {
            Class c = Option.class;
            Method method = c.getMethod("add3", int.class, String.class);
            return (String) method.invoke(c.newInstance(), 4, "ykong");
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Test
    public void test() {
        Res r = new Res();
        System.out.println(r.add(4, 5));
        System.out.println(r.add(4,"ykong"));
    }
}
