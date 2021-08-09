package com.ftg.learn.Leetcode;


import org.testng.annotations.Test;

public class L459 {

    public boolean repeatedSubstringPattern(String s) {

        int count = 0;
        int len = s.length();
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < len; i++) {
            s1.append(s.charAt(i));
        }

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (s1.charAt(i) == s1.charAt(j)) {
                    s1.delete(i, j);
                    count = j;
                    len -= j;
                    i = -1;
                    break;
                }
            }
        }
        System.out.println(s1);
        return len == count ? true : false;
    }

    @Test
    public void test() {
        System.out.println(new L459().repeatedSubstringPattern("abac"));
    }
}
