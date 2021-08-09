package com.ftg.learn.chapter20;


import org.testng.annotations.Test;

public class Q1 {
    int a = 0;
    public String two(String str) {

        int len = str.length();
        for (int i = 0;i<len;i++){
            if ((str.charAt(i) != 46 && str.charAt(i) < 48) || str.charAt(i) > 57){
                throw new NumberFormatException("录入的是非法字符，请输入一个整数");
            }
        }

        for (int i = 0;i<len;i++){
            if (str.charAt(i) == 46){
                throw new NumberFormatException("录入的是小数，请重新输入一个整数");
            }
        }

        try {
            a = Integer.valueOf(str);
        }catch (NumberFormatException e) {
            throw new NumberFormatException("录入整数过大，请重新输入一个整数");

        }
        return Integer.toBinaryString(a);
    }

    @Test
    public void test(){
        System.out.println(new Q1().two("888888888888"));
    }
}
