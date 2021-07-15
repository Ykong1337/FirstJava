package com.ftg.learn.chapter09;

import java.util.Scanner;

public class LearnArr {


    public void initArray() {

        int[] arr;

        int[] arrnull = null;

        //声明数组变量 开辟空间4 连续的  整形默认值 0|0.0
        int[] arr1 = new int[4];

        //创建数组 开辟空间1,2,3,4
        int[] arr2 = new int[]{1, 2, 3, 4};


        int[] arr3 = new int[]{45, 56, 67, 89};
        char[] arr4 = new char[]{'门', '宇', '浩'};
        double[] arr5 = new double[10];


        for (int i = 0; i < 10; i++) {
            arr5[i] = i + 1;
        }

        for (double x : arr5) {
            System.out.println(x);
        }

        System.out.println(arr5);
    }

    public void ArrP1() {

        int[] arr = new int[]{1, 3, 7, 8, 9, 4, 1, 2, 5, 7, 5};
        int max = 0;

        for (int x : arr) {
            max = Math.max(max, x);
        }
        System.out.println(max);
    }


    public int[] switchNum(int[] arr, int i, int minIndex) {
        if (i != minIndex) {
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    public int addSum(int[] arr) {
        int sum = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public void for2(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < len; j++) {
                if (arr[j] > arr[minIndex]) {
                    minIndex = j;
                }
            }

            arr = switchNum(arr, i, minIndex);

        }
    }

    public void outValue(int[] arr) {
        for (int x : arr) {
            System.out.print(x + "\t");
        }
    }

    public void ArrP2() {

        int[] arr = new int[]{67, 13, 84, 21, 55};
        int len = arr.length;
        int sum;

        for2(arr);
        sum = addSum(arr);
        outValue(arr);

        System.out.println("成绩和：" + sum);
        System.out.println("平均成绩：" + (sum / len));
        System.out.println("最小成绩：" + arr[len - 1]);
        System.out.println("最大成绩：" + arr[0]);

    }


    public void ArrP3() {
        int[] arr = new int[]{10, 23, 2, 45, 6};

        for (int i = 0, len = arr.length; i < len / 2; i++) {
            int s = arr[i];
            arr[i] = arr[len - i - 1];
            arr[len - i - 1] = s;
        }

        for (int x : arr) {
            System.out.println(x);
        }
    }

    public void ArrP4() {

        int[] arr = new int[]{72, 89, 65, 58, 87, 91, 53, 82, 71, 93, 76, 68};
        int len = arr.length;
        int sum = 0;
        for (int x : arr) {
            sum += x;
        }
        System.out.println("平均值为：" + sum / len);
    }

    public void ArrP5() {

        char[] arr = new char[]{'我', '爱', '你'};
        int len = arr.length;
        for (char i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int i = len - 1; i >= 0; i--) {
            System.out.print(arr[i] + "\t");
        }
    }

    public void ArrP6() {
        int pay = (int) (Math.random() * 100);
        System.out.println("输入一个数 0-100：");
        Scanner sc = new Scanner(System.in);
        int cost = sc.nextInt();
        int n = 1;

        while (cost != pay) {
            if (cost < pay) {
                System.out.println("低了");
            } else if (cost > pay) {
                System.out.println("高了");
            }
            cost = sc.nextInt();
            n++;
        }
        System.out.println();
        System.out.println("True");
        System.out.println("你猜了" + n + "次");

    }

    public static void main(String[] args) {
        LearnArr l = new LearnArr();
        l.ArrP6();
    }


}
