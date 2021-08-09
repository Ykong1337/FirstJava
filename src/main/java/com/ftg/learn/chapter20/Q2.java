package com.ftg.learn.chapter20;


public class Q2 {

    public int ecm(String x, String y) throws MException {
        try {
            Integer.parseInt(x);
            Integer.parseInt(y);
        }catch (NumberFormatException e){
            throw new NumberFormatException("数据类型不一致");
        }

        if (Integer.parseInt(x) < 0 || Integer.parseInt(y) < 0) {
            throw new MException(EnumEx.e_003);
        } else if (Integer.parseInt(y) == 0) {
            throw new ArithmeticException("你除0了");
        }

        try {
            return Integer.parseInt(x) / Integer.parseInt(y);
        }catch (ArrayIndexOutOfBoundsException e){
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void main(String[] args) throws MException {
        System.out.println("输入两个相除的数字");
        System.out.println(new Q2().ecm(args[0], args[1]));
    }
}
