package com.ftg.learn.chapter21.stack;

import java.util.Vector;

public class IStack<E> implements MyStack<E> {

    private Vector<E> obj;

    private int index;

//    private int increment;

    private final int default_size = 10;

    public IStack() {
        this.obj = new Vector(default_size, 1);
    }

//    public IStack(int capcity) {
//        if (capcity < 0) {
//            throw new IllegalArgumentException("参数不合法");
//        }
//        this.obj = new Vector(capcity, 1);
//    }
//
//    public IStack(int capcity, int increment) {
//        if (capcity <= 0) {
//            throw new IllegalArgumentException("参数不合法");
//        }
//        this.obj = new Vector(capcity, 1);
//        this.increment = increment;
//    }

    /**
     * 满了  扩容
     *
     * @param val
     * @return
     */
    @Override
    public boolean push(E val) {
        this.obj.add(index++, val);
        return true;
    }

    @Override
    public Object pop() {
        return index == 0 ? null : this.obj.get(--index);
    }

    @Override
    public Object getPop() {
        return index == 0 ? null : this.obj.get(index - 1);
    }
}