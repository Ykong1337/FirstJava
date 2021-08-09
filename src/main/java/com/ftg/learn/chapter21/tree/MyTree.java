package com.ftg.learn.chapter21.tree;

import org.testng.annotations.Test;

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

    public void add(E val){
        this.root = this.add(this.getRoot(),val);
    }

    public Node getRoot() {
        return root;
    }


    @Test
    public void test() {
        MyTree<Integer> m = new MyTree<>();
        m.add(3);
        m.add(1);
        m.add(5);
        m.add(4);
    }

}
