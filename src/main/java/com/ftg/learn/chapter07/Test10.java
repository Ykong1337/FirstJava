package com.ftg.learn.chapter07;

public class Test10 {

    int a = 10;
    int b = 22;
    public void switch1(){
        int c;
        c = a;
        a = b;
        b = c;
        System.out.println(a +" " + b);
    }


    public void Switch11(){
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a + " " + b);
    }
    public void Switch11_2(){
        //int a = 10;
        //    int b = 22;
        a=a*b;
        b=a/b;
        a=a/b;

        System.out.println(a + " " + b);

    }

    public void frogJump(){
        int no = 0;
        int now = 1;

        while (no<30) {
            if (now == 1) {
                for (int i = 0; i < 6; i++) {
                    ++now;
                    ++no;
                    if (no >= 30) {
                        break;
                    }
                }
            }else if(now == 7){
                for (int j = 0;j < 6; j++){
                    --now;
                    ++no;
                    if (no >= 30){
                        break;
                    }
                }
            }
        }
        System.out.println(now);

    }

    public void nine(){

        for (int i = 1;i<=9;i++){
            for (int j = 1;j<=i;j++){
                int x = i * j;
                System.out.print(i+"*"+j+"="+x + "   ");
            }
            System.out.println();
        }

    }

    public void questLast(){
        for(int i = 1;i < 10;i++){
            for(int j = 1,jlen=10;j < jlen;j++){
                if(i<=jlen>>1 ){
                    if(j<=i ){
                        System.out.print(j + " ");
                    }else if(j > jlen-i){
                        System.out.print(jlen-j + " ");
                    }else{
                        System.out.print(i + " ");
                    }
                }else{
                    if(j < jlen+1-i){
                        System.out.print(j + " ");
                    }else if(j > i){
                        System.out.print(jlen-j + " ");
                    }else{
                        System.out.print(jlen-i + " ");
                    }
                }
            }
            System.out.println();
        }
    }


    public void nineP(){
        int t = 1;
        for (int i = 1;i<=9;i++){
            for (int j = 1;j<=9;j++){
                if (j>=i){
                    System.out.print(t + "  ");
                }else {
                    System.out.print(1 + "  ");
                }

            }
            t++;
            System.out.println();
        }


    }


}
