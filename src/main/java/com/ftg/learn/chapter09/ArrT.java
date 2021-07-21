package com.ftg.learn.chapter09;

import java.util.Scanner;

public class ArrT {

    public static void main(String[] args) {
        ArrT t = new ArrT();
        t.Arr5();
    }

    public void Arr1() {

        //初始化数组 长度为5
        int[] arr = new int[5];

        //数组赋值
        int i = 0;
        int len = arr.length;
        System.out.println("请输入" + len + "个数字：");
        while (i < len) {
            arr[i] = new Scanner(System.in).nextInt();
            i++;
        }

        //遍历输出数组arr
        for (int x : arr) {
            System.out.print(x + "\t");
        }
    }

    public void Arr2() {

        //数组初始化 长度为5
        int[] arr = new int[5];

        //数组赋值
        int i = 0;
        int len = arr.length;
        System.out.println("请输入" + len + "个数字：");
        while (i < len) {
            arr[i] = new Scanner(System.in).nextInt();
            i++;
        }

        //倒序输出数组
        for (int j = len - 1; j >= 0; j--) {
            System.out.print(arr[j] + "\t");
        }
    }

    public void Arr3() {

        //数组初始化 长度为10
        int[] arr = new int[10];

        //数组赋值
        int i = 0;
        int len = arr.length;
        System.out.println("请输入" + len + "个数字：");
        while (i < len) {
            arr[i] = new Scanner(System.in).nextInt();
            i++;
        }

        //定义最大值和最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        //遍历数组，将最大值赋给max，最小值赋给min
        for (int j = 0; j < len; j++) {
            if (arr[j] > max) {
                max = arr[j];
            }
            if (arr[j] < min) {
                min = arr[j];
            }
        }
        System.out.println("最大值为：" + max);
        System.out.println("最小值为：" + min);
        System.out.println("平均值为：" + ((max + min) / 2));

    }

    public void Arr4() {

        //初始化数组  长度为10
        int[] arr = new int[10];

        //数组赋值
        int i = 0;
        int len = arr.length;
        System.out.println("请输入" + len + "个数字：");
        while (i < len) {
            arr[i] = new Scanner(System.in).nextInt();
            i++;
        }

        //n为数组arr的下标
        int n = 0;
        //定义最大值
        int max = Integer.MIN_VALUE;

        //遍历数组将最大值赋给max，同时将下标赋给n
        for (int j = 0; j < len; j++) {
            if (arr[j] > max) {
                max = arr[j];
                n = j;
            }
        }
        System.out.println("最大值为：" + max + "\t" + "下标为：" + n);
    }


    public void Arr5() {

        //数组初始化 长度为5
        int[] arr = new int[5];
        //数组赋值
        int i = 0;
        int len = arr.length;
        System.out.println("请输入" + len + "个数字：");
        while (i < len) {
            arr[i] = new Scanner(System.in).nextInt();
            i++;
        }

        //遍历数组  出现5时跳出循环
        for (int x : arr) {
            if (x == 5) {
                System.out.println("数字5在此数组中");
                break;
            }
        }
    }


    public void Arr6() {

        //初始化数组 长度为5
        int[] arr = new int[5];

        //数组赋值
        int i = 0;
        int len = arr.length;
        System.out.println("请输入" + len + "个数字：");
        while (i < len) {
            arr[i] = new Scanner(System.in).nextInt();
            i++;
        }

        //输入数字
        System.out.println("请定义一个数字：");
        int n = new Scanner(System.in).nextInt();

        //遍历数组  把数组中的各个值与输入的数字作比较  出现相同则输出
        for (int x : arr) {
            if (x == n) {
                System.out.println("此数组中有" + n + "数字");
                break;
            } else {
                System.out.println("该数字不在此数组中");
            }
        }
    }

    public void Arr7() {

        //初始化数组  长度为10
        int[] arr = new int[10];

        //数组赋值
        int i = 0;
        int len = arr.length;
        System.out.println("请输入" + len + "个数字：");
        while (i < len) {
            arr[i] = new Scanner(System.in).nextInt();
            i++;
        }

        //定义数组的和
        int sum = 0;
        //累加数组值的和
        for (int x : arr) {
            sum += x;
        }
        //计算平均值输出
        System.out.println("平均值为：" + (sum / len));
    }


}
