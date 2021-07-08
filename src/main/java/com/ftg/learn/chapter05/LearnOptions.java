package com.ftg.learn.chapter05;

/**
 *
 *   >  <  >=  <=  !=  ==
 *  表达式
 *
 * 逻辑运算
 * &&  与  一假为假 全真为真
 * ||  或  一真为真 全假为假
 *
 */
public class LearnOptions {

    public void test(){

        //声明变量，并赋初始值
        int a = 9;
        a = a++;
        int b = 8;
        //变量 = 值 | 表达式 | 方法

        System.out.println(a++ > b++);
        System.out.println('a' < 'b');

    }
    public int add(int x,int y){
        return x + y;
    }

    public void count(){
        int  m = 1 , n = 2, o = 3 ,p = 4;
        System.out.println("ok = "+  ((m + n) *o /(p - o) + p) );
        System.out.println("ok = "+  (m + n) *o /(p - o) + p );
        System.out.println("ok = "+  p % n );
        System.out.println("ok = " +( m > n));
        System.out.println("ok = " + (p >= p));
        System.out.println("ok = " + (p != p));
    }

    public void testLogic(){
        int a = 3,b = 14;
        System.out.println(a > b);
        System.out.println(a > b && b++ > 15);
        System.out.println(b);
    }public void testLogic1(){
        int a = 3,b = 14;
        System.out.println(!(a < b) || b++ > a || b++ == a);
        System.out.println(b);


    }

    public void testLogic2() {
        System.out.println(true ^ true);
        System.out.println(false ^ false);
        System.out.println(true ^ false);
        System.out.println(false ^ true);
    }

    public  void testLogic3(){
        int  m = 1 , n = 2, o = 3 ,p = 4;
        System.out.println("ok = " +((p > m )&&(p < m)));
        System.out.println("ok = " +((p > m )||(p < m)));
        boolean OK = (p != p) && (n < o);
        System.out.println(OK );
        boolean Ok = (p != p) || (n < o);
        System.out.println(Ok );
    }
}
