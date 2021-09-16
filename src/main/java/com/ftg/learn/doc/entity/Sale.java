package com.ftg.learn.doc.entity;


import com.ftg.learn.doc.dao.TypeEnum;
import com.ftg.learn.doc.dao.UnitEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Sale {

    @Key
    private Integer id;

    private String name;

    private String address;

    private Integer fid;

    private UnitEnum unit;

    private Double price;

    private TypeEnum type;

    private String scdate;

    private String ccdate;

    private Integer flag;
}
