package com.ftg.learn.thread;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.testng.annotations.Test;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class AtomicIntegerFieldUpdaterTest {

    /**
     * 测试引用类型原子类
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Student implements Serializable {
        volatile long id;
        volatile String name;
        volatile int age;
    }

    @Test
    public void testAtomicIntegerFieldUpdater() {
        Student student = new Student(1L, "赵四", 58);

        // 使用ageUpdater绑定Student类中的age属性
        AtomicIntegerFieldUpdater<Student> ageUpdater =
                AtomicIntegerFieldUpdater.newUpdater(Student.class, "age");

        // 对student中的age++并返回
        System.out.println("age++: " + ageUpdater.getAndIncrement(student));
        System.out.println("age--: " + ageUpdater.getAndDecrement(student));
        System.out.println("先返回age的值，然后 age+=5: " + ageUpdater.getAndAdd(student, 5));
        System.out.println("先返回age的值，然后 accumulate: " + ageUpdater.getAndAccumulate(student, 5, (a, b) -> {
            System.out.printf("a: %s b: %s\n", a, b);
            return a + b;
        }));
    }

    @Test
    public void testAtomicLongFieldUpdater() {
        Student student = new Student(1L, "赵四", 58);

        // 使用idUpdater绑定Student类中的id属性
        AtomicLongFieldUpdater<Student> idUpdater =
                AtomicLongFieldUpdater.newUpdater(Student.class, "id");

        System.out.println("id: " + student.getId());
        System.out.println("++id: " + idUpdater.incrementAndGet(student));
        System.out.println("--id: " + idUpdater.decrementAndGet(student));
        System.out.println("id+=5: " + idUpdater.addAndGet(student, 5));
        System.out.println("accumulate: " + idUpdater.accumulateAndGet(student, 5, (a, b) -> {
            System.out.printf("a: %s b: %s\n", a, b);
            return a + b;
        }));
    }

    @Test
    public void testAtomicReferenceFieldUpdater() {
        Student student = new Student(1L, "赵四", 58);

        // 使用nameUpdater绑定Student类中的name属性
        AtomicReferenceFieldUpdater<Student, String> nameUpdater =
                AtomicReferenceFieldUpdater.newUpdater(Student.class, String.class, "name");

        System.out.println("将name修改为飞机: " + nameUpdater.getAndSet(student, "飞机"));
        System.out.println("student: " + student);

        System.out.println("CAS方式将name从飞机修改为大炮: "
                + nameUpdater.compareAndSet(student, "飞机", "大炮"));
        System.out.println("student: " + student);
    }
}
