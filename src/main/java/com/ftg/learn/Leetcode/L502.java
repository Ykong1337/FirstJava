package com.ftg.learn.Leetcode;

import java.util.Arrays;

public class L502 {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int sum = 0;
        while (k!=0){

            for (int i = capital.length - 1;i>=0;i--) {
                if (w >= capital[i]) {
                    w = w - capital[i];
                    k--;
                    w += profits[i];
                    sum += profits[i] + w;
                }

            }
        }
        return sum;
    }
}
