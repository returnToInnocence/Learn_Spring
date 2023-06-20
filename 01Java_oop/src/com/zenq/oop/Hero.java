package com.zenq.oop;

public class Hero {
    String name;
    int hp;
    int mp;

    /*
    * 这里展示无参的构造函数
    * */
    public Hero(){
        System.out.println("这个是HERO的构造！");
        name = "刘备";
        hp = 700;
        mp = 300;
    }

    /*
    * 局部变量和全局变量这里有体现
    * 参数和对象成员变量名同名时的情况，使用this
    * */
    public Hero(String name, int hp, int mp){
            System.out.println("这个是HERO的构造！");
            this.name = name;
            this.hp = hp;
            this.mp = mp;
        }

    public void skill1(){
        System.out.println("释放技能1");
    }
}
