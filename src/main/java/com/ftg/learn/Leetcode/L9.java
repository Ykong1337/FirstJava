package com.ftg.learn.Leetcode;

public class L9 {
    public boolean isPalindrome(int x) {
        String a = ""+x;
        int len = a.length();
        for (int i = 0;i<len >> 1;i++){
            if (a.charAt(i) == a.charAt(len-1-i)){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        L9 l = new L9();
        boolean x = l.isPalindrome(121);
        System.out.println(x);
    }
}
