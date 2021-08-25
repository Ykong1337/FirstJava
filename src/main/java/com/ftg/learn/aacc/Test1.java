package com.ftg.learn.aacc;


import javafx.scene.effect.SepiaTone;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Test1 {

    public int day(String date) {
        String[] date1 = date.split("-");

        int year = Integer.parseInt(date1[0]);
        int month = Integer.parseInt(date1[1]);
        int day = Integer.parseInt(date1[2]);

        if (year % 4 == 0 || year % 100 != 0) {
            switch (month) {
                case 1:
                    return day;
                case 2:
                    return 31 + day;
                case 3:
                    return 60 + day;
                case 4:
                    return 91 + day;
                case 5:
                    return 121 + day;
                case 6:
                    return 152 + day;
                case 7:
                    return 182 + day;
                case 8:
                    return 213 + day;
                case 9:
                    return 244 + day;
                case 10:
                    return 274 + day;
                case 11:
                    return 305 + day;
                default:
                    return 335 + day;
            }
        } else {
            switch (month) {
                case 1:
                    return day;
                case 2:
                    return 31 + day;
                case 3:
                    return 59 + day;
                case 4:
                    return 90 + day;
                case 5:
                    return 120 + day;
                case 6:
                    return 151 + day;
                case 7:
                    return 181 + day;
                case 8:
                    return 212 + day;
                case 9:
                    return 243 + day;
                case 10:
                    return 273 + day;
                case 11:
                    return 304 + day;
                default:
                    return 334 + day;
            }
        }
    }

    public List<Integer> list(List<Integer> list) {

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) == list.get(j)) {
                    list.remove(j);
                    j--;
                }
            }
        }
        return list;
    }

    public Set<Integer> set(List<Integer> list) {

        Set<Integer> set = new HashSet<>();
        for (Integer i : list) {
            set.add(i);
        }
        return set;
    }

    public void num() {
        int num = 0;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                for (int k = 1; k <= 4; k++) {
                    if (i == j || i == k || j == k){

                    }else {
                        num++;
                        System.out.println(i*100+j*10+k);
                    }
                }
            }
        }
        System.out.println("共有" + num + "个");
    }

    public void Str(String str) {
        int len = str.length();
        int space = 0;
        int eng = 0;
        int num = 0;
        int other = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                space++;
            } else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'z') {
                eng++;
            } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                num++;
            } else {
                other++;
            }
        }
        System.out.println("空格有" + space + "个");
        System.out.println("英文有" + eng + "个");
        System.out.println("数字有" + num + "个");
        System.out.println("其他字符有" + other + "个");
    }

    public static void main(String[] args) {
        String date = "2021-08-14";
        System.out.println(new Test1().day(date));

        new Test1().Str(date);

        List<Integer> arr = new ArrayList<>();
        arr.add(11);
        arr.add(34);
        arr.add(23);
        arr.add(11);
        arr.add(55);
        System.out.println(new Test1().set(arr));
        new Test1().num();

    }

    @Test
    public void t1(){
        int total = 0;
        for(int i = 0,j=10;total>30;++i,--j){
            System.out.println("i=" + i + ":j=" + j);
            total+=(i+j);
        }
        System.out.println(total);
    }

}

class TE{

    public TE(){}
    int m = 5;
    public void some(int x){
        m=x;
    }
    int $123;
    int mySql;

    public static void main(String[] args) {
        new Demo().some(7);
    }
}

class Demo extends TE{
    int m = 8;
    public void some(int x){
        super.some(x);
        System.out.println(m);
    }
}


