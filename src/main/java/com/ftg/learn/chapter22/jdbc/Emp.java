package com.ftg.learn.chapter22.jdbc;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Emp {

    private Integer eno;
    private String ename;
    private String job;
    private Integer mgr;
    private String hirdate;
    private Integer sal;
    private Integer comm;
    private Integer deptno;
}
