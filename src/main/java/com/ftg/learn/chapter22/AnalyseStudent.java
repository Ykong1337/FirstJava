package com.ftg.learn.chapter22;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ftg.learn.chapter22.json.Student;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class AnalyseStudent<T> {

    /**
     * 把相应的泛型转换成为json对象
     * @param s
     * @return
     * @throws IntrospectionException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public String Analyse(T s) throws IllegalAccessException, InvocationTargetException, IntrospectionException {

        StringBuilder sb = new StringBuilder("{");
        Class c = s.getClass();
        Field[] fs = c.getDeclaredFields();
        int index = 0;
        for(Field f : fs){
            String key = f.getName();
            //根据  field 找到对应的方法（setter、getter）
            PropertyDescriptor pd = new PropertyDescriptor(key,c);
            Method ms = pd.getReadMethod();
            String value = ms.invoke(s).toString();
            sb.append("\"" + key + "\"").append(":").append("\"" + value + "\"");
            sb.append(index++==fs.length-1 ? "" : ",");
        }

        return sb.append("}").toString();
    }

    /**
     * 把list<T>换成json array
     * @param s
     * @return
     * @throws IllegalAccessException
     * @throws IntrospectionException
     * @throws InvocationTargetException
     */
    public String AnalyseList(List<T> s) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0 ,len = s.size();i < len;i++){
            String jsonobject = Analyse(s.get(i));
            sb.append(jsonobject).append(i==s.size()-1 ? "" : ",");
        }
        return sb.append("]").toString();
    }

    /**
     * java 转换 jsonobject
     * json 转换 java
     * @param args
     * @throws IllegalAccessException
     * @throws IntrospectionException
     * @throws InvocationTargetException
     */
    public static void main(String[] args) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        AnalyseStudent<Student> at = new AnalyseStudent();
        List<Student> li = Arrays.asList(
                new Student(1001,"小解","哈尔滨"),
                new Student(1002,"小彭","哈尔滨"),
                new Student(1003,"小李","哈尔滨"),
                new Student(1004,"小黄","哈尔滨")
        );

        JSONArray jo = (JSONArray) JSON.toJSON(li);
        System.out.println(jo);

//        System.out.println(at.AnalyseList(li));
//
//        System.out.println("==>alibaba===json--fastjson");
//        String json = JSON.toJSONString(li);
//        System.out.println(json);
//        JSONArray ja = JSON.parseArray(json);
//
//        for(int i = 0 ; i < ja.size();i++){
//
//            JSONObject jo = (JSONObject) ja.get(i);
//            System.out.println(jo.get("sname"));
//            System.out.println(jo.get("sno"));
//            System.out.println(jo.get("address"));
//        }
//
//        Student s = new Student(1001,"小解","哈尔滨");
//        String str1 = JSON.toJSONString(s);
//        System.out.println(str1);
//
//        JSONObject jo1 = JSON.parseObject(str1);

    }

}
