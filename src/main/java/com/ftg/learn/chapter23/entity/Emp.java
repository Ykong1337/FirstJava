package com.ftg.learn.chapter23.entity;

import lombok.Data;
import lombok.ToString;

/**
 * 多对一 ：
 * 一个员工要对应一个部门
 * 员工实体类当中编写一个部门实体
 * @author KangJx
 * @date 2021/9/23
 */
@Data
@ToString
public class Emp {

    private int eno;

    private String ename;

    private String job;

    //......

    /**
     * 部门信息： 这个部门就是当前员的所在部门
     */
    Dept1 dept;

}
