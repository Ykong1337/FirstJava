package com.ftg.learn.chapter17.factory;

import com.ftg.learn.chapter17.factory.color.ColorFactory;
import com.ftg.learn.chapter17.factory.shape.ShapeFactory;

public class AbstractFactoryProduce {

    public static AbstractFactory getAbstractFactory(FactoryEnum type){
        if (type.equals(FactoryEnum.SHAPE)){
            return new ShapeFactory();
        }else if(type.equals(FactoryEnum.COLOR)){
            return new ColorFactory();
        }
        return null;
    }
}
