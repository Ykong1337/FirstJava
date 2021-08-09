package com.ftg.learn.chapter21.linked;

public class MyLinked {

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

    /**
     * 创建元素
     *
     * @param value
     */
    public MyLinked(int value) {
        Node curr = new Node(value);
        head.next = curr;
        last = curr;
    }

    public MyLinked() {

    }

    /**
     * 只有一个头结点
     */

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
    /**
     * 头结点的值
     *
     * @return
     */
    public int getHead() {
        return this.head.value;
    }

    /**
     * 尾节点的值
     *
     * @return int
     */
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

        while (point1.next != null){
            while (point2.next != null){
                point2 = point2.next;
                if (point1 == point2){
                    return true;
                }
            }
            point1 = point1.next;
        }
        return false;
    }
}
