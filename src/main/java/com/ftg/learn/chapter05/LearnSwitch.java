package com.ftg.learn.chapter05;

/**
 *
 *
 *
 */
public class LearnSwitch {
    //一个变量多种值

    /**
     * 判断星期几的方法
     * @param n
     */
    public void cheakWeek(int n){
        switch (n){
            case 0:
                System.out.println("星期日");
                break;
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
                System.out.println("星期六");
                break;
            default:
                System.out.println("不是日期格式");
        }
    }
}
