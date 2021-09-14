package com.ftg.learn.chapter23.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DeptDetail {

    private int deptno;

    private String  dname;

    private String loc;

    private int eno;

    private String ename;

    private String hirdate;

    private String job;

    private int mgr;

    private int sal;

    private int comm;
}
