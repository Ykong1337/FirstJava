package com.ftg.learn.aacc;

import org.testng.annotations.Test;

import java.util.*;
import java.util.function.Function;

public class Q820 {

    public Integer function(Integer[] num, Function<Integer[], Integer> x) {
        return x.apply(num);
    }

    @Test
    public void q2() {


        Integer[] num = {1, 23, 4, 4, 22, 34, 45, 11, 33};

        int min = function(num,x->{
            Arrays.sort(num);
            return num[0];
        });

        int sum = function(num, x -> {
            HashSet<Integer> set = new HashSet<>();
            int ssum = 0;
            for (Integer s : num) {
                set.add(s);
            }
            for (Integer i : set) {
                ssum = ssum + i * 2;
            }
            return ssum;
        });

        System.out.println(min);
        System.out.println(sum);
    }


}
