package com.zenq.oop4;


/*
实现类就意味着继承了接口中的方法
因为类中不允许有抽象方法
所以实现接口的类要么实现接口中的方法，要么把自己变成抽象类
抽象类就是可以拥有抽象方法or具体方法的类   abstract
单继承 extend
多实现 implements
* */
public class Demo04 implements TestInf,TestInf1{
    @Override
    public void eat(){
        System.out.println("eat");
    }

    @Override
    public void sleep(){
        System.out.println("sleep");
    }

}
