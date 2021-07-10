package com.ftg.learn.Leetcode;

public class L1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] str = new int[len1+1][len2+1];  //创建两个字符串的长度各+1的二维数组
        for (int i = 0;i<len1+1 ; i++){
            str[i][0] = 0;                         //第一列置0
        }
        for (int j = 0;j<len2+1 ; j++){
            str[0][j] = 0;                          //第二列置0      text1.charAt(i)和text2.charAt(j) 不相同时  子串长度为0
        }
        for (int i = 1 ; i<len1+1;i++){
            for (int j = 1 ; j<len2+1;j++){                 //遍历所有字符串
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    str[i][j] = str[i-1][j-1] + 1;          //text1.charAt(i)和text2.charAt(j) 相同时  子串长度+1  要覆盖之前的结果
                }else {
                    str[i][j] = Math.max(str[i][j-1],str[i-1][j]);      //遍历之前的结果，取最大值
                }
            }
        }
        return str[len1][len2];                 //输出所有结果的最大值
    }
}
