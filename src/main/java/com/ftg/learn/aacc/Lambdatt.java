package com.ftg.learn.aacc;

import org.testng.annotations.Test;

public class Lambdatt {

    public String ct(String str, Fun f) {
        return f.getValue(str);
    }

    @Test
    public void test() {

        String str = ct("ykong", (x) -> x.toUpperCase());
        String str2 = ct("ykong", (x) -> x.substring(1, 4));
        System.out.println(str);
        System.out.println(str2);
    }

    //--------------------------------------------------------------------
    public long ce(Long x, Long y, Func<Long, Long> f) {
        return f.count(x, y);
    }

    @Test
    public void test1() {

        long t = ce(50L, 70L, (x, y) -> x + y);
        long t1 = ce(50L, 70L, (x, y) -> x * y);
        System.out.println(t);
        System.out.println(t1);

    }

}
