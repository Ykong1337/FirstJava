package com.ftg.learn.chapter24.Dynamic;

import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class PersonProxy implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Select select = method.getAnnotation(Select.class);
        if (select != null){
            String sql = select.value()[0];
            Type type = method.getGenericReturnType();
            System.out.println(type.getTypeName());
        }

        return null;
    }
}
