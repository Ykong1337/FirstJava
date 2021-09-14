package com.ftg.learn.chapter23.entity;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Dept {
    private int deptno;

    private String dname;

    private String loc;
}
