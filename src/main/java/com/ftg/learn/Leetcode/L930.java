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
    public static void main(String[] args) {
        L930 l = new L930();
        int[] n = {1,0,1,0,1};
        int x = l.numSubarraysWithSum(n,2);
        System.out.println(x);
    }
}
