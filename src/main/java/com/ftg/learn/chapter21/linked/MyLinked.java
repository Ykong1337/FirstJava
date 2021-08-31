package com.ftg.learn.chapter21.linked;

import org.testng.annotations.Test;

public class MyLinked {

    private static MyLinked instance = new MyLinked();
    private MyLinked (){}
    public static MyLinked getInstance() {
        return instance;
    }

    class Node {

        public int value;

        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node last;
    private Node point;


    public void add(int val) {
        Node curr = new Node(val);

        if (head == null) {
            head = curr;
            last = head;
            point = head;
        } else {
            last.next = curr;
            last = last.next;
        }
    }

    public int next() {
        int value = point.value;
        point = point.next;
        return value;
    }
    public boolean haveNext() {
        return point == null ? false : true;
    }

    public int getHead() {
        return this.head.value;
    }

    public int getLast() {
        return this.last.value;
    }

    public int size() {
        point = head;
        int i = 0;
        while (haveNext()) {
            point = point.next;
            i++;
        }
        return i;
    }

    public boolean insert(int index, int val) {
        Node curr = new Node(val);
        point = head;
        if (index < 0){
            throw new NullPointerException();
        }
        if (index == 0) {
            curr.next = head;
            head = curr;
        } else {
            int i = 0;
            while (i < index - 1) {
                point = point.next;
                i++;
            }
            curr.next = point.next;
            point.next = curr;
        }
        point = head;
        return true;
    }

    public boolean remove(int index) {
        point = head;
        if (index == 0){
            head = head.next;
        }else {
            int i = 0;
            while (i < index - 1) {
                point = point.next;
                i++;
            }
            point.next = point.next.next;
        }
        point = head;
        return true;
    }

    public boolean linkRing(){
        Node point1 = head;
        Node point2 = head;

        while (point2 != null && point2.next != null){

            point1 = point1.next;
            point2 = point2.next.next;

            if (point1 == point2){
                return true;
            }
        }
        return false;
    }


    @Test
    public void test(){
        MyLinked.getInstance().add(0);
        MyLinked.getInstance().add(1);
        MyLinked.getInstance().add(2);
        MyLinked.getInstance().add(3);

        MyLinked.getInstance().insert(0,7);
        MyLinked.getInstance().remove(4);

        while (MyLinked.getInstance().haveNext()){
            System.out.println(MyLinked.getInstance().next());
        }

        System.out.println("size = " + MyLinked.getInstance().size());
        System.out.println("有环？" + MyLinked.getInstance().linkRing());
    }
}
