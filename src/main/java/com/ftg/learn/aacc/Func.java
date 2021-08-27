package com.ftg.learn.aacc;

@FunctionalInterface
public interface Func<E,T> {

    T count(E x,E y);
}
