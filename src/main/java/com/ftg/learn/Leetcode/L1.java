package com.ftg.learn.Leetcode;

public class L1 {
    public int[] twoSum(int[] nums, int target) {
        int[] two = new int[2];
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    two[0] = i;
                    two[1] = j;
                }
            }
        }
        return two;
    }

    public static void main(String[] args) {
        int[] n = {2,7,11,15};
        int[] x = new int[10];
        L1 l = new L1();
        x = l.twoSum(n,9);
    }
}
