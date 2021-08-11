package com.ftg.learn.chapter21.hashmap;

import java.util.List;

public class Clazz {

    private String cno;

    private String cname;

    private String address;

    private List<Student> stu;

    public List<Student> getStu() {
        return stu;
    }

    public void setStu(List<Student> stu) {
        this.stu = stu;
    }

    public Clazz(String cno, String cname, String address, List<Student> stu) {
        this.cno = cno;
        this.cname = cname;
        this.address = address;
        this.stu = stu;
    }

    public Clazz(String cno, String cname, String address) {
        this.cno = cno;
        this.cname = cname;
        this.address = address;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", address='" + address + '\'' +
                ", stu=" + stu +
                '}';
    }
}
