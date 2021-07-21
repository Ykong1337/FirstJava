package com.ftg.learn.aacc;
import java.util.Scanner;

public class TestDrawCards {
    public static void main(String[] args) {
        OriginalGodDrawCards d1 = new OriginalGodDrawCards();

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您需要进行的十连抽卡次数[int类型]: ");
        int times = scanner.nextInt();

        for (int i = 1; i <= times; i++) {
            System.out.println("这是您的第" + i + "次十连抽卡: ");
            int degree = d1.drawCard();

            //换行
            System.out.println();

            if (i == times) {
                System.out.println("抽卡结束！本次抽卡累计获取ssr" + (degree-1) + "只");
            }
        }
    }
}