package com.ftg.learn.chapter21.expand;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    private String name;

    private String sex;

    private int age;

    private String address;

    private String id;
}
