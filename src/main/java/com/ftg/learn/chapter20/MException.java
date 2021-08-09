package com.ftg.learn.chapter20;

public class MException extends Exception{
    public MException(EnumEx str){
        super(str.name());
    }
}
