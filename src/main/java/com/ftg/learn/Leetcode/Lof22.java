package com.ftg.learn.Leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Lof22 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode curr = head;
        ListNode t = head;
        int count = 1;
        while (curr.next != null) {
            count++;
        }

        for (int i = 0, len = count - k; i < len; i++) {
            t = t.next;
        }

        return t;
    }
}
