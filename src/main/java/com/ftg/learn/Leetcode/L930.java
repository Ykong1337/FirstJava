package com.ftg.learn.Leetcode;

public class L930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int value = 0;
        int sum;
        for(int i = 0;i<nums.length;i++){
            sum = nums[i];
            if(nums[i] == goal){
                ++value;
            }
            for(int j = i+1;j<nums.length;j++){
                sum += nums[j];
                if(sum == goal){
                    ++value;
                }
            }
        }
        return value;
    }
}
