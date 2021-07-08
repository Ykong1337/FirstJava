package com.ftg.learn.Leetcode;

public class L1365 {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int n;
        int[] temp = new int[len];
        for (int i = 0;i<len;i++){
            n = 0;
            for (int num : nums) {
                if (nums[i] > num) {
                    n++;
                }
            }
            temp[i] = n;
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] x = {8,1,2,2,3};
        x = L1365.smallerNumbersThanCurrent(x);
    }
}
