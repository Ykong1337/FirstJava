package com.ftg.learn.chapter10;

public class ArrayExpend {
    public int[] as = new int[5];
    public int index = 0;
    //系数
    double flag = 0.75;

    /**
     * 把op存储到as里面
     *
     * @param op
     */
    public void add(int op) {

        int yu = (int) (as.length * flag);
        //局部变量 方法 重新创建
        if (index == yu) {
            //扩容  1.5
            int[] newAs = new int[as.length + (as.length >> 1)];
            //迁移
            for (int i = 0, len = as.length; i < len; i++) {
                newAs[i] = as[i];
            }
            as = newAs;
        }
        as[index++] = op;
    }

    //删除

    /**
     * 按下标删除操作
     *
     * @param ix 下标
     */
    public void del(int ix) {
        if (ix <= index) {
            for (int i = ix; i < as.length - 1; i++) {
                as[i] = as[i + 1];
            }
        }
        index--;
    }

    public int length() {
        return index;
    }

    public void update(int index, int obj) {
        if (index > 0 && index < length()) {
            as[index] = obj;
        }
    }
}
