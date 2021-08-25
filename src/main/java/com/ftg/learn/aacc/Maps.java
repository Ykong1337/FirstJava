package com.ftg.learn.aacc;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Maps {
    public HashMap<String,User> map(){
        HashMap<String, User> m = new HashMap<>(4);
        m.put("李二狗",new User("李二狗","123",'男'));
        m.put("王春花",new User("王春花","456",'女'));
        m.put("张大埋汰",new User("张大埋汰","1232313",'男'));
        m.put("赵大滋溜",new User("赵大滋溜","123dfs",'男'));

        return m;

    }

    public List<User> save(User... stu) {
        //部分公司里希望再使用list里如果有明确的长度，声明Arraylist（长度）
        List<User> list = new ArrayList<>(4);
        for (User s : stu) {
            list.add(s);
        }
        return list;
    }

    @Test
    public void test(){
        Maps m = new Maps();
        List<User> s = m.save(new User("李二狗","123",'男'),
                new User("王春花","456",'女'),
                new User("张大埋汰","1232313",'男'),
                new User("赵大滋溜","123dfs",'男'));
        System.out.println(s);
    }

    @Test
    public void test1(){
        Maps m = new Maps();
        HashMap s = m.map();
        System.out.println(s);
    }
}
