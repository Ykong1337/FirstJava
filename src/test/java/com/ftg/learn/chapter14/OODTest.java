package com.ftg.learn.chapter14;

import org.junit.Test;

public class OODTest {

    @Test
    public void T1(){

        Elephant e = new Elephant("张三","中国");
        Icebox icebox = new Icebox();
        icebox.put(e);

    }

    @Test
    public void T2(){
        Cat cat = new Cat("Tom");
        Food food = new Food();

        food.to(cat);

    }

    @Test
    public void T3(){
        Cat cat = new Cat("Tom");
        Food food = new Food();
        food.setName("鱼罐头");

        food.to(cat);

    }

    @Test
    public void T4(){
        Student1 student1 = new Student1("小王");
        Teacher teacher = new Teacher("李二狗","数学");
        Classroom classroom = new Classroom(303);

        teacher.teach(student1,teacher.getSubject(),classroom);

    }

    @Test
    public void T5(){
        Me me = new Me();
        Food food1 = new Food();
        Food food2 = new Food();
        Food food3 = new Food();
        food1.setName("面包");
        food2.setName("牛奶");
        food3.setName("肠");

        food1.to(me);
        food2.to(me);
        food3.to(me);
    }
}
