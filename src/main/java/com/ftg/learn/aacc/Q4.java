package com.ftg.learn.aacc;

import com.ftg.learn.chapter15.Abs.A;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Q4 extends Bass {

    public void arr(String[] arr) {
        ArrayList<String> list = new ArrayList<>();
        for (String s : arr) {
            list.add(s);
        }
        int count;
        for (int i = 0; i < list.size(); i++) {
            count = 1;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    ++count;
                    list.remove(j);
                    j--;
                }
            }
            System.out.println("元素" + list.get(i) + "有" + count + "个");
        }
    }

    public Map<String, Integer> Str2(String str) {
        //空的map集合  里面的方法，为了对付那些狗的人
        int len = str.length();
        char[] arr = new char[len];
        for (int i = 0; i < len; i++) {
            arr[i] = str.charAt(i);
        }

        Map<String, Integer> map2 = Collections.EMPTY_MAP;
        if (arr == null) {
            throw new IllegalArgumentException("数组不能为空");
        }
        map2 = new HashMap<>(arr.length >> 1);

        Integer space = 0;
        Integer eng = 0;
        Integer num = 0;
        Integer other = 0;
        for (char obj : arr) {
            if (obj == ' ') {
                map2.put("空格", space++);
            } else if (obj >= 'A' && obj <= 'z') {
                map2.put("英文", eng++);
            } else if (obj >= '0' && obj <= '9') {
                map2.put("数字", num++);
            } else {
                map2.put("其他字符", other++);
            }

        }

        return map2;
    }

    public void count() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == i) {
                    System.out.print(i + 1 + "\t");
                } else if (i - j == 1) {
                    System.out.print(i + 5 + "\t");
                } else if (i - j == 2) {
                    System.out.print(i + 8 + "\t");
                } else if (i - j == 3) {
                    System.out.print(i + 10 + "\t");
                } else if (i - j == 4) {
                    System.out.print(i + 11 + "\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    static int i = 200;

    @Test
    public void test1() {
//        String[] arr = {"1", "23", "23", "4335", "3", "45", "ba", "ba", "a", "t", "a", "t", "t", "t", "b", "123", "3", "4", "5", "6", "1", "2", "3", "4", "56", "78"};
//        new Q4().arr(arr);
//        System.out.println(new Q4().q22(arr));

//        count();

        String s = "alskfjleaeg262+ ";
        Q4 q = new Q4();
        System.out.println(q.Str2(s));
    }


}

class Bass {
    Bass() {
        int i = 100;
        System.out.println(i);
    }
}

