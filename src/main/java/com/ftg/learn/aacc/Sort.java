package com.ftg.learn.aacc;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sort {

    public int[] sort(int[] a, int[] b) {
        int alen = a.length;
        int blen = b.length;
        int[] c = new int[alen + blen];

        List<Integer> l = new LinkedList<>();

        for (int i = 0; i < alen; i++) {
            c[i] = a[i];
        }
        for (int i = alen, j = 0; i < c.length; i++, j++) {
            c[i] = b[j];
        }
        Arrays.sort(c);
        return c;
    }


    @Test
    public void test() {
        Sort s = new Sort();
        int[] a = {1, 6, 8, 9, 10};
        int[] b = {1, 5, 7, 11, 15};
        int[] c = s.sort(a, b);
        for (int x : c) {
            System.out.print(x+"\t");
        }
    }
}
