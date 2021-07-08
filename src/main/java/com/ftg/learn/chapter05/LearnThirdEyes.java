package com.ftg.learn.chapter05;

import java.util.Scanner;

/**
 *
 *
 * 三个表达式
 */
public class LearnThirdEyes {
    //引用类型

    public char check(int score){
        //文本扫描器
        return score >= 60 ? '过' : '否';
    }

    public void test1 (int score){
        char a  = score < 90? score < 80 ? score <70 ? score < 60 ? '差' : '阅' : '良' : '优' : '牛';
        System.out.println(a);
    }

    public char score1(int score){
        return score < 90 ? score < 80 ? score < 70 ? score < 60 ? '差' : '阅' : '良' : '优' : '牛';
    }

    public void week(int day){

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();

        LearnThirdEyes lte = new LearnThirdEyes();

        lte.test1(score);
    }
}
