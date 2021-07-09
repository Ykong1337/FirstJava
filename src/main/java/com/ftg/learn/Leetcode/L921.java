package com.ftg.learn.Leetcode;

public class L921 {
    public int minAddToMakeValid(String s) {
        int n = 0,m = 0;
        for(int i = 0;i < s.length();i++){
            if (s.charAt(i) == '('){
                ++n;
            }else{              // 此时是')'
                if (n != 0){    //有'('则消去
                    --n;
                }else{
                    ++m;    //一直无'('另外计算
                }
            }
        }
        return n+m;
    }
}
