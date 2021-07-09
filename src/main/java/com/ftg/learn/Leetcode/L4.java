package com.ftg.learn.Leetcode;

public class L4 {
    public static void shellSort(double[] arr) {
        if (arr == null || arr.length <= 1) return;
        int gap = arr.length / 2;
        while (gap != 0) {
            for (int i = gap; i < arr.length; i++) {
                double value = arr[i];
                int j = i - gap;
                for (; j >= 0 && arr[j] > value; j -= gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = value;
            }
            gap /= 2;
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double n = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;
        double[] arr = new double[length];
        for (int i = 0;i<length1;i++){
            arr[i] = nums1[i];
        }
        int k = length1;
        for (int j = 0;j<length2;j++){
            arr[k] = nums2[j];
            k++;
        }
        shellSort(arr);
        int c = length / 2;
        if (length % 2 != 0 )
            n = arr[c];
        else
            n = (arr[c-1]+arr[c])/2;
        return n;
    }
}
