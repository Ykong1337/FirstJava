package com.ftg.learn.chapter16;

import com.ftg.learn.chapter16.cett.Cat;
import com.ftg.learn.chapter16.cett.Master;
import com.ftg.learn.chapter16.cett.Mouse;
import org.junit.Test;

public class CatMouseTest {

    @Test
    public void test() {
        Master master = new Master("老张","在家里");
        Cat cat = new Cat("tom");
        Mouse mouse = new Mouse("jerry");

        System.out.println(cat.getName()  + master.getSpace() + cat.play());
        System.out.println(mouse.getName()  + master.getSpace() + mouse.play());

        System.out.println(mouse.getName() + mouse.hate() + cat.getName());
        System.out.println(cat.getName() + cat.hate());

    }
}
