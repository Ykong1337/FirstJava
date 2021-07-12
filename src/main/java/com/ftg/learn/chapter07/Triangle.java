package com.ftg.learn.chapter07;

public class Triangle {

    public void printT(int l,int h){
        int n = l/2;
        int m = 0;
        for (int i = 0;i<h;i++) {
            System.out.println();
            if (i<h/2){
                for (int j = 0;j<l;j++){
                    if (j<l/2) {
                        System.out.print("   ");
                    }else{
                        if (j>n){
                            System.out.print("   ");
                        }else {
                            System.out.print("*  ");
                        }
                    }
                }
            }else {
                for (int k = 0;k<l;k++){
                    if (k>=l/2){
                        System.out.print("   ");
                    }else{
                        if (k<m){
                            System.out.print("   ");
                        }else {
                            System.out.print("*  ");
                        }
                    }
                }
                m++;
            }
            n++;
        }
    }

    public void printT2(){
        int len = 9;
        for (int i = 0;i<len/2;i++){
            for (int j = 0;j<len/2;j++){
                if (i<=len/2-j-1){
                    System.out.print("*  ");
                }else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0;i<len/2;i++){
            for (int j = 0;j<len/2;j++){
                if (i>=j){
                    System.out.print("*  ");
                }else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0;i<len/2;i++){
            for (int j = 0;j<len/2;j++){
                if (i<=j){
                    System.out.print("*  ");
                }else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0;i<len/2;i++){
            for (int j = 0;j<len/2;j++){
                if (i>=len/2-j-1){
                    System.out.print("*  ");
                }else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0;i<len;i++){
            for (int j = 0;j<len;j++){
                if (i == len - j - 1 || i == j){
                    System.out.print("*  ");
                }
                else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0;i<len;i++){
            System.out.println();
            for (int j = 0;j<len/2;j++){
                if(i == j*2){
                    System.out.print("*  ");
                }else {
                    System.out.print("   ");
                }

            }
            for (int j = len/2+1;j<len+1;j++){
                if (i == (len - j)*2){
                    System.out.print("*  ");
                }else {
                    System.out.print("   ");
                }
            }
        }
    }
}
