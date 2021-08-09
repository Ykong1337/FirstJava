package com.ftg.learn.chapter16;

import com.ftg.learn.chapter21.linked.MyLinked;
import org.junit.Test;

public class LinkTest {

    @Test
    public void test(){
        MyLinked m = new MyLinked();
        m.add(0);
        m.add(1);
        m.add(2);
        m.add(3);

        m.insert(0,7);
        m.remove(4);

        while (m.haveNext()){
            System.out.println(m.next());
        }

        System.out.println();
        System.out.println(m.size());
        System.out.println(m.linkRing());
    }
}
