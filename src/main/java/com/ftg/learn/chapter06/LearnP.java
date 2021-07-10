package com.ftg.learn.chapter06;

public class LearnP {

    public void no1() {
        for (int i = 1, j = 0, max = 3; i < max * 2; i++) {
            if (i < max) {
                System.out.print(i + " ");
            } else {
                j++;
                System.out.print(max - j + 1 + " ");
            }
        }
    }

    public void no2(int num) {
        for (int i = num; i < 100; i++) {
            if (i % num == 0) {
                System.out.print(i + " ");
            }
        }
    }

    public void no3() {
        for (int i = 7; i < 100; i++) {
            int c = i % 10;
            int b = i / 10;
            if (i % 7 == 0 || (c == 7 || b == 7)) {
                System.out.println(i);
            }
        }
    }

    public void no4(int num) {
        int x = 64;
        if (num == x) {
            System.out.println("一致");
        } else {
            System.out.println("不一致");
        }
    }

    public void for1() {
        double high = 100;
        double s = high;
        for (int i = 0; i < 9; i++) {
            high = high / 2;
            s = s + high * 2;
        }
        System.out.println(s);
    }

    public int for2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        } else {
            return for2(n - 1) + for2(n - 2);
        }
    }

    public void for3(int x) {
        int c;
        int i;

        for (i = 0; x > 0; i++) {
            c = x % 10;
            x /= 10;
            System.out.println("每一位为：" + c);
        }
        System.out.println("一共有" + i + "位");
    }

    public void for4() {
        int sum = 0 ;
        for(int i=1 ; i<=10 ; i++)
            sum+=i;
        System.out.println(sum);
    }
}

