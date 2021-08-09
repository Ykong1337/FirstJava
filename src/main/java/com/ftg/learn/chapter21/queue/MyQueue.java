package com.ftg.learn.chapter21.queue;

public interface MyQueue<E> {

    boolean add(E t);


    /**
     * 返回队首  不删除
     * 空队列返回null
     * @return
     */
    E peek();

    /**
     *返回队首  不删除
     * 空返回  nu such
     * @return
     */
    E element();

    /**
     *
     * 返回队首  删除
     *
     * @return
     */
    E poll();

}
