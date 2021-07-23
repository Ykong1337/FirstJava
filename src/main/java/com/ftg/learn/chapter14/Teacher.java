package com.ftg.learn.chapter14;


public class Teacher {

    private String name;

    private String subject;

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void teach(Student1 student1, String subject, Classroom classroom){

        System.out.println(this.name + "在" + classroom.getNo() + "给" + student1.getName() + "补习" + subject);

    }
}
