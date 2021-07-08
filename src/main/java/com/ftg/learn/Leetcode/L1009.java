package com.ftg.learn.Leetcode;

public class L1009 {
    public int bitwiseComplement(int n) {
        if(n == 0)
            return 1;
        int[] two = new int[32];
        int i = 0;
        int sum = 0;
        while (n > 0){
            two[i] = n % 2;
            n /= 2;
            i++;
        }
        int t = i;
        for (int j = i-1 ;j>=0;j--){
            if (two[j] == 1){
                two[j] = 0;
                continue;
            }
            if (two[j] == 0){
                two[j] = 1;
            }
        }
        for(int k = 0;k < t;k++)
        {
            if(two[k] == 1)
                sum+=Math.pow(2,k);
        }
        return sum;
    }

    public static void main(String[] args) {
        L1009 l = new L1009();
        int x = l.bitwiseComplement(5);
        System.out.println(x);
    }
}
