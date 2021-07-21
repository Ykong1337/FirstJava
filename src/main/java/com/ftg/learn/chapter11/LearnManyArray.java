package com.ftg.learn.chapter11;

import com.ftg.learn.chapter10.ArrayExpend;

import java.util.Arrays;

public class LearnManyArray {

    public void testTwoArray() {
        int[][] as = new int[3][];
        as[0] = new int[]{1, 2, 3, 4, 5, 6};
        as[1] = new int[]{3, 4};
        as[2] = new int[]{5, 6};
        System.out.println(as.length);
        System.out.println(as[0].length);
        System.out.println(as[1].length);
        System.out.println(as[2].length);
    }

    public void TwoArray() {
        int[][] arr = new int[10][10];
        for (int i = 0, len = arr.length; i < len; i++) {
            for (int j = 0, lenj = arr[0].length; j < lenj; j++) {
                arr[i][j] = i + j;
            }
        }

        for (int i = 0, len = arr.length; i < len; i++) {
            for (int j = 0, lenj = arr[0].length; j < lenj; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println();
        for (int i = 0, len = arr.length; i < len; i++) {

            if (i % 2 == 0) {
                for (int j = 0, lenj = arr[0].length; j < lenj; j++) {
                    System.out.print(arr[i][j] + "\t");
                }
                System.out.println();
            } else {
                for (int j = arr[0].length - 1; j >= 0; j--) {
                    System.out.print(arr[i][j] + "\t");
                }
                System.out.println();
            }

        }
    }

    public int serch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + high >> 1;
            int midVal = arr[mid];

            if (midVal < value) {
                low = midVal;
            } else if (midVal > value) {
                high = midVal;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }


    public void arr1(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        int index = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (index != n - 1) {
                if (arr[i] != -1) {
                    if (count == 2) {
                        arr[i] = -1;
                        count = 0;
                    } else {
                        count++;
                    }
                }
                if (i == n - 1) {
                    i = -1;
                }
            }
        }
        int v = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == -1) {
                v = i;
            }
        }
        System.out.println(v);
    }

    public void notre(int[] arr) {
        int len = arr.length;
        if (len == 0 || arr == null) {
            System.out.println("数组为空或无长度");
        }
        Arrays.sort(arr);
        int c = arr[0];
        int count = 1;
        System.out.println(c);
        for (int i = 0; i < len; i++) {
            if (arr[i] != c) {
                count++;
                c = arr[i];
                System.out.println(c);
            }
        }
        System.out.println("有" + count + "个");
    }

    public int q2(int[] arr) {

        if (null == arr || arr.length == 0) {
            return 0;
        }
        //我认为数组长度是多少就有多少个不重复的数
        int max = arr.length;
        //{1,3,1,2,1}
        for (int i = 0; i < max; i++) {
            for (int j = i + 1; j < max; j++) {
                if (arr[i] == arr[j]) {
                    //{1,3,1,2}
                    System.arraycopy(arr, j + 1, arr, j, arr.length - j - 1);
                    System.out.println(Arrays.toString(arr));
                    max--;
                }
            }
        }
        System.out.println("---------------" + max);
        for (int i = 0; i < max; i++) {
            System.out.println(arr[i]);
        }

        return 0;
    }

    public void numCount(int[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int len = arr.length;
        if (len == 0 || arr == null) {
            System.out.println("数组为空或无长度");
        }
        if (len == 1) {
            System.out.println(arr[0] + "出现了" + 1 + "次");
        }

        int count = 1;
        for (int i = 0; i < len - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                count++;
            } else {
                System.out.println(arr[i] + "出现了" + count + "次");
                count = 1;
            }
            if (i == len - 2) {
                System.out.println(arr[i + 1] + "出现了" + count + "次");
            }
        }
    }


}
