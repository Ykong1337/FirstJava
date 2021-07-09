package com.ftg.learn.Leetcode;

public class L17_10 {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int[] copy = new int[len];

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] == nums[j]) {
                    copy[j]++;
                }
            }
        }
        int max = 0;
        int p = 0;
        for (int i = 0; i < len; i++) {
            if (copy[i] > max) {
                max = copy[i];
                p = i;
            }
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int c = 0;
        for (int t = 0; t < len; t++) {
            c+=copy[t];
            if (t == len - 1 && c == 0) {
                return -1;
            }
        }
        if (p<len/2){
            return -1;
        }
        return nums[p];
    }
}