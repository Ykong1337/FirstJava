package com.ftg.learn.chapter23.dao;

import java.util.HashMap;
import java.util.Map;

public class BeanFactory{

    private Map<String,Object> map = new HashMap();

    /**
     反射方法把address对应的类添加到map当中
     */
    public boolean initMap(String address){

        map.clear();

        return true;
    }

    /**
     解析filePath所对应的真实xml路径，将里面的所有 <bean id="st" class="com.ftg.learn.*.aa"></bean>全部提取出来，通过initmap方法完成实例化
     */
    public boolean init(String filePath){


        return true;
    }

    /**
     返回 当前map里面的key为className的实例
     */
    public Object getBean(String className){


        return "";
    }


}
