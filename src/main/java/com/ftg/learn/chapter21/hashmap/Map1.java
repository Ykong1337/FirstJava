package com.ftg.learn.chapter21.hashmap;

import org.testng.annotations.Test;

import java.util.*;

public class Map1 {

    public Map<String, Object> q1(String username, int userage, char usersex) {
        Map<String, Object> map = new HashMap<>();
        map.put("姓名", username);
        map.put("年龄", userage);
        map.put("性别", usersex);
        return map;
    }

    public List<Map<String, Object>> q2(Map<String, Object>... userinfo) {
        List<Map<String, Object>> list = new ArrayList<>(3);
        for (Map<String, Object> user : userinfo) {
            list.add(user);
        }
        return list;
    }

    public List<Student> q2(Student... stu) {
        //部分公司里希望再使用list里如果有明确的长度，声明Arraylist（长度）
        List<Student> list = new ArrayList<>(3);
        for (Student s : stu) {
            list.add(s);
        }
        return list;
    }

    public void q4(Map<String, Object> map) {
        System.out.println();

        map.values();

    }


    public List<Clazz> q3(Clazz... c) {
        List<Clazz> list = new ArrayList<>(3);
        for (Clazz s : c) {
            list.add(s);
        }
        return list;
    }

    @Test
    public void test1() {
        Map1 map = new Map1();
        System.out.println(map.q3(new Clazz("1234", "J207", "哈尔滨", q2(new Student("myh", 22, '男')))));
    }


    @Test
    public void test2() {

        Map<String, Map> map = new HashMap<>();
        Map<String, Object> person1 = new HashMap<>();
        Map<String, Object> person2 = new HashMap<>();
        Map<String, Object> person3 = new HashMap<>();

        map.size();
        map.clear();
        map.put("myh", person1);
        map.put("phz", person2);
        map.put("lch", person3);

        person1.put("name", "门宇浩");
        person1.put("sex", "男");
        person1.put("tel", "17161783441");
        person1.put("age", 22);
        person1.put("id", "230381199905176317");

        person2.put("name", "彭翰泽");
        person2.put("sex", "男");
        person2.put("tel", "13359526161");
        person2.put("age", 21);
        person2.put("id", "230000111111113333");

        person3.put("name", "李春贺");
        person3.put("sex", "男");
        person3.put("tel", "13333333333");
        person3.put("age", 20);
        person3.put("id", "230000111111113333");


        System.out.println(map.get("phz"));
        System.out.println(map.get("myh"));
        System.out.println(map.get("lch"));
        System.out.println(person1.entrySet());
    }
}
