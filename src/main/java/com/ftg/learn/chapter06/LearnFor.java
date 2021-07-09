package com.ftg.learn.chapter06;

public class LearnFor {
    int sum = 0;
    /**
     *
     */
    public void testFor(){
       for (int i = 1,len = 10,x = len >>1 ;i<= x;i++,len--){
           sum += (i + len);
       }
        System.out.println(sum);
    }
}
