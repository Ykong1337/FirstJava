package com.ftg.learn.chapter12;

public class LearnString {

    public void string1() {

        String str = "返回一个字符序列，该序列是该序列的子序列。返回一个字符序列，该序列是该序列的子序列。返回一个字符序列，该序列是该序列的子序列。返回一个字符序列，该序列是该序列的子序列。返回一个字符序列，该序列是该序列的子序列。返回一个字符序列，该序列是该序列的子序列。";
        String str2 = "序列";
        int count = 0;
        for(int i = str.indexOf(str2); i != -1 ; i = str.indexOf(str2,i+str2.length())){
            count++;
            System.out.println("第"+str2+"几个"+str2+"现的位置是:" + i+"\t");
        }
        System.out.println();
        System.out.println("共有" + count + "个");
        System.out.println("第一次下标为" + str.indexOf("序列"));

    }

    public void string3() {

        String str1 = "2021-07-20";
        String[] str2 = str1.split("-");
        System.out.println("今天是" + str2[0] + "年");
        System.out.println(str2[1] + "月");
        System.out.println(str2[2] + "日");
    }

    public void string4() {

        String str1 = "abcdefghijk";
        String str2 = "acf";
        char[] arr2 = str2.toCharArray();
        int len = str1.length();
        int count = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 0, len2 = arr2.length; j < len2; j++) {
                if (arr2[j] == str1.charAt(i)){
                    count++;
                }
            }
        }

        if (count == arr2.length) {
            System.out.println("是子序列");
        }else {
            System.out.println("不是子序列");
        }
    }

}
