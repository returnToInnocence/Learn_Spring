package com.zenq.oop3;


/*

继承关键字 extends   单继承多实现
多实现     接口
父类成员和方法的引用：super
当前类对象的引用：this
子类可以继承父类，获取父类的属性和方法
子类也可以覆盖父类的属性和方法
重写：子类覆盖父类的方法
重载：一个类中多个方法的方法名一样，参数不一样

* */
public class Son extends Father{

    String name = "s";

//    重写
    public void makeMoney(){
        System.out.println("计算机工程师赚钱");
    }

    public void printDesc(){
        System.out.println("打印父亲名字"+super.name);
        System.out.println("打印儿子名字"+this.name);
    }

//    重载
    public void printDesc(String msg){
        System.out.println("重载，有参数："+msg);
    }

    public static void main(String[] args) {
//        Son son = new Son();
//        System.out.println("son的name："+son.name);
//        son.makeMoney();
//
//        Father f = new Son();
//        f.makeMoney();

        //多态开始体现
        Father father = new Son();
        Father father1 = new Gril();
        printMk(father);
        printMk(father1);
//        父类的属性，方法可以是子类重写的
        System.out.println(father.name);
        System.out.println(father1.name);
    }

    public static void printMk(Father father){
        father.makeMoney();
    }
}
