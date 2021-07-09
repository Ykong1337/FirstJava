package com.ftg.learn.Leetcode;

public class L11 {
    public int maxArea(int[] height) {
        int len = height.length;
        int s;
        int S = 0;
        int i = 0;
        int l = len - 1;
        while (i < l){  // j  0-8    len = 9
                if(height[i] < height[l]){
                    s = height[i];
                    i++;
                }else{
                    s = height[l];
                    l--;
                }
                S = Math.max(S, s * (l - i + 1));
        }
        return S;
    }
}
