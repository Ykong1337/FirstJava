package com.ftg.learn.chapter24.Dynamic;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface Person {

    @Select("SELECT * FROM dept")
    List<Map<String,Object>> say();
}
