package com.ftg.learn.chapter22.json;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    private int sno;

    private String name;

    private String address;
}
