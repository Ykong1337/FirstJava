package com.ftg.learn.chapter15.Abs;

import org.junit.jupiter.api.Test;

/**
 * 父类 -》 开放的属性和方法 - 》子类
 * <p>
 * java第一个特殊的类，抽象类(abstract 抽象)
 * 父类
 * 属性
 * 方法
 * 方法（）没有代码 s
 * <p>
 * -- 3000亿
 * -- 要求
 * 面向父类编程 接收子类实例 ，一份代码可以产生不能结果 （多态【父与子】）
 * 1、不能实例化 new 对象s(); 抽象类一般用做父类
 * 2、抽象方法 public | protected修饰
 * *
 */
public abstract class A {

    public abstract void Abs();

    public A(int i) {
        System.out.println(i);
    }

    public void ACc() {

    }


}
