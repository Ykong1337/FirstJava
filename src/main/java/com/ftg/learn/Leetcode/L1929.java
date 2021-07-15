package com.ftg.learn.Leetcode;

public class L1929 {
    public int[] getConcatenation(int[] nums) {

        int len1 = nums.length;
        int[] arr = new int[len1*2];
        int i = 0;
        for(i = 0;i<len1;i++){
            arr[i] = nums[i];
        }
        for(int j = 0;j<len1;j++){
            arr[i] = nums[j];
            i++;
        }
        return arr;

    }
}
