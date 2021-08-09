package com.ftg.learn.chapter19.q3;

import org.junit.jupiter.api.Test;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StudentManage {

    public static Student init(String name, String sex, int age) throws IntrospectionException, IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {

        Class c = Class.forName("com.ftg.learn.chapter19.q3.Student");
        Object stu = c.newInstance();
        Field[] fields = c.getDeclaredFields();

        for (Field field : fields) {

            if (field.getName().equals("name")) {
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), c);
                Method writeMethod = propertyDescriptor.getWriteMethod();
                writeMethod.invoke(stu, name);
                Method readMethod = propertyDescriptor.getReadMethod();
                Object str = readMethod.invoke(stu);
                System.out.println(str);
            } else if (field.getName().equals("sex")) {
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), c);
                Method writeMethod = propertyDescriptor.getWriteMethod();
                writeMethod.invoke(stu, sex);
                Method readMethod = propertyDescriptor.getReadMethod();
                Object str = readMethod.invoke(stu);
                System.out.println(str);
            } else if (field.getName().equals("age")) {
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), c);
                Method writeMethod = propertyDescriptor.getWriteMethod();
                writeMethod.invoke(stu, age);
                Method readMethod = propertyDescriptor.getReadMethod();
                Object str = readMethod.invoke(stu);
                System.out.println(str);
            }
        }
        return (Student) stu;
    }

    @Test
    public void test() throws ClassNotFoundException, InvocationTargetException, IntrospectionException, InstantiationException, IllegalAccessException {
        System.out.println(StudentManage.init("彭翰泽", "男", 21));

    }

}
