package com.ftg.learn.chapter21.stack;

public class LinkedStack<E> implements MyStack<E> {

    class Node<E> {

        public E value;

        public Node next;

        public Node(E value) {
            this.value = value;
        }
    }

    private int index;
    private Node head;
    private Node last;
    private Node point;

    @Override
    public boolean push(E val) {
        Node curr = new Node(val);
        if (head == null) {
            last = curr;
            head = last;
        } else {
            curr.next = head;
            head = curr;
        }
        point = head;
        ++index;
        return true;
    }

    @Override
    public Object pop() {
        if (index == 0){
            return null;
        }else {
            Object obj = head.value;
            head = head.next;
            point = head;
            --index;
            return obj;
        }
    }

    @Override
    public Object getPop() {
        return index == 0 ? null : this.head.value;
    }

    //输出用两个方法
    public Object next() {
        Object value = point.value;
        point = point.next;
        return value;
    }
    public boolean haveNext() {
        return point == null ? false : true;
    }
}
