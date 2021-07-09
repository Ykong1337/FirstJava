package com.ftg.learn.Leetcode;

public class L476 {
    public int findComplement(int num) {
        if(num == 0)
            return 1;
        int[] two = new int[32];
        int i = 0;
        int sum = 0;
        while (num > 0){
            two[i] = num % 2;
            num /= 2;
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
}
