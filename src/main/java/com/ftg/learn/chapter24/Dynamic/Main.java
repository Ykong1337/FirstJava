package com.ftg.learn.chapter24.Dynamic;

import org.testng.annotations.Test;

import java.lang.reflect.Proxy;

public class Main<E> {

    @Test
    public void test(){
        Student student = (Student) Proxy.newProxyInstance(Student.class.getClassLoader(),new Class[]{Student.class},new PersonProxy());
        student.say();
        Person person = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(),new Class[]{Person.class},new PersonProxy());
        person.say();

        int arr[] = new int[10];
        System.out.println(arr[1]);
        int x = 182;
        int a,c;
        c=x/100;
        a=x%10;
        System.out.println(a);
        System.out.println(c);
    }

    @Test
    public static void test1(){


    }
}
