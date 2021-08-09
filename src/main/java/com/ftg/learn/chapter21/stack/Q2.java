package com.ftg.learn.chapter21.stack;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Q2 {

    public int q2(int[] arr) {

        Arrays.sort(arr);
        int min = 0;
        int i = 0;
        for (int len = arr.length - 1; i < len; i++) {
            if (arr[i] != arr[i + 1]) {
                min = arr[i + 1];
                break;
            }
        }
        return min;
    }

    @Test
    public void test() {
        int[] arr = {1, 1, 3, 5, 7, 8, 9, 10};
        System.out.println(new Q2().q2(arr));
    }
}
