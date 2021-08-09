package com.ftg.learn.chapter19.Dong;


import org.testng.annotations.Test;

class MyException extends Exception{
    public String toString( ){	return "negative number "; }
}
public class ExceptionDemo{

    public boolean t()
    {
        try
        {
            String str = null;
            System.out.println(str.toString() + "null,");
        }catch (Exception e){
            System.out.println("exception,");
        }
        finally
        {
            System.out.println("finally");
        }

        return false;
    }


    @Test
    public void test(){
        System.out.println(new ExceptionDemo().t());
    }
}