package com.ftg.learn.chapter21.stack;

import org.testng.annotations.Test;

public class Q3 {

    public int q3(int[] arr) {

        for (int i = 0, len = arr.length; i < len; i++) {
            int count = 0;
            for (int j = 0; j < len; j++) {
                if (i != j && arr[i] == arr[j]) {
                    ++count;
                    break;
                }
            }
            if (count == 0) {
                return arr[i];
            }
        }
        return 0;
    }

    @Test
    public void test() {
        int[] arr = {1, 3, 3, 5, 7, 8, 9, 10, 10, 1, 5, 7};
        System.out.println(new Q3().q3(arr));
    }
}
