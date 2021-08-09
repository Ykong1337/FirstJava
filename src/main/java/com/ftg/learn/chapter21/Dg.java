package com.ftg.learn.chapter21;

import org.junit.jupiter.api.Test;

import java.io.File;

public class Dg {

    public int add(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + add(n - 1);
        }
    }

    public void cFile(File t){
        File f = new File("D:\\");
        File[] fs = f.listFiles();
        for (File f1 : fs){
            if (f1.isFile()){
                System.out.println(f1.getName());
            }else {

            }
        }
    }

    @Test
    public void test(){

        System.out.println(new Dg().add(100));
    }
}
