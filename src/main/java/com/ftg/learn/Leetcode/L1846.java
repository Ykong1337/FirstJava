package com.ftg.learn.Leetcode;

public class L1846 {

    public static void shellSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int gap = arr.length / 2;
        while (gap != 0) {
            for (int i = gap; i < arr.length; i++) {
                int value = arr[i];
                int j = i - gap;
                for (; j >= 0 && arr[j] > value; j -= gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = value;
            }
            gap /= 2;
        }
    }

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        shellSort(arr);
        int len = arr.length;
        if (arr[0] != 1){
            arr[0] = 1;
        }

        for (int i = 0; i < len - 1; i++) {
            if (arr[i + 1] > arr[i] + 1) {
                arr[i + 1] = arr[i] + 1;
            }
        }
        return arr[len - 1];
    }
}
