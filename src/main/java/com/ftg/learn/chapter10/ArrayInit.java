package com.ftg.learn.chapter10;

public class ArrayInit {

    public void moveValue(int[] arr, int begin, int end) {

        //如果end大于数组长度，end置为数组长度
        if (begin > end){
            int c = begin;
            begin = end;
            end = c;
        }

        if (end >= arr.length) {
            end = arr.length - 1;
        }
        //如果begin小于0，begin置为0
        if (begin < 0) {
            begin = 0;
        }

        //初始化数组长度为begin到end共计个数
        int[] rearr = new int[end - begin + 1];

        //循环赋值
        for (int i = begin, j = 0; i < end + 1; i++, j++) {
            rearr[j] = arr[i];
        }

        for (int x : rearr) {
            System.out.print(x + "\t");
        }
    }

    public int[] moveVal(int[] arr, int target) {
        //自己分析下，如果 target - 数时反向迁移
        //如果 方法是 Arr begin end
        int c = target;
        if (target < 0) {
            if (target < -(arr.length)) {
                target = arr.length;
            } else {
                target = -target;
            }
        }

        int[] reArr = new int[target > arr.length ? arr.length : target];
        if (c < 0) {

            for (int i = 0, len = reArr.length, j = arr.length - target; i < len; i++, j++) {
                reArr[i] = arr[j];
            }


        } else {
            for (int i = 0, len = reArr.length; i < len; i++) {
                reArr[i] = arr[i];
            }
        }

        for (int x : reArr) {
            System.out.print(x + "\t");
        }
        return reArr;
    }


}
