package com.ftg.learn.chapter22.jdbc.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Commodity {

    private String sname;

    private int cost;

    private int nums;
}
