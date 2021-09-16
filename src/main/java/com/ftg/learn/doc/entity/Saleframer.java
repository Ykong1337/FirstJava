package com.ftg.learn.doc.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Saleframer {

    @Key
    private Integer id;

    private String name;

    private String address;

    private String boss;

    private FrameEnum type;

    private Integer flag;
}
