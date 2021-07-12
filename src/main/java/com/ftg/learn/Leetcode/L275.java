package com.ftg.learn.Leetcode;

public class L275 {
    int t = 0;
    public int hIndex(int[] citations) {
        if (citations.length == 1 && citations[0] == 0){
            return 0;
        }
        if (citations.length == 1){
            return 1;
        }
        for (int i = 0;i<citations.length;i++) {
            t = citations.length - i;
            if (t <= citations[i]) {
                return t;
            }
        }
        return 0;
    }
}
