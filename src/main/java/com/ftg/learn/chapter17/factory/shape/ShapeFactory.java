package com.ftg.learn.chapter17.factory.shape;

import com.ftg.learn.chapter17.ShapeType;
import com.ftg.learn.chapter17.factory.AbstractFactory;
import com.ftg.learn.chapter17.factory.color.Color;
import com.ftg.learn.chapter17.factory.color.ColorEnum;
import org.junit.jupiter.api.Test;

public class ShapeFactory extends AbstractFactory {

    @Override
    public Color getColorFactory(ColorEnum type) {
        return null;
    }

    @Override
    public Shape getShapeFactory(ShapeEnum type) {
        if (type.equals(ShapeType.cat)){
            return new Cat();
        }else if(type.equals(ShapeType.dog)){
            return new Dog();
        }else {
            return null;
        }
    }
}
