package com.ftg.learn.chapter03;

public class Solution {

    public int divide(int dividend, int divisor) {
        int y = 0;
        int i = 0;
        int j = 0;

        if (dividend == 0){
            y = 0;
        }
        if (dividend > 0 && divisor > 0){
            while (dividend >= divisor){
                dividend = dividend - divisor;
                ++i;
            }
            y = i;
        }else if (dividend < 0 && divisor < 0){
            j = dividend;
            while (dividend <= divisor){
                dividend = dividend - divisor;
                ++i;
            }
            if (j == -2147483648 && divisor == -1)
                y = 2147483647;
            else
                y = i;
        }else if (dividend > 0 && divisor < 0){
            while (dividend >= (-divisor)){
                dividend = dividend + divisor;
                --i;
            }
            y = i;
        }else {
            while (dividend <= divisor){
                dividend = dividend + divisor;
                --i;
            }
            y = i+2;
        }
        return y;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divide(-2147483648,2));//2147483647
    }
}
