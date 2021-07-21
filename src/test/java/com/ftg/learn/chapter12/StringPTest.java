package com.ftg.learn.chapter12;

import org.junit.Test;

public class StringPTest {

    @Test
    public void test1() {
        new StringP().s1("卡巴斯基#杀毒软件#免费版#俄罗斯#");
    }

    @Test
    public void test2() {
        new StringP().s2("那车水马龙的人世间,那样地来 那样地去,太匆忙");
    }

    @Test
    public void test3() {
        new StringP().s3("abcdefg.java");
    }

    @Test
    public void test4() {
        new StringP().s4("230381199905176317");
    }

    @Test
    public void test5() {
        new StringP().s5("张三-18-男-中国");
    }

    @Test
    public void test6() {
        StringP.printCharInfo("apple is a apple.");
    }

    @Test
    public void test7() {
        new StringP().s7("01#张三#20-02#李四#30-03#王五#40");
    }

    @Test
    public void test8() {
        new StringP().s8("ok");
    }


}
