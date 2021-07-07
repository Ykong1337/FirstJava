package com.ftg.learn.chapter03;

/**
 * @author YKONG
 *
 */
public class LearnMethodJunit {
    /**
     *
     * @param starNum
     */
    public static void printStar(int starNum){
        for (int i = 1;i<starNum;i++){
            for (int j = 1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        printStar(9);
        printStar(8);
        printStar(7);
        printStar(6);
    }
}
