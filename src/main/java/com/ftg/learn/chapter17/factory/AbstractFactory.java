package com.ftg.learn.chapter17.factory;

import com.ftg.learn.chapter17.factory.color.Color;
import com.ftg.learn.chapter17.factory.color.ColorEnum;
import com.ftg.learn.chapter17.factory.shape.Shape;
import com.ftg.learn.chapter17.factory.shape.ShapeEnum;
import org.junit.jupiter.api.Test;

public abstract class AbstractFactory {

    public abstract Color getColorFactory(ColorEnum colorEnum);

    public abstract Shape getShapeFactory(ShapeEnum shapeEnum);

    @Test
    public void test(){
        AbstractFactory af = AbstractFactoryProduce.getAbstractFactory(FactoryEnum.COLOR);
        Color c1 = af.getColorFactory(ColorEnum.GREEN);
        c1.drawColor();
    }
}
