package com.ftg.learn.chapter16;

import com.ftg.learn.chapter21.stack.IStack;
import com.ftg.learn.chapter21.stack.LinkedStack;
import org.junit.Test;

public class StackTest {

    @Test
    public void test(){
        IStack<String> stack = new IStack();
        stack.push("23345");
        stack.push("aafefg");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.getPop());
    }

    @Test
    public void testlink(){
        LinkedStack<Integer> link = new LinkedStack();
        link.push(154);
        link.push(456);
        System.out.println(link.pop());
        link.push(789);
        link.push(222);
        System.out.println(link.pop());


        System.out.println();
        while (link.haveNext()){
            System.out.println(link.next());
        }
    }
}
