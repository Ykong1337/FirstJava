package com.ftg.learn.chapter21.expand;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class LearnLambda {

    public List<Student> initTenStu() {
        return Arrays.asList(
                new Student("李二狗", "男", 14, "黑龙江", "230381199905176317"),
                new Student("李三猫", "男", 15, "北京", "230381199007226317"),
                new Student("赵小狗", "男", 16, "天津", "230381200008186317"),
                new Student("张大狗", "男", 17, "吉林", "230381200001146317"),
                new Student("李小狗", "男", 18, "辽宁", "230381199907156317"),
                new Student("王二妮", "女", 19, "黑龙江", "230381199906186317")
        );
    }

    public void ageGen20(int age, IfRule<Student> ifr) {
        List<Student> stu = this.initTenStu();

        for (Student s : stu) {
            if (ifr.test(s)) {
                System.out.println(s);
            }
        }
    }


    @Test
    public void test1() {
        List<Student> ls = new LearnLambda().initTenStu();

        for (Student s : ls) {
            if (s.getAddress().equals("黑龙江")) {
                System.out.println(s);
            }
        }

        String[] birth = new String[ls.size()];
        for (int i = 0; i < ls.size(); i++) {
            birth[i] = ls.get(i).getId().substring(6,14);
        }
        for (String c : birth){
            System.out.println(c);
        }
    }
}
