package com.ftg.learn.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class L763 {
    public List<Integer> partitionLabels(String S) {
        int i;
        int t = 0;
        int n;
        int m = 0;
        int length = S.length();
        List<Integer> l = new ArrayList<>();
        for (i = 0;i<length;i++) {
            for (int j = length - 1; j >= i; j--) {
                if (S.charAt(j) == S.charAt(i))
                    if (j > m){
                        m = j;
                    }else{
                        break;
                    }
            }
            if (i >= m) {
                n = m;
                l.add(n+1-t);
                t = m+1;
            }
        }
        return l;
    }
}
