package com.ftg.learn.Leetcode;

public class L7 {
    public int reverse(int x) {
        int n [] = new int[10];
        int c = 0;
        long m = 0;
        int i = 0;
        if (x < 0){
            c = -x;
        }else {
            c = x;
        }
        for (i = 0;c>0;i++){
            n[i] = c%10;
            c = c/10;
        }
        for (int j = i-1,k = 0;j>=0;j--,k++){
            m = (long) (m + n[k]*Math.pow(10,j));
        }
        if (m>2147483647 || m<-2147483648){
            return 0;
        }
        if(x<0){
            m = (int)-m;
        }
        return (int)m;
    }
}
