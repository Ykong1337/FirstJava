package com.ftg.learn.chapter21.test17;

import org.testng.annotations.Test;

import java.util.LinkedList;

public class TestStu {

    @Test
    public void test(){
        Student s1 = new Student("刘德华",85);
        Student s2 = new Student("张学友",100);
        Student s3 = new Student("刘杰",65);
        Student s4 = new Student("章子怡",58);
        Student s5 = new Student("周迅",76);
        LinkedList<Student> list = new LinkedList();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        System.out.println(list.size());
        for (Student s : list) {
            if (s.getName() == "刘杰"){
                list.remove(s);
                break;
            }
        }
        for (Student i : list) {
            System.out.print(i.getName());
            System.out.print(i.getScore() + "\t");
        }
        s1.setScore(95);
        System.out.println();
        System.out.println("不及格：");
        for (Student i : list) {
            if (i.getScore()<60){
                System.out.print(i.getName());
            }
        }

    }
}
