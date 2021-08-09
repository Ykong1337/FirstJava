package com.ftg.learn.chapter21.queue;

import java.util.NoSuchElementException;
import java.util.Vector;

public class Queue<E> implements MyQueue<E>{

    private Vector<E> obj;

    private int head = 0;

    private int count = 0;

    private int threshold = 20;

    public Queue(){
        this.obj = new Vector();
    }
    public Queue(int capcity){
        this.obj = new Vector(capcity);
    }
    public Queue(int capcity,int increment){
        this.obj = new Vector(capcity,increment);
    }

    @Override
    public boolean add(E t) {
        this.obj.add(t);
        return true;
    }

    @Override
    public E peek() {
        if (this.obj.isEmpty()){
            return null;
        }
        return this.obj.get(head);
    }

    @Override
    public E element() {
        if (this.obj.isEmpty()){
            throw new NoSuchElementException("队列无元素");
        }
        return this.obj.get(head);
    }

    @Override
    public E poll() {
        if (head - this.obj.size() == 0){
            return null;
        }
        E t1 = this.obj.get(head++);
        if (count++ == threshold){
            for (int i = threshold;i >= 0;i--){
                this.obj.remove(i);
            }
            count = 0;
        }
        return t1;
    }
}
