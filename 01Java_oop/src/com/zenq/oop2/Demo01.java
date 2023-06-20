/*
 * 普通成员
 * 属性
 * 方法
 * 静态成员
 * 静态属性
 * 静态方法
 * 静态：static修饰的对象

 * 访问普通成员
 *  对象.属性
 *
 * 静态成员访问：   所有对象的公共属性
 * 类.属性      建议使用类来统一访问
 * 对象.属性
 * 静态成员不需要创建对象即可使用
 * */
package com.zenq.oop2;

public class Demo01 {
    public static void main(String[] args) {
        Hero2.method();
        System.out.println("类.属性："+Hero2.address);
        Hero2 hero2 = new Hero2();
        System.out.println("对象.属性：" + hero2.address);
        hero2.method();

    }
}
