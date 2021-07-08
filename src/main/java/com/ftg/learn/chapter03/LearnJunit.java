package com.ftg.learn.chapter03;

import java.lang.reflect.Array;

/**
 *六大原则一个法则：
 * 方法功能单一原则 --> 提高重用性
 *
 *
 *
 *
 *
 *
 * @author YKONG
 */
public class LearnJunit {
    /**
     * 计算x和y的和的方法
     * @param x 参数1
     * @param y 参数2
     * @return int
     *
     */
    public static int add(int x, int y){
        return x + y;
    }

    /**
     * 方法重载：使用者不用记太多方法名
     * @param x 参数1
     * @param y 参数2
     * @param z 参数3
     * @return
     */
    public static int add(int x, int y, int z){
        return add(x,add(y,z));
//        int sum = add(x,y);
//        int sum1 = add(sum,z);
//        return sum1;
    }

    public static int add(int x,int y,int z, int t){
        return x + y + z + t;
    }

    public static int divide(int x,int y){
        return x / y;
    }
    int arr[];
}
