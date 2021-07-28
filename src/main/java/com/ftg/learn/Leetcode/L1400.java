package com.ftg.learn.Leetcode;

import org.junit.jupiter.api.Test;

public class L1400 {

    public boolean canConstruct(String s, int k) {

        int count = 0;
        StringBuilder s1 = new StringBuilder();
        int len = s.length();

        if(len<k){
            return false;
        }

        for (int i = 0; i < len; i++) {
            s1.append(s.charAt(i));
        }

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (s1.charAt(i) == s1.charAt(j)) {
                    s1.delete(i, i + 1);
                    s1.delete(j - 1, j);
                    i = -1;
                    len -= 2;
                    break;
                }
            }
        }
        return len <= k ? true : false;
    }

}
