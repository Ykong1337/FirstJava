package com.ftg.learn.chapter06;

public class LearnP {

    public void no1(){
        for (int i = 1,j = 0,max = 3 ;i < max * 2 ;i++){
            if (i < max){
                System.out.print(i + " ");
            }else{
                j++;
                System.out.print(max - j + 1 + " ");
            }
        }
    }

    public void no2(int num){
        for (int i = num ;i < 100 ;i++){
            if (i % num == 0){
                System.out.print(i + " ");
            }
        }
    }

    public void no3(){
        for (int i = 7 ;i < 100 ;i++){
            int c = i % 10;
            int b = i / 10;
            if (i % 7 == 0  || (c == 7 || b == 7)){
                System.out.println(i);
            }
        }
    }

    public void no4(int num){
        int x = 64;
        if (num == x){
            System.out.println("一致");
        }else {
            System.out.println("不一致");
        }
    }

    public static void main(String[] args) {
        new LearnP().no4(59);
    }

}
