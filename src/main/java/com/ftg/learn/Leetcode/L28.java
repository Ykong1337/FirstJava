package com.ftg.learn.Leetcode;

public class L28 {
    public int strStr(String haystack, String needle) {
    int okCount = -1;
    if(haystack.equals("") && needle.equals(""))
        return 0;
    int haystackL = haystack.length();
    int needleL = needle.length();
    int count = haystackL - needleL + 1;
    for(int i = 0;i<count;i++){
        int hayIndex = i;
        int lastIndex = 0;

        for(int j = 0;j<needleL;j++){
            if(haystack.charAt(hayIndex++) != needle.charAt(j)){
                break;
            }else{
                lastIndex++;
            }
        }
        if(lastIndex == needleL){
            okCount = i;
            break;
        }
    }
    return okCount;
    }
}