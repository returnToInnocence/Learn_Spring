package com.zenq.oop;

//面向对象学习
/*
Java中的变量分类：
*   基本数据类型：8种
        1       2       4       8
        byte    short   int     long
        boolean char    floot   double
    引用数据类型:
        String
        自定义类
*
类创建对象：
    - new 关键字
    - new + 对应类的构造方法（即函数）
    - 构造方法，创建对象时调用
        - 每个类中默认有一个隐藏的构造方法 —— 甚至没有返回值标志，即没有返回值类型
        - 创建对象时可以对对象进行初始化

看out中反编译的class文件反编译内容

类中包含需要描述的对象“有什么”and“能做什么”

对象中属性和方法的访问
    对象.属性
    对象.方法

类和对象的关系
类表示一个类型：一个抽象描述
对象表示一个具体的实例

this 当前类的引用
* */
public class Demo01 {
    public static void main(String[] args) {
        Hero liubei = new Hero();
        System.out.println(liubei.name);
        System.out.println(liubei.hp);
        System.out.println(liubei.mp);
        liubei.skill1();

        Hero zhangfei = new Hero("张飞", 1000, 2000);
        System.out.println(zhangfei);
    }
}
