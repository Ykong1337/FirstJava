package com.ftg.learn.chapter17.factory.color;

import com.ftg.learn.chapter17.factory.AbstractFactory;
import com.ftg.learn.chapter17.factory.shape.Shape;
import com.ftg.learn.chapter17.factory.shape.ShapeEnum;

public class ColorFactory extends AbstractFactory {

    @Override
    public Color getColorFactory(ColorEnum colorEnum) {
        if (colorEnum.equals(ColorEnum.GREEN)){
            return new Green();
        }else if(colorEnum.equals(ColorEnum.YELLOW)){
            return new Yellow();
        }
        return null;
    }

    @Override
    public Shape getShapeFactory(ShapeEnum shapeEnum) {
        return null;
    }
}
