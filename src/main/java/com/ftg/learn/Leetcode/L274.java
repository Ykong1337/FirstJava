package com.ftg.learn.Leetcode;


public class L274 {
    public static void quickSort(int arr[], int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        while (l < r) {
            while (arr[l] < pivot) {
                l += 1;
            }
            while (arr[r] > pivot) {
                r -= 1;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot) {
                r -= 1;
            }
            if (arr[r] == pivot) {
                l += 1;
            }
        }
        if (l == r) {
            l += 1;
            r -= 1;
        }
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
    int n = 0;
    int m = 0;
    int t = 0;
    public int hIndex(int[] citations) {
        if (citations.length == 1 && citations[0] == 0){
            return 0;
        }
        if (citations.length == 1){
            return 1;
        }
        quickSort(citations,0,citations.length-1);
        for (int i = 0;i<citations.length;i++) {
            t = citations.length - i;
            if (t <= citations[i]) {
                return t;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] c = {0,3};
        L274 l = new L274();
        int x = l.hIndex(c);
        System.out.println(x);
    }
}
