package com.ftg.learn.Leetcode;

public class L3 {
    public int lengthOfLongestSubstring(String s) {

        int len = s.length();
        int count = 1;
        int max = 1;
        int m = 0;

        if (len <= 0) {
            return 0;
        }


        for (int i = 0; i < len - 1; i++) {
            count = 1;
            for (int j = i + 1; j < len; j++) {

                if (s.charAt(i) == s.charAt(j)){
                    break;
                }else {
                    ++count;
                }
            }

            for (int k = 0;k<count;k++){

            }

        }
        return max;

    }

    public static void main(String[] args) {
        int x = new L3().lengthOfLongestSubstring("pwwkew");
        System.out.println(x);
    }
}
