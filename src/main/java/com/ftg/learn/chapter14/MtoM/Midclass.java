package com.ftg.learn.chapter14.MtoM;

public class Midclass {

    private int mno;

    private Student student;

    private Subject subject;

    public Midclass(int mno, Student student, Subject subject) {
        this.mno = mno;
        this.student = student;
        this.subject = subject;
    }

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
