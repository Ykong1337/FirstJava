package com.ftg.learn.chapter14;

import com.ftg.learn.chapter14.MtoM.Midclass;
import com.ftg.learn.chapter14.MtoM.Subject;
import com.ftg.learn.chapter14.OtM.ClassRoom;
import com.ftg.learn.chapter14.OtM.Student;
import org.junit.Test;

public class OneToOneTest {


    @Test
    public void test1() {
        Human human = new Human();
        IdCard id = new IdCard();

        human.setId(id);
        id.setHuman(human);

        human.setName("张三");
        human.setAge(18);
        human.setSex('男');
        id.setCardNo("230381111111111111");

        System.out.println(human);
    }


    @Test
    public void test2() {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setName("计科二班");
        Student[] student = new Student[3];

        student[0] = new Student("张三");
        student[1] = new Student("李四");
        student[2] = new Student("王也");

        classRoom.setStudents(student);

        System.out.println(classRoom.getName());
        System.out.println(classRoom.getStudents().length + "人");

        for (Student x : classRoom.getStudents()){
            System.out.println(x.getName());
        }

    }



}
