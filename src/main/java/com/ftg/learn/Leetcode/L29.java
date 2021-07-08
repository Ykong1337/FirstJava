package com.ftg.learn.Leetcode;

public class L29 {
    public int divide(int dividend, int divisor) {
        if (dividend == -2147483648 && divisor == -1)
            return 2147483647;
        else
            return dividend / divisor;
    }

    public static void main(String[] args) {
        L29 l = new L29();
        int x = l.divide(10,7);
        System.out.println(x);
    }
}
