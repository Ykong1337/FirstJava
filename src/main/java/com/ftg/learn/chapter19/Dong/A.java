package com.ftg.learn.chapter19.Dong;


import org.testng.annotations.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class A {

    @Test
    public void test(){

        Singer singer = new Singer();

        Isinger isinger = (Isinger) Proxy.newProxyInstance(Singer.class.getClassLoader()
                , Singer.class.getInterfaces()
                , new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        System.out.println("===>");
                        Object object = method.invoke(singer,args);
                        return 0;
                    }
                });
        isinger.singsong();
    }


    static void Proc( int sel ){
        try{
            if( sel==0 ){
                System.out.println("no Exception ");
                return;
            }
		      else if( sel==1 ){
                int i=0;
                int j=10/i;}
        }
        catch( ArithmeticException e ) {
            System.out.println("ArithmeticException "); }
        catch( Exception e ) {
            System.out.println("Exception ");}
        finally{
            System.out.println("finally"); 	}
    }
    public static void main( String args[] ){
        Proc( 0 ); 	Proc( 1 );
    }
}
