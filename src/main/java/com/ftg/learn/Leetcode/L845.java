package com.ftg.learn.Leetcode;

public class L845 {//854
    public int longestMountain(int[] arr) {
        int count = 0;
        int len = 0;
        for (int i = 1;i<arr.length-1;i++){
            if (arr[i-1]<arr[i] && arr[i]>arr[i+1]){
                count = i;
            }else {
                continue;
            }
            int n = count;
            while (arr[n-1] < arr[n]){
                n--;
                if (n-1 < 0){
                    break;
                }
            }
            int m = count;
            while (arr[m] > arr[m+1]){
                m++;
                if (m+1 > arr.length-1){
                    break;
                }
            }
            len = Math.max(len,m - n + 1);
        }
        return len;
    }
}
