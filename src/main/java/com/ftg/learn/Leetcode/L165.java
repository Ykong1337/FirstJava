package com.ftg.learn.Leetcode;

import com.ftg.learn.chapter19.q2.Interface;
import org.testng.annotations.Test;

public class L165 {
    public int compareVersion(String version1, String version2) {

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int x = 0;
        int i = 0;
        if (v1.length > v2.length) {
            for (; i < v2.length; i++) {
                if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
                    x = 1;
                    break;
                } else if (Integer.parseInt(v1[i]) == Integer.parseInt(v2[i])) {
                    x = 0;
                } else {
                    x = -1;
                    break;
                }
            }

            if (x == 0) {
                for (;i<v1.length;i++){
                    if(Integer.parseInt(v1[i]) == 0){
                        x = 0;
                    }else{
                        x = 1;
                        break;
                    }
                }
            }
        } else if (v1.length == v2.length) {
            for (; i < v1.length; i++) {
                if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
                    x = 1;
                    break;
                } else if (Integer.parseInt(v1[i]) == Integer.parseInt(v2[i])) {
                    x = 0;
                } else {
                    x = -1;
                    break;
                }
            }
        } else {
            for (; i < v1.length; i++) {
                if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
                    x = 1;
                    break;
                } else if (Integer.parseInt(v1[i]) == Integer.parseInt(v2[i])) {
                    x = 0;
                } else {
                    x = -1;
                    break;
                }
            }

            if (x == 0) {
                for (;i<v2.length;i++){
                    if(Integer.parseInt(v2[i]) == 0){
                        x = 0;
                    }else{
                        x = -1;
                        break;
                    }
                }
            }
        }
        return x;
    }

    @Test
    public void test() {
        String s1 = "1.0.1";
        String s2 = "1.0";

        System.out.println(compareVersion(s1, s2));
    }
}
