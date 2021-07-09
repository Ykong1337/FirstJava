package com.ftg.learn.chapter05;

import java.util.Scanner;

public class Test {

    public void notice(int speed){
        if (speed > 100 && speed < 120){
            System.out.println("车辆超速");
        }else if (speed > 120){
            System.out.println("警告");
        }else if (speed > 80 && speed < 100){
            System.out.println("奖励");
        }else {
            System.out.println("不是有效速度");
        }
    }

    public void person(double rmb){
        double s;
        if (rmb <= 1500){
            s = 0;
        }else if (rmb > 1500 && rmb <= 4500){
            if (rmb > 3500){
                s = (rmb - 3500) * 0.03;
            }else{
                s = 0;
            }
        }else if (rmb > 4500 && rmb <= 9000){
            s = (rmb - 3500) * 0.2 - 555;
        }else if (rmb > 9000 && rmb <= 35000){
            s = (rmb - 3500) * 0.25 - 1005;
        }else if (rmb > 35000 && rmb <= 55000){
            s = (rmb - 3500) * 0.3 - 2755;
        }else if (rmb > 55000 && rmb <= 80000){
            s = (rmb - 3500) * 0.35 - 5505;
        }else {
            s = (rmb - 3500) * 0.45 - 13505;
        }
        System.out.println(s);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rmb = sc.nextInt();
        Test t = new Test();
        t.person(rmb);

    }
}
