package com.ftg.learn.Leetcode;

import org.testng.annotations.Test;

public class L1894 {

    public int chalkReplacer(int[] chalk, int k) {

        int i=0;
        int len=chalk.length;
        int count=0;
        for (int j = 0; j < chalk.length; j++) {
            count+=chalk[j];
            if(count>k)
                return j;
        }
        k%=count;
        while(true) {
            k-=chalk[i];
            if(k<0)
                return i;
            i++;
        }
    }

    @Test
    public void test() {
        System.out.println(new L1894().chalkReplacer(new int[]{3,4,1,2}, 25));
    }
}
