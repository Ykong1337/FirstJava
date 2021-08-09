package com.ftg.learn.chapter20;

public enum EnumEx {

    e_001{
        public String e001(){
            return "数字长度过大";
        }
    },
    e_002{
        public String e002(){
            return "数字长度过小";
        }
    },
    e_003{
        public String e003(){
            return "不能输入负数";
        }
    }
}
