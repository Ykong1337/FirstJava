package com.ftg.learn.Leetcode;

public class L852 {
    public int peakIndexInMountainArray(int[] arr) {
        int n = 0;

        for(int i = 0;i<arr.length-1;i++){
            if(arr[i] < arr[i + 1]){
                n = i+1;
            }
        }
        return n;

    }
}
