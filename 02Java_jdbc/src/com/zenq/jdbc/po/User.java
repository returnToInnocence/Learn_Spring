package com.zenq.jdbc.po;

public class User {
    //自定义构造方法传参，对user对象初始化
    public User(int itemId, String itemName, int itemValue){
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemValue = itemValue;
    }
    //封装元素的属性
    int itemId;
    String itemName;
    int itemValue;
    //子类重写父类Object类的toString方法
    @Override
    public String toString(){
        return "User [id=" + itemId + ", username=" + itemName + ", password="+ itemValue +"] ";
    }
}