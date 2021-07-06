
/**
第一层： com（商业）gov（教育）edu（教育）org（组织或机构）
第二层：公司名称
第三层：项目名称
必须在第一行
 */
package com.ftg.learn.chapter01;

/**
 * 这是第一个java类；用来学习java基本语义
 * 类功能说明
 * @author yhmen
 * @date 2021/07/05
 */

public class FirstJava {

    /**
     * parameter：参数（参数类型 参数）
     * @param args
     */
    public static void main(String[] args) {

        byte len = 10;

        //1
        System.out.println((len)*(len+1)/2);

        //2
        byte a = 0;
        for (byte i = 1;i<=len;i+=1){
            a+=i;
        }
        System.out.println(a);

        //3
        byte b = 0;
        for (byte i = len;i>0;i+=-1){
            b+=i;
        }
        System.out.println(b);

        //4
        byte c = 0;
        for (byte i = 1;i<=len>>1;i+=1){
            c =(byte)( i + (len+1-i) + c );
        }
        System.out.println(c);

    }

    public void add2(byte a,byte b){

    }
    public static void abc(int a,int b){

    }

}
