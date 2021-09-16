package com.ftg.learn.doc.entity;


import com.ftg.learn.doc.dao.FrameEnum;
import com.ftg.learn.doc.dao.TypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.lang.reflect.Type;

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
