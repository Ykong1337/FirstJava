package com.ftg.learn.chapter03;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class LearnDight {
    public static void main(String[] args) {

        int x = 4321;
        System.out.println("个位:" + x%10);
        System.out.println("十位:" + x/10%10);
        x=x/10;
        System.out.println("百位:" + x/10%10);
        x=x/10;
        System.out.println("千位:" + x/10);


        int father = 177;
        int mother = 165;
        double son = (father + mother) * 1.08 / 2;
        double daughter = (father * 0.923 + mother) / 2;
        System.out.println("儿子:" + son);
        System.out.println("女儿:" + daughter);

        int red = 21;
        int nowr = red * 2 + 3;
        int green = 24;
        int nowg = green * 2;
        System.out.println(nowr);
        System.out.println(nowg);

        int fish = 24;
        int peanut = 8;
        int rice = 3;
        char c1 = 'a';
        char c2 = 'b';

        double a = (fish + peanut + rice) * 0.8;
        double b = 16 + peanut + rice;

        System.out.println((a < b) ? c1 : c2 + " " + b);

        short price = 100;
        short realPrice = (short) (price * 8 / 10);
        System.out.println(realPrice);



    }
}
