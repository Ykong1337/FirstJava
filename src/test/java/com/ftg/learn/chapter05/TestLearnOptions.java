package com.ftg.learn.chapter05;

import com.ftg.learn.chapter03.Solution;
import org.junit.Test;

public class TestLearnOptions {

    @Test
    public void test(){

        //先引后用;
        //创建实例
        LearnOptions lo = new LearnOptions();
        lo.testLogic3();

    }

    @Test
    public void test2(){
        Solution s = new Solution();
        System.out.println(s.strStr("loaa","lo"));
    }

}
