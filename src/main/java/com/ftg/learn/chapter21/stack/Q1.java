package com.ftg.learn.chapter21.stack;

import java.util.Stack;

public class Q1<E> {

    private Stack<E> stack = new Stack();
    private Stack<E> stack2 = new Stack();

    public void push(E val) {
        stack.push(val);
    }

    public E poll() {
        if (stack.isEmpty() && stack2.isEmpty()) {
            return null;
        } else if (stack2.isEmpty()) {
            while (!stack.isEmpty()) {
                stack2.push(stack.pop());
            }
        }
        return stack2.pop();
    }
}
