package com.ftg.learn.chapter23.entity;

import lombok.Data;

import java.util.List;

/**
 * 员工 查询 当前员工所在的部位信息
 * 多对一：
 * 部门 查询  当前部门下的所有员工信息
 * 一对多：
 * @author KangJx
 * @date 2021/9/23
 */
@Data
public class Dept1 {

    private int deptno;

    private String dname;

    private String loc;

    List<Emp> emps;
}
