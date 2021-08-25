package com.ftg.learn.chapter21.expand;

public class AgeIfruleImple<E> implements IfRule<E> {
    @Override
    public boolean test(E t) {
        return ((Student)t).getName().startsWith("张");
    }
}
