package com.ftg.learn.aacc;

import org.testng.annotations.Test;

import java.util.Stack;

public class Kuohao {

    public boolean kuohao(String str) {

        Stack<Character> stack = new Stack<>();
        char[] ch = str.toCharArray();

        for (char c : ch) {
            if (c == '(') {
                stack.push(')');
            }
            if (c == '[') {
                stack.push(']');
            }
            if (c == '{') {
                stack.push('}');
            }

            if (c == ')' || c == ']' || c == '}') {
                if (stack.size() == 0) {
                    return false;
                }
                if (stack.pop() != c) {
                    return false;
                }
            }
        }

        if (stack.size() != 0) {
            return false;
        }

        return true;

    }

    @Test
    public void test() {
        String str = "{}{}";
        System.out.println(new Kuohao().kuohao(str));
    }
}
