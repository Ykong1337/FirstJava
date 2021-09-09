package com.ftg.learn.chapter21.tree;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MyTree<E> {

    class Node {
        E val;

        Node left;

        Node right;

        public Node(E val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public Node add(Node node, E t1) {
        if (null == node) {
            return new Node(t1);
        }

        Integer val = (Integer) t1;
        Integer nodeVal = (Integer) node.val;

        if (val < nodeVal) {
            node.left = add(node.left, t1);
        } else if (val > nodeVal) {
            node.right = add(node.right, t1);
        } else {
            return node;
        }
        return node;
    }

    public void add(E val) {
        this.root = this.add(this.getRoot(), val);
    }

    public Node getRoot() {
        return root;
    }

    //先序遍历
    public List<E> list = new ArrayList<>();

    public List<E> preOrder(Node t1) {
        if (t1 == null) {
            return null;
        }

        list.add(t1.val);
        preOrder(t1.left);
        preOrder(t1.right);

        return list;
    }

    //中序遍历
    public List<E> list1 = new ArrayList<>();

    public List<E> inOrder(Node t1) {
        if (t1 == null) {
            return null;
        }

        inOrder(t1.left);
        list1.add(t1.val);
        inOrder(t1.right);

        return list1;
    }

    //后序遍历
    public List<E> list2 = new ArrayList<>();

    public List<E> postOrder(Node t1) {
        if (t1 == null) {
            return null;
        }

        postOrder(t1.left);
        list2.add(t1.val);
        postOrder(t1.right);

        return list2;
    }

    public boolean find(Node node, E t1) {
        if (node == null) {
            return false;
        }
        Integer i1 = (Integer) t1;
        Integer i2 = (Integer) node.val;

        if (i1.equals(i2)) {
            return true;
        }
        return i1 > i2 ? find(node.right, t1) : find(node.left, t1);
    }

    public boolean find(E t1){
        return this.find(this.getRoot(),t1);
    }


    @Test
    public void test() {
        MyTree<Integer> m = new MyTree<>();
        m.add(3);
        m.add(1);
        m.add(5);
        m.add(4);
        System.out.println(m.inOrder(m.getRoot()));
        System.out.println(m.find(5));
    }

}
