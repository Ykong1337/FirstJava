package com.ftg.learn.Leetcode;

import org.testng.annotations.Test;

public class L1221 {
    public int balancedStringSplit(String s) {

        int len = s.length();
        int start = 0;
        int end = start + 2;
        int count = 1;
        while (end < len) {
            String str = s.substring(start, end);
            int l = 0;
            int r = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'L') {
                    l++;
                } else {
                    r++;
                }
            }
            if (l == r) {
                count++;
                start = end;
                end = start + 2;
            } else {
                end++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(new L1221().balancedStringSplit("RRLRRLRLLLRL"));
    }
}
