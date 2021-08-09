package com.ftg.learn.chapter18;

import org.junit.jupiter.api.Test;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LearnClass {

    public void field() throws ClassNotFoundException, IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class c = Class.forName("com.ftg.learn.chapter18.Cat");
        Object cat = c.newInstance();
        Field[] fs = c.getDeclaredFields();
        int sum = 0;
        for (Field f : fs) {
            animalNo aid = f.getAnnotation(animalNo.class);
            System.out.println(aid + "===>" + f.getName());

            if (f.getName().equals("name")) {
                PropertyDescriptor p = new PropertyDescriptor(f.getName(), c);
                Method method = p.getWriteMethod();
                method.invoke(cat, "狗");
                Method method1 = p.getReadMethod();
                Object str = method1.invoke(cat);
                System.out.println(str);
            }
            sum++;
        }
        System.out.println(sum);
    }

    public void test1(Cat cat) throws ClassNotFoundException {
        Class c1 = cat.getClass();
        Class c2 = Cat.class;
        Class c3 = Class.forName("com.ftg.learn.chapter18.Cat");
    }

    @Test
    public void test() throws ClassNotFoundException, InvocationTargetException, IntrospectionException, InstantiationException, IllegalAccessException {
        LearnClass l = new LearnClass();
        l.field();
        l.test1(new Cat());
    }
}
