package com.zenq.oop3;


//面向对象三大特性：封装、继承、多态

/*

万物皆对象：object 为所有java类的父类，被默认继承

* */

public class Demo03 {
    public static void main(String[] args) {
//        为什么自己能实例化自己呢？
        Demo03 demo03 = new Demo03();
//        例如下面这个tostring方法就是object的方法
        demo03.toString();

//        这里体现继承
        Son son = new Son();
        System.out.println("son的name："+son.name);
        son.makeMoney();
    }
}
