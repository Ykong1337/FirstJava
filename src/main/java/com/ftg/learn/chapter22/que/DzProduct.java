package com.ftg.learn.chapter22.que;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class DzProduct extends Product{

    private String name;

    private String price;

    private String num;
}
