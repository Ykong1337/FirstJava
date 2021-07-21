package com.ftg.learn.chapter12;

import java.util.Arrays;

public class StringP {

    public void s1(String str) {

        String[] s1 = str.split("#");
        for (String c : s1) {
            System.out.println(c);
        }
    }

    public void s2(String str) {

        int a = str.lastIndexOf("那");
        System.out.println(a);
    }

    public void s3(String s) {

        int len = s.length();

        if (len < 5) {
            System.out.println("字符串不足");
        }
        if (s.lastIndexOf(".java") == len - 5) {
            System.out.println("是以.java结束");
        } else {
            System.out.println("不是以.java结束");
        }
    }

    public void s4(String str) {

        int len = str.length();

        if (len == 18) {
            String sexStr = str.substring(16, 17);
            int i = Integer.parseInt(sexStr);
            if (i % 2 != 0) {
                System.out.println("男");
            } else {
                System.out.println("女");
            }
        } else if (len == 15) {
            String sexStr = str.substring(13, 14);
            int i = Integer.parseInt(sexStr);
            if (i % 2 != 0) {
                System.out.println("男");
            } else {
                System.out.println("女");
            }
        } else {
            System.out.println("不是身份证号码");
        }
    }

    public void s5(String str) {

        String[] s = str.split("-");
        System.out.println("姓名为" + s[0]);
        System.out.println("年龄为" + s[1]);
        System.out.println("性别为" + s[2]);
        System.out.println("地址为" + s[3]);
    }

    static void printCharInfo(String str) {

        char[] arr = str.toCharArray();
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

    public void s7(String str) {

        String[] str1 = str.split("-");
        int len = str1.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            String[] str2 = str1[i].split("#");
            sum += Integer.parseInt(str2[2]);
            for (String x : str2) {
                System.out.print(x + "\t");
            }
            System.out.println();
        }
        System.out.println("总分为" + sum);
    }

    public void s8(String str) {

        String str1 = "";
        int len = str.length();
        for (int i = 0; i < len; i++) {
            str1 = str.charAt(i) + str1;
        }
        str = str + str1;
        System.out.println(str);
    }

}
