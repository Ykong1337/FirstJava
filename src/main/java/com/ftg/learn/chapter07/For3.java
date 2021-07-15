package com.ftg.learn.chapter07;

public class For3 {

    public void For5(){
        int len = 9;
        for (int i = 0;i<=len/2+1;i++){
            for (int j = 0;j<len/2+i;j++){
                if (j>len/2-i) {
                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public void For6(){
        int len = 9;
        for (int i = 0;i<=len/2 ;i++){
            for (int j = 0;j<len-i;j++){
                if (j<i){
                    System.out.print("  ");
                }else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    public void For7(){
        int len = 9;
        for (int i = 0;i<=len/2;i++){
            for (int j = 0;j<len/2+i;j++){
                if (j>len/2-i) {
                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        for (int i = 0;i<=len/2 ;i++){
            for (int j = 0;j<len-i;j++){
                if (j<i){
                    System.out.print("  ");
                }else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    public void For8(){
        For5();
        For6();
    }

    public void For9(){
        int len = 9;
        for (int i = 0;i<len/2+1;i++){
            for (int j = 0;j<len/2+i+1;j++){
                if (j>len/2-i-1){
                    if (i%2 == 0 && j%2 != 0){
                        System.out.print(" ");
                    }else if (i%2 != 0 && j%2 == 0){
                        System.out.print(" ");
                    }else {
                        System.out.print("*");
                    }

                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i = 0;i<len/2;i++){
            for (int j = 0;j<len-i-1;j++){
                if (j>i){
                    if (i%2 != 0 && j%2 != 0){
                        System.out.print(" ");
                    }else if (i%2 == 0 && j%2 == 0){
                        System.out.print(" ");
                    }else {
                        System.out.print("*");
                    }
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void For10(){
        int len = 9;
        for (int i = 0;i<len/2+1;i++){
            for (int j = 0;j<len/2+1;j++){
                if (j<i+1){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        for (int i = 0;i<len/2;i++){
            for (int j = 0;j<len/2;j++){
                if (j<len/2-i){
                    System.out.print("*");
                }

            }
            System.out.println();
        }
    }

    public void For11(){

        for (int i = 0;i<5;i++){
            for (int j = 0;j<9;j++){
                if (j<5-i-1 || j>9-i-1){
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }

    }


    public void For13(){
        for (int i = 0;i<5;i++){
            for (int j = 1;j<=5;j++){
                if (j<=i+1){
                    System.out.print(j+i + " ");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public void For14(){
        int n = 1;
        int k = 5;
        for (int i = 1;i<=24;i++){
            if (n%2 != 0){
                System.out.print(i + "  ");
            }else {
                System.out.print(i + k + "  ");
                k-=2;
            }
            if (i%(6*n) == 0){
                System.out.println();
                k = 5;
                n++;
            }
        }
    }


    public int jumpFrog(int high,int jump,int down){
        int no = 0;
        int now = 0;

        if (high <= jump){
            return 1;
        }
        if (jump <= down){
            return 0;
        }

        while (now < high){
            now += jump;
            ++no;
            if (now >= high){
                break;
            }else {
                --now;
            }
        }

        return no;
    }


    public void Test11(){
        int[] x = { 125, 21, 5, 168, 98 };
        int max = x[0];
        for (int i = 1; i < x.length; i++) {
            if (x[i] > max)
                max = x[i];
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        String strValue = "ABCDEFG";
        String str0 = strValue.substring(3);
        System.out.println("0--->" + str0);
        String str1 = strValue.concat("123");
        System.out.println("1--->" + str1);
        System.out.println("2--->" + strValue);
        String value = "ABCDEFG";
        System.out.println("3->"  + (strValue == value));


    }




}

